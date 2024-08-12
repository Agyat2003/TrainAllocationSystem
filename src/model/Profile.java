package model;

public class Profile {
    private String loginID;
    private String name;
    private int age;
    private String trainName;
    private int boogieNumber;
    private int seatNumber;


    public Profile(String loginID, String name, int age) {
        this.loginID = loginID;
        this.name = name;
        this.age = age;
        this.trainName = null;
        this.boogieNumber = -1;
        this.seatNumber = -1;
    }

    // Getters and Setters
    public String getLoginID() {
        return loginID;
    }

    public void setLoginID(String loginID) {
        this.loginID = loginID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getTrainName() {
        return trainName;
    }

    public void setTrainName(String trainName) {
        this.trainName = trainName;
    }

    public int getBoogieNumber() {
        return boogieNumber;
    }

    public void setBoogieNumber(int boogieNumber) {
        this.boogieNumber = boogieNumber;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }

    //toString
    @Override
    public String toString() {
        return "Profile{" +
                "loginID='" + loginID + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", trainName='" + trainName + '\'' +
                ", boogieNumber=" + boogieNumber +
                ", seatNumber=" + seatNumber +
                '}';
    }
}
