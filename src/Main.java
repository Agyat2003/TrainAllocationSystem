import java.util.Scanner;

import TrainAllocationSystem.util.InputUtil;
import service.ProfileService;
import service.TrainService;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ProfileService profileService = new ProfileService();
        TrainService trainService = new TrainService(profileService);

        while (true) {
            System.out.println("Enter your choice:");
            System.out.println("1. Enter Profile");
            System.out.println("2. Enter Train Choice");
            System.out.println("3. Display Person Information");
            System.out.println("4. Display Complete Information");
            System.out.println("5. Display Train Status");
            System.out.println("6. Exit");

            int choice = InputUtil.getIntInput(scanner, "Choice");

            switch (choice) {
                case 1:
                    System.out.println("Enter Profile:");
                    String name = InputUtil.getStringInput(scanner, "Name");
                    int age = InputUtil.getIntInput(scanner, "Age");
                    String loginId = profileService.registerProfile(name, age);
                    System.out.println("Profile registered successfully. Your login ID is: " + loginId);
                    break;

                case 2:
                    System.out.println("Enter Train Choice:");
                    String loginIdForTrain = InputUtil.getStringInput(scanner, "Login ID");
                    System.out.println("Available Trains:");
                    System.out.println("1. Train 1");
                    System.out.println("2. Train 2");
                    System.out.println("3. Train 3");
                    String trainChoice = InputUtil.getStringInput(scanner, "Train Choice");
                    String allocationResult = trainService.allocateSeat(loginIdForTrain, trainChoice);
                    System.out.println(allocationResult);
                    break;

                case 3:
                    System.out.println("Display Person Information:");
                    String loginIdForInfo = InputUtil.getStringInput(scanner, "Login ID");
                    if (profileService.isProfileExist(loginIdForInfo)) {
                        String profileInfo = profileService.getAllProfilesInfo();
                        System.out.println(profileInfo);
                    } else {
                        System.out.println("No profile found with the provided login ID.");
                    }
                    break;

                case 4:
                    System.out.println("Display Complete Information:");
                    String allProfilesInfo = profileService.getAllProfilesInfo();
                    System.out.println(allProfilesInfo);
                    break;

                case 5:
                    System.out.println("Display Train Status:");
                    String trainStatus = trainService.getTrainStatus();
                    System.out.println(trainStatus);
                    break;

                case 6:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }
}
