import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.lang.InterruptedException;

public class Main {
    public static void main(String[] args) {
        //game introduction
        System.out.println("\nHello human! Let's have a friendly game of rock paper scissors!");
        System.out.println("Select your object each round by choosing 'R' for rock, 'P' for paper, " +
                "or 'S' for scissors.");

        try {
            TimeUnit.MILLISECONDS.sleep(1000);
        } catch (InterruptedException ie)
        {
            System.out.println("This shouldn't be here...");
            ie.fillInStackTrace();
        }

        System.out.println("\nYou can exit the game anytime by pressing X. Are you ready?");

        try {
            TimeUnit.MILLISECONDS.sleep(1500);
        } catch (InterruptedException ie)
        {
            System.out.println("Nothing to see here :D!");
            ie.fillInStackTrace();
        }

        System.out.println("\nAlright! Let's do this!");

        //rock paper scissors game
        Integer round = 0;
        Integer userScore = 0, computerScore = 0;
        Integer computerInt = 0;
        Integer rockIndex = 0, paperIndex = 1, scissorsIndex = 2, maxIndex = scissorsIndex;

        String[] inputArray = new String[] {"Rock", "Paper", "Scissors"};

        while (true) {
            round++;

            try {
                TimeUnit.MILLISECONDS.sleep(1000);
            } catch (InterruptedException ie)
            {
                System.out.println("This shouldn't be here...");
                ie.fillInStackTrace();
            }

            System.out.println("\n========================");
            System.out.println("Round #" + round);
            System.out.println("----------");

            while (true) {
                System.out.println("What will you play? (R/P/S or X to leave game)");

                computerInt = new Random().nextInt(maxIndex + 1);

                java.util.Scanner userInputScanner = new Scanner(System.in);
                String userInput = userInputScanner.nextLine();

                if (userInput.isEmpty()) {
                    System.out.println("Please try again.");
                    continue;
                }

                if (userInput.equalsIgnoreCase("X")) {
                    System.out.println("Thanks for playing with me! Goodbye!");
                    return;
                }

                String cutUserInput = userInput.substring(0, 1).toUpperCase();

                if (cutUserInput.equals("R")) {
                    System.out.println("\nYou have chosen: Rock");
                    System.out.println("Computer chose: " + inputArray[computerInt]);

                    if (computerInt == scissorsIndex) {
                        System.out.println("\nYou Win!");

                        userScore++;

                        System.out.println("Your Score: " + userScore +
                                           " | Computer Score: " + computerScore);
                    } else if (computerInt == rockIndex) {
                        System.out.println("\nDraw!");

                        System.out.println("Your Score: " + userScore +
                                " | Computer Score: " + computerScore);
                    } else {
                        System.out.println("\nComputer Wins!");

                        computerScore++;

                        System.out.println("Your Score: " + userScore +
                                " | Computer Score: " + computerScore);
                    }
                    break;
                } else if (cutUserInput.equals("P")) {
                    System.out.println("\nYou have chosen: Paper");
                    System.out.println("Computer chose: " + inputArray[computerInt]);

                    if (computerInt == rockIndex) {
                        System.out.println("\nYou Win!");

                        userScore++;

                        System.out.println("Your Score: " + userScore +
                                " | Computer Score: " + computerScore);
                    } else if (computerInt == paperIndex) {
                        System.out.println("\nDraw!");

                        System.out.println("Your Score: " + userScore +
                                " | Computer Score: " + computerScore);
                    } else {
                        System.out.println("\nComputer Wins!");

                        computerScore++;

                        System.out.println("Your Score: " + userScore +
                                " | Computer Score: " + computerScore);
                    }
                    break;
                } else if (cutUserInput.equals("S")) {
                    System.out.println("\nYou have chosen: Scissors");
                    System.out.println("Computer chose: " + inputArray[computerInt]);

                    if (computerInt == paperIndex) {
                        System.out.println("\nYou Win!");

                        userScore++;

                        System.out.println("Your Score: " + userScore +
                                " | Computer Score: " + computerScore);
                    } else if (computerInt == scissorsIndex) {
                        System.out.println("\nDraw!");

                        System.out.println("Your Score: " + userScore +
                                " | Computer Score: " + computerScore);
                    } else {
                        System.out.println("\nComputer Wins!");

                        computerScore++;

                        System.out.println("Your Score: " + userScore +
                                " | Computer Score: " + computerScore);
                    }
                    break;
                } else {
                    System.out.println("Please try again.");
                }
            }

        }

    }
}