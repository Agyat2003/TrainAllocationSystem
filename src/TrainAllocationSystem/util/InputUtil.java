package TrainAllocationSystem.util;

import java.util.Scanner;

public class InputUtil {

    // Method to get integer input with a prompt
    public static int getIntInput(Scanner scanner, String prompt) {
        System.out.print(prompt + ": ");
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter a valid integer.");
            System.out.print(prompt + ": ");
            scanner.next();  // Clear the invalid input
        }
        return scanner.nextInt();
    }

    // Method to get string input with a prompt
    public static String getStringInput(Scanner scanner, String prompt) {
        System.out.print(prompt + ": ");
        return scanner.next().trim();
    }

    // Method to get string input with a prompt and a validation loop
    public static String getValidatedStringInput(Scanner scanner, String prompt, String[] validChoices) {
        String input;
        boolean isValid;
        do {
            System.out.print(prompt + ": ");
            input = scanner.next().trim();
            isValid = false;
            for (String choice : validChoices) {
                if (input.equalsIgnoreCase(choice)) {
                    isValid = true;
                    break;
                }
            }
            if (!isValid) {
                System.out.println("Invalid choice. Please choose from " + String.join(", ", validChoices));
            }
        } while (!isValid);
        return input;
    }

    // Method to clear the scanner buffer (useful after calling nextInt before nextLine)
    public static void clearScanner(Scanner scanner) {
        if (scanner.hasNextLine()) {
            scanner.nextLine();
        }
    }
}
