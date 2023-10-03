import java.util.Scanner;

public class Main {

    private static String question1 ()
    {
        return "\n1. Someone's mother had 4 daughters. The first 3 were named April, May, and June. " +
                "What was the fourth child's name?";
    }

    private static String q1Choices ()
    {
        return "A) July" +
                "\nB) March" +
                "\nC) August" +
                "\nD) None of the above\n";
    }

    private static String question2 ()
    {
        return "\nWhat comes next in this sequence? " +
                "\n{Succession, Addition, Multiplication, Exponentiation, Tetration, ...}";
    }

    private static String q2Choices ()
    {
        return "A) Division" +
                "\nB) Pentation" +
                "\nC) Extremation" +
                "\nD) None of the above\n";
    }

    private static String question3 ()
    {
        return "\nWhat is the capital of Zambia?";
    }

    private static String q3Choices ()
    {
        return "A) Harare" +
                "\nB) Paris" +
                "\nC) Lusaka" +
                "\nD) Ndola";
    }

    public static void main(String[] args) {
        System.out.println("\nWelcome to the Very Possible Quiz!");

        while (true) {
            System.out.println("Would you like to start a new game? (Y/N)");
            java.util.Scanner newGame = new java.util.Scanner(System.in);
            String newGameAns = newGame.nextLine();

            if (!newGameAns.isEmpty()) {
                String newGameKey = newGameAns.substring(0, 1).toUpperCase();


                if (newGameKey.equals("Y")) {
                    Integer score = 0;

                    System.out.println("Wonderful! Good luck on the quiz!:");

                    System.out.println(question1());
                    System.out.println(q1Choices());
                    java.util.Scanner q1Input = new java.util.Scanner(System.in);
                    String q1Ans = q1Input.nextLine();

                    if (q1Ans.equalsIgnoreCase("D")) {
                        score++;
                    }

                    System.out.println(question2());
                    System.out.println(q2Choices());
                    java.util.Scanner q2Input = new java.util.Scanner(System.in);
                    String q2Ans = q2Input.nextLine();

                    if (q2Ans.equalsIgnoreCase("B")) {
                        score++;
                    }

                    System.out.println(question3());
                    System.out.println(q3Choices());
                    java.util.Scanner q3Input = new java.util.Scanner(System.in);
                    String q3Ans = q3Input.nextLine();

                    if (q3Ans.equalsIgnoreCase("C")) {
                        score++;
                    }

                    System.out.println("\nCongrats on finishing the Very Possible Quiz! " +
                    "Your score is: " + score + "/3.\n");

                } else if (newGameKey.equals("N")) {
                    System.out.println("Thank you, see you next time!");
                    break;
                }
            } else {
                System.out.println("Please try again.");
            }
        }
    }
}
