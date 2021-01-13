package Stayfishy;
import java.util.*;
public class ControlMethods {


    public static void errorString(){
        System.out.println("You have entered invalid number, enter a new:");}

    //Method that convert a input string to an int. And returns the value as int.
    public int convertInputToInt() {
        Scanner input = new Scanner(System.in);

        while (true) {
            try {
                return Integer.parseInt(input.nextLine());
            } catch (Exception exception) {
                System.out.println("You have inserted invalid integer");
            }


        }

    }
}

