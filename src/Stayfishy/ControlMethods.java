package Stayfishy;
import java.util.*;
public class ControlMethods {
    Scanner input = new Scanner(System.in);

    public static String enterName= "Please enter a name:";
    public static String enterQuantity = "Please enter the amount:";
    public static String errorNumber = "You have entered invalid number, enter a new:";
    public static String errorEnoghMoney ="Sorry you don´t have enough money";
    public static String maxFishToBuy = "Max fish to buy is ";


    //Method that convert a input string to an int. And returns the value as int.
    public int convertInputToInt() {

        while (true) {
            try {
                return Integer.parseInt(input.nextLine());
            } catch (Exception exception) {
                System.out.println("You have inserted invalid integer");
            }
        }
    }

    public String inputString(){
        return input.nextLine();
    }
    public String inputGender(){
        System.out.println("Please input a gender");
        String answer = inputString();
        if ((!answer.equalsIgnoreCase("female")) || (!answer.equalsIgnoreCase("male")))
        {
            System.out.println();
        }

    return "";
    }

}

