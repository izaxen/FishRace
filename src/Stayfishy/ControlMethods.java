package Stayfishy;
import java.util.*;
public class ControlMethods {

    //Method that convert a input string to an int. And returns the value as int.
    public int convertInputToInt() {
        Scanner input = new Scanner(System.in);

        while (true) {
            try {
                int convertedInt = Integer.parseInt(input.nextLine());
                return convertedInt;
            } catch (Exception exception) {
                System.out.println("You have inserted invalid integer");
            }


        }

    }
}

