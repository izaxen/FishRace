package Game;
import java.util.*;
import java.io.*;
public class ControlMethods implements Serializable {


    public static String enterName = "Please enter a name:";
    public static String enterQuantity = "Please enter the amount:";
    public static String errorNumber = "You have entered invalid integer, enter a new:";
    public static String maxFoodToBuy = "Max food to buy is ";
    public static String maxFishToBuy = "Max fish to buy is ";
    public static String errorOutOfStock = " Out of stock";


    public static void clearScreen() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                System.out.println("\n".repeat(60));
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033\143");
            }
        } catch (IOException | InterruptedException ex) {

        }
        System.out.printf("\n");
    }



    public static int convertInputToInt() {
        Scanner input = new Scanner(System.in);

        while (true) {
            try {
                return Integer.parseInt(input.nextLine());
            } catch (Exception exception) {
                System.out.println(errorNumber);
            }
        }
    }


    public static int convertInputToInt(int low,int high) {
        Scanner input = new Scanner(System.in);
        int outputValue = 0;

        while (true) {
            try {
                outputValue = Integer.parseInt(input.nextLine());

            } catch (Exception exception) {

            }
            if((outputValue < low)|| (outputValue > high))
                System.out.println(errorNumber);
            else return outputValue;
        }
    }

    public static String inputString() {
        Scanner input = new Scanner(System.in);
        return input.nextLine();
    }
}

