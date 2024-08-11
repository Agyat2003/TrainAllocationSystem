package TrainAllocationSystem.util;

import java.util.Scanner;

public class InputUtil {
    private static Scanner scanner = new Scanner(System.in);

    public static int getInt(String input) {
        System.out.print(input);
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter a number.");
            scanner.next();
            System.out.print(input);
        }
        return scanner.nextInt();
    }

    public static String getString(String input) {
        System.out.print(input);
        return scanner.next();
    }
}
