package model;

import java.util.ArrayList;
import java.util.List;

public class Train {
    private String trainName;
    private int totalBoogies = 3;
    private int seatsPerBoogie = 2;
    private List<String> seatAllocations;

    public Train(String trainName) {
        this.trainName = trainName;
        this.seatAllocations = new ArrayList<>(totalBoogies * seatsPerBoogie);
    }

    // Getters
    public String getTrainName() {
        return trainName;
    }

    public int getTotalSeats() {
        return totalBoogies * seatsPerBoogie;
    }

    public int getBookedSeats() {
        return seatAllocations.size();
    }
    public String allocateNextSeat(String loginId) {
        int currentBookings = seatAllocations.size();

        if (currentBookings >= getTotalSeats()) {
            return "No seats available in " + trainName;
        }

        int boogieNumber = (currentBookings /seatsPerBoogie) + 1;
        int seatNumber = (currentBookings % seatsPerBoogie) + 1;

        seatAllocations.add(loginId);

        return String.format("Train: %s Boogie: %d Seat: %d" , trainName ,boogieNumber , seatNumber);
    }
}
