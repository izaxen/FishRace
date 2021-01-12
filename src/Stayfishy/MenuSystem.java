package Stayfishy;

import java.util.Scanner;

public class MenuSystem {
    private Scanner input = new Scanner(System.in);
    private String starRow = "\n*************************************************************";

    private String starRowTitle = "\n*************************************************************\n" +
            "* \t\t\t\t\t\t Stayfishy\t\t\t\t\t\t\t*\n" +
            "*************************************************************";

    public void mainScreen() {

        System.out.printf("%n%1$s%n*\t\t\t\tWelcome to the game Stayfishy\t\t\t\t*%1$s%n", starRow);
        System.out.printf("%n%s%n* The rules of the game is, buy and sell your fishes. Don´t *\n" +
                "* forget to buy food and feed them or they will die. You can*%n" +
                "* also try to breed them to earn more money. You can do one *%n" +
                "* choice a round. When everybody have played the last round *%n" +
                "* you will sell all your fishes and winner is the one with  *%n" +
                "* the most money left.%1$s%n", starRow);

        //System.out.println("Press enter to continue");
        //input.nextLine();
        //System.out.println("\n".repeat(30));

    }

    public void mainMenu() {
        System.out.printf("%1$s%n* \t\t\t\t\tStayfishy main menu \t\t\t\t\t*%1$s%n",starRow);
        System.out.println("* [1] Buy fish\n" +
                "* [2] Buy food\n" +
                "* [3] Feed your fish\n" +
                "* [4] Try to breed our fishes");
    }

    public void foodMenu() {
        System.out.printf("%1$s%n* \t\t\t\t\tStayfishy food shop \t\t\t\t\t*%1$s%n",starRow);

        System.out.println("* [1] Buy meat\n" +
                "* [2] Buy flakes\n" +
                "* [3] Buy tetrabits\n" +
                "* [4] Leave shop");

    }

    public void fishMenu() {
        System.out.printf("%1$s%n* \t\t\t\t\tStayfishy fish shop \t\t\t\t\t*%1$s%n",starRow);
        System.out.println("* [1] Buy Angelfish\n" +
                "* [2] Buy Corydoras Sterbai\n" +
                "* [3] Buy Hyperancistrus Zebra\n" +
                "* [4] Buy Pirahna\n" +
                "* [5] Buy Minnow\n" +
                "* [6] Leave fishshop");
    }
}
