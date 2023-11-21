import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //First Array Problem
        System.out.println("============================================================");
        System.out.println("Array #1");
        Integer[] array1 = new Integer[20];
        Integer count = 0;

        System.out.print("\nThe array is: { ");
        for (Integer i = 0; i < 20; i++) {
            array1[i] = new Random().nextInt(6) + 1;
            System.out.print(array1[i] + " ");

            if (array1[i] == 1) {
                count++;
            }
        }
        System.out.print("}.");

        System.out.println("\nThere are " + count + " x 1's in this array.");

        //Second Array Problem
        System.out.println("============================================================");
        System.out.println("Array #2");
        Integer[] array2 = new Integer[10];
        Integer i, sum = 0, average;

        System.out.print("\nThe array is: { ");
        for (i = 0; i < 10; i++) {
            array2[i] = new Random().nextInt(100) + 1;
            System.out.print(array2[i] + " ");

            sum += array2[i];
        }
        System.out.print("}.");

        average = sum / 10;
        System.out.println("\nThe average of this array is " + average + ".");

        //Third Array Problem
        System.out.println("============================================================");
        System.out.println("Array #3");

        System.out.print("\nPlease choose two positions from the previous array " +
                "that you would like to switch. (1-10)");

        Integer userInputValue1, userInputValue2;

        while (true) {
            System.out.println("\nYour first value is:");

            java.util.Scanner firstSwitchScanner = new Scanner(System.in);
            String firstSwitchValue = firstSwitchScanner.nextLine();

            if (firstSwitchValue.isEmpty()) {
                System.out.print("\nPlease try again and input a value between 1 and 10.");
                continue;
            }

            if (firstSwitchValue.matches("\\d+")) {
                userInputValue1 = Integer.parseInt(firstSwitchValue);

                if (userInputValue1 < 1) {
                    System.out.println("\nPlease try again and input a value between 1 and 10.");
                    continue;
                } else if (userInputValue1 > 10) {
                    System.out.println("\nPlease try again and input a value between 1 and 10.");
                    continue;
                } else {
                    System.out.print("Great! ");
                    break;
                }
            }
        }

        while (true) {
            System.out.print("Your second value is:");

            java.util.Scanner secondSwitchScanner = new Scanner(System.in);
            String secondSwitchValue = secondSwitchScanner.nextLine();

            if (secondSwitchValue.isEmpty()) {
                System.out.print("\nPlease try again and input a value between 1 and 10.");
                continue;
            }

            if (secondSwitchValue.matches("\\d+")) {
                userInputValue2 = Integer.parseInt(secondSwitchValue);

                if (userInputValue2 < 1) {
                    System.out.println("\nPlease try again and input a value between 1 and 10.");
                    continue;
                } else if (userInputValue2 > 10) {
                    System.out.println("\nPlease try again and input a value between 1 and 10.");
                    continue;
                } else {
                    System.out.println("\nYou will be switching positions " + userInputValue1 +
                                       " and " + userInputValue2 + ".");
                    break;
                }
            }
        }

        Integer temp = array2[userInputValue1 - 1];
        array2[userInputValue1 - 1] = array2[userInputValue2 - 1];
        array2[userInputValue2 - 1] = temp;

        System.out.println("\nHere is the new array: ");
        System.out.print("{ ");
        for (i = 0; i < 10; i++) {
            System.out.print(array2[i] + " ");
        }
        System.out.print("}.");

        //Fourth Array Problem
        System.out.println("\n============================================================");
        System.out.println("Array #4");

        Integer[] newArray = new Integer[10];

        for (i = 0; i < 10; i++) {
            newArray[i] = array2[9 - i];
        }

        System.out.println("\nHere is the previous array, reversed: ");
        System.out.print("{ ");
        for (i = 0; i < 10; i++) {
            System.out.print(newArray[i] + " ");
        }
        System.out.print("}.");
        System.out.println("\n============================================================");
    }
}