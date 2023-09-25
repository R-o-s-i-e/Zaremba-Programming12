import java.text.DecimalFormat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("\nWelcome to Mr. Zaremba's Awesome Hot Dog Stand! Feel free to take a look at our awesome menu!");

        //Menu Data
        DecimalFormat twoPlaces = new DecimalFormat("0.00");

        int hotdogIndex = 0;
        int drinkIndex  = 1;

        String[]  menuItem = new String[]  {"Zaremba's Hot Dog™", "Soft Drink"};
        double[]  unitCost = new double[]  {5.50, 2.00};

        //Menu
        System.out.print("\n             Our Awesome Menu\n");

        System.out.println("------------------------------------------");
        System.out.format("| %20s | %15s |\n", "Menu Item", "Unit Price ($)");
        System.out.println("------------------------------------------");

        for (int i = 0; i < 2; i ++)
        {
            System.out.format("| %20s | %15s |\n", menuItem[i], twoPlaces.format(unitCost[i]));
        }

        System.out.println("------------------------------------------");
        System.out.format("| %38s |\n", "A 12% tax applies to your purchase.");
        System.out.println("------------------------------------------\n");

        //Scanner
        int[]    Count = new int[2];
        double[] Cost  = new double[2];

        System.out.println("How many hot dogs would you like to order?");
        java.util.Scanner hotdogScanner = new java.util.Scanner(System.in);
        String hotdogStr   = hotdogScanner.next();
        Count[hotdogIndex] = Integer.parseInt(hotdogStr);

        System.out.println("And how many drinks will you be having today?");
        java.util.Scanner drinkScanner = new Scanner(System.in);
        String drinkStr   = drinkScanner.next();
        Count[drinkIndex] = Integer.parseInt(drinkStr);

        //Total Cost Calculation
        double Tax = 0.12;
        Cost[hotdogIndex] = unitCost[hotdogIndex] * Count[hotdogIndex];
        Cost[drinkIndex]  = unitCost[drinkIndex]  * Count[drinkIndex];

        //Receipt
        System.out.println("\nGot it! Here is your receipt:\n");
        
        System.out.println("-----------------------------------------------------------");
        System.out.format("| %20s | %15s | %1s | %10s |\n", "Menu Item", "Unit Price ($)", "#", "Cost ($)");
        System.out.println("-----------------------------------------------------------");

        double pretaxCost = 0;
        for (int n = 0; n < 2; n ++)
        {
            System.out.format("| %20s | %15s | %1s | %10s |\n", menuItem[n], twoPlaces.format(unitCost[n]), Count[n], twoPlaces.format(Cost[n]));
            pretaxCost += Cost[n];
        }

        System.out.println("-----------------------------------------------------------");
        System.out.format("| %20s | %32s |\n", "Tax", twoPlaces.format(Tax * pretaxCost));
        System.out.println("-----------------------------------------------------------");

        double totalCost = pretaxCost * (1 + Tax);
        System.out.format("| %20s | %32s |\n", "TOTAL", twoPlaces.format(totalCost));
        System.out.println("-----------------------------------------------------------");

        System.out.println("\nEnjoy your meal!");
    }
}