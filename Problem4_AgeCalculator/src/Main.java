import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("\nHello! What's your name?");

        java.util.Scanner inputScanner = new java.util.Scanner(System.in);
        String name = inputScanner.nextLine();
        String formattedName = name.substring(0, 1).toUpperCase() + name.substring(1).toLowerCase();

        System.out.println("\nThanks " + formattedName + "! How old are you?");
        Integer retryCount = 3;

        for (int i = 0; i < retryCount; i++) {
            String ageStr = inputScanner.next();
            if (ageStr.matches("\\d+")) {
                Integer age = Integer.parseInt(ageStr);

                if (age <= 16) {
                    System.out.println("\nNice to meet you " + formattedName + "! You cannot drive yet.");
                } else if (age <= 17) {
                    System.out.println("\nYou can drive but you can't vote yet, " + formattedName + ".");
                } else if (age <= 24) {
                    System.out.println("\n" + formattedName + ", you can vote but can't rent a car yet.");
                } else {
                    System.out.println("\nCongratulations, " + formattedName + "! You can pretty much do anything!");
                }
            } else {
                if (i < 2) {
                    System.out.println("\nAge must be in digits. Please try again.");
                }
            }
        }
    }
}