package Game;
import java.util.*;
public class ControlMethods {


    public static String enterName = "Please enter a name:";
    public static String enterQuantity = "Please enter the amount:";
    public static String errorNumber = "You have entered invalid number, enter a new:";
    public static String maxFoodToBuy = "Max food to buy is ";
    public static String maxFishToBuy = "Max fish to buy is ";
    public static String errorOutOfStock = " Out of stock";


    //Method that convert a input string to an int. And returns the value as int.
    public static int convertInputToInt() {
        Scanner input = new Scanner(System.in);

        while (true) {
            try {
                return Integer.parseInt(input.nextLine());
            } catch (Exception exception) {
                System.out.println("You have inserted invalid integer");
            }
        }
    }

    public static String inputString() {
        Scanner input = new Scanner(System.in);
        return input.nextLine();
    }
}

