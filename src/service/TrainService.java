package service;

import model.Train;
import service.ProfileService;

import java.sql.SQLOutput;
import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;

public class TrainService {
    private Map<String, Train> trains;
    private ProfileService profileService;

    public TrainService(ProfileService profileService) {
        this.profileService = profileService;
        this.trains = new HashMap<>();
        initializeTrains();
    }

    // Method to get the train object by its name
    public Train getTrain(String trainName) {
        return trains.get(trainName);
    }

    // Method to allocate a seat in a train
    public String allocateSeat(String loginId, String trainChoice) {

        if (!profileService.isProfileExist(loginId)) {
            return "Profile not found for login ID: " + loginId;
        }

        Train train = getTrain(trainChoice);

        if (train == null) {
            return "Invalid train choice: " + trainChoice;
        }


        String seatAllocationResult = train.allocateNextSeat(loginId);
        if (seatAllocationResult.startsWith("No seats")) {
            return seatAllocationResult;
        }

        profileService.updateProfileWithTrainInfo(loginId, trainChoice, seatAllocationResult);

        return "Seat allocated successfully: " + seatAllocationResult;
    }

    // Method to get the status of all trains
    public String getTrainStatus() {
        StringJoiner statusReport = new StringJoiner("\n");

        for (Map.Entry<String, Train> entry : trains.entrySet()) {
            String trainName = entry.getKey();
            Train train = entry.getValue();

            int totalSeats = train.getTotalSeats();
            int bookedSeats = train.getBookedSeats();
            int availableSeats = totalSeats - bookedSeats;

            String status = String.format(
                    "Train: %s\nTotal Seats: %d\nBooked Seats: %d\nAvailable Seats: %d\n",
                    trainName, totalSeats, bookedSeats, availableSeats
            );

            statusReport.add(status);
        }

        return statusReport.toString();
    }

    private void initializeTrains() {
        trains.put("1", new Train("Train 1"));
        trains.put("2", new Train("Train 2"));
        trains.put("3", new Train("Train 3"));
    }
}
