package Stayfishy;

import java.util.Scanner;

public class MenuSystem {


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

    public void mainMenu(Players players) {

        System.out.printf("%1$s%n* \t\t\t\t\tStayfishy main menu\t\t\tRound: %4$d\t*%n" +
                "* Playername: %2$s\t\t\t\t\t\t\tBank: %3$skr*%1$s%n",starRow, players.getName(), players.getMoney(),Game.gameRoundsLeft);
        System.out.println("* [1] Buy fish\n" +
                "* [2] Sell your fish\n" +
                "* [3] Buy food\n" +
                "* [4] Feed your fish\n" +
                "* [5] Try to breed your fish");
    }

    public void fishMenu() {
        System.out.printf("%1$s%n* \t\t\t\t\tStayfishy fish shop \t\t\t\t\t*%1$s%n",starRow);
        System.out.println(
                "* [1] Buy Minow\t\t\t\t\t\t\t 30:-\n" +
                "* [2] Buy Corydoras Sterbai\t\t\t\t 80:-\n" +
                "* [3] Buy Angelfish\t\t\t\t\t\t 150:-\n" +
                "* [4] Buy Pirahna\t\t\t\t\t\t 300:-\n" +
                "* [5] Buy Hyperancistrus Zebra\t\t\t 1050:-\n" +
                "* [6] End turn");
    }

    public void foodMenu(Players players) {

        System.out.printf("%1$s%n* \t\t\t\t\tStayfishy food shop \t\t\t\t\t*%1$s%n",starRow);

        System.out.println("* [1] Buy meat\n" +
                "* [2] Buy flakes\n" +
                "* [3] Buy tetrabits\n" +
                "* [4] End turn");

    }


}
