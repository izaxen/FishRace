package Game;
import java.util.*;
import java.io.*;
public class GameUtils implements Serializable {


    public static String enterName = "Please enter a name:";
    public static String randomName = "If you want a random name leave blank and press enter ";
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
        System.out.println("\n");
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

    public static void waitMilliSeconds(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public static void helpScreen(){
        System.out.printf("%n%1$s%n*\t\t\t\t\t\tWelcome to Stayfishy help section\t\t\t\t\t\t *%n%1$s%n", MenuSystem.starRow);
        System.out.printf("%n%s%n* \t\t\tThe rules of the game is, buy and sell your fishes. Don´t \t\t\t *\n" +
                "* \t\t\tforget to buy food and feed them or they will die. You can\t\t\t *%n" +
                "* \t\t\talso try to breed them to earn more money. You can do one\t\t\t *%n" +
                "* \t\t\tchoice a round. When everybody have played the last round\t\t\t *%n" +
                "* \t\t\tyou will sell all your fishes and winner is the one with\t\t\t *%n" +
                "* \t\t\tthe most money left." +"\t".repeat(12)+" *%n" +
                "* \t\t\tYour fish will age and lose health every round which make\t\t\t *%n" +
                "* \t\t\timpact on your value on your fish. Keep an eye on the value\t\t\t *%n" +
                "* \t\t\ton your fish so you know when you can sell it and earn the most.\t *%n%1$s%n", MenuSystem.starRow);

        System.out.println(
                "\n* FISHTYPES:\n\n" +
                "* MINNOW:\n" +
                "  Eats flakes and are easy to breed. They can produce up to 15 offsprings and has\n" +
                "  best value when they are 2 years old and they live for 5 years\n\n" +
                "* CORYDORAS STERBAI:\n" +
                "  Eats Tetrabits and has around 50% chance to breed. They can produce up to 27\n" +
                "  offsprings and has best value when they are 2 years old and they live for 20 years\n\n" +
                "* ANGELFISH:\n" +
                "  Eats all food, less then 50% chance to breed. They can produce up to 20 offspring\n" +
                "  and has the best value between 2-3 years old\n\n" +
                "* PIRANHA:\n" +
                "  Eats meat and little harder to breed. They can produce up to 30 offspring and has\n" +
                "  the value between 3-4 years old\n\n" +
                "* HYPERANCISTRUS ZEBRA:\n" +
                "  The crownjewel that eats tetrabits and meat. It is very hard to breed but their \n" +
                "  offspring are covoted and has very high value as breeded. Their best value is up\n" +
                "   to 2 years old and they live for10 years.\n\n" +
                        "\t\t\t** Breeded fish has a bigger value then shop bought fish.** ");


        System.out.println("\nPress enter to continue");
        GameUtils.inputString();


    }

    public static void introFish() {


        System.out.println("                                         ______");
        System.out.println("                              (''''''''''      `-..");
        System.out.println("                            ___)           _       `.");
        System.out.println("                        ,,-'       _,.,-'']-'`--.'|  )");
        System.out.println("       _______________/________,__'_____'____________\\_____");
        System.out.println("      (_____________________________________________________)");
        System.out.println("     ,'             /     ,'/   /    /    / .'  ,-'     `-. `.");
        System.out.println("    , .---._         |    ,'  |   |   |    / /  ,'  _,v._    ``.`.");
        System.out.println("   / (      ^v_       `-./    |  /   ,    / /  /  ,'  ,' `      ` \\");
        System.out.println("  '  `         `.       /|    |  |   |    ) ) /  /   /    `      ` `.");
        System.out.println(" /    `          ^.    / \\    |  |   |   / / /  (    \\     )     `   \\");
        System.out.println(" ;     `           `. /   \\   |  |   |  | | /    \\    `..,'       \\   :");
        System.out.println(" ;       `            `     `. |  |   |  \\ | |     --..=--          \\  :");
        System.out.println("/         `                   -'  |   |   `| |\\                     `:  \\");
        System.out.println(";            )                      \\  |      ||                      \\   :");
        System.out.println("\\|         /                        '.'      ||      `.               \\   |");
        System.out.println("|          |                                  \\|        ` .           /   |");
        System.out.println("|          |                                  -\\           `'-=____,,v    ;");
        System.out.println(":           \\                                   ),                  /     :");
        System.out.println(" \\            )                                  \\,               ,'     /");
        System.out.println("  :          ,        ,.                           \\,          ,,'      ;");
        System.out.println("  :         ,         | `.                           \\,__ _,,-'         ;");
        System.out.println("   \\       ,         /    `._                       __.-'/             /");
        System.out.println("    `.     ,        /        --...____.. _,-]'     )|   /            ,'");
        System.out.println("      \\   (        /                    '  -       '   /            /");
        System.out.println("       `.  \\     ,'                      v'      ,'   /           ,'");
        System.out.println("         `. `---'                       .'     _'   ,'          ,'");
        System.out.println("           `.                           |    ,' ^..'          ,'");
        System.out.println("             `-.                        `.,-'              ,-'");
        System.out.println("                `--.-----------------------------------.-'");
        System.out.println("                  (_____________________________________)");



        // Cred to JavE/Zot
        // https://asciiart.website/index.php?art=animals/fish


    }


}

