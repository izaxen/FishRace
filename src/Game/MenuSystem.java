package Game;

import Animals.Animal;

public class MenuSystem {


    public static String starRow = "*".repeat(61);

    private String starRowTitle = "\n" + "*".repeat(61) + "\n" +
            "* \t\t\t\t\t\t Stayfishy\t\t\t\t\t\t\t*\n" +
            "*".repeat(61);

    public void mainScreen() {

        System.out.printf("%n%1$s%n*\t\t\t\tWelcome to the game Stayfishy\t\t\t\t*%n%1$s%n", starRow);
        System.out.printf("%n%s%n* The rules of the game is, buy and sell your fishes. Don´t *\n" +
                "* forget to buy food and feed them or they will die. You can*%n" +
                "* also try to breed them to earn more money. You can do one *%n" +
                "* choice a round. When everybody have played the last round *%n" +
                "* you will sell all your fishes and winner is the one with  *%n" +
                "* the most money left.%n%1$s%n", starRow);

        //System.out.println("Press enter to continue");
        //input.nextLine();
        //System.out.println("\n".repeat(30));

    }

    public void mainMenu(Player player) {

        System.out.printf("%1$s%n* \t\t\t\t\tStayfishy main menu\t\t\tRound: %4$d\t*%n" +
                "* Playername: %2$s\t\t\t\t\t\t\tBank: %3$skr*%n%1$s%n", starRow, player.getName(), player.getMoney(), Game.gameRoundsLeft);
        System.out.println(
                "* [1] Buy fish" + "\t".repeat(12) + "*\n" +
                        "* [2] Sell your fish" + "\t".repeat(10) + "*\n" +
                        "* [3] Buy food" + "\t".repeat(12) + "*\n" +
                        "* [4] Feed your fish" + "\t".repeat(10) + "*\n" +
                        "* [5] Try to breed your fish" + "\t".repeat(8) + "*\n");
    }

    public void fishMenu(int availableMoney, Player player) {

        System.out.printf("%1$s%n* \t\t\t\t\tStayfishy fish menu\t\t\tRound: %4$d\t*%n" +
                "* Playername: %2$s\t\t\t\t\t\t\tBank: %3$skr*%n%1$s%n", starRow, player.getName(), player.getMoney(), Game.gameRoundsLeft);

        if (availableMoney >= Animal.Fishprice.MINOW.price)
            System.out.println("* [1] Buy " + Animal.Fishprice.MINOW + "\t".repeat(8) + Animal.Fishprice.MINOW.price + " kr\t\t\t*");
        else
            System.out.println("* [ ] " + Animal.Fishprice.MINOW + "\t".repeat(9) + "Out of stock\t*");

        if (availableMoney >= Animal.Fishprice.CORYDORAS_STERBAI.price)
            System.out.println("* [2] Buy " + Animal.Fishprice.CORYDORAS_STERBAI + "\t".repeat(5) + Animal.Fishprice.CORYDORAS_STERBAI.price + " kr\t\t\t*");
        else
            System.out.println("* [ ] " + Animal.Fishprice.CORYDORAS_STERBAI + "\t".repeat(6) + "Out of stock\t*");

        if (availableMoney >= Animal.Fishprice.ANGELFISH.price)
            System.out.println("* [3] Buy " + Animal.Fishprice.ANGELFISH + "\t".repeat(7) + Animal.Fishprice.ANGELFISH.price + " kr\t\t\t*");
        else
            System.out.println("* [ ] " + Animal.Fishprice.ANGELFISH + "\t".repeat(8) + "Out of stock\t*");

        if (availableMoney >= Animal.Fishprice.PIRANHA.price)
            System.out.println("* [4] Buy " + Animal.Fishprice.PIRANHA + "\t".repeat(7) + Animal.Fishprice.PIRANHA.price + " kr\t\t\t*");
        else
            System.out.println("* [ ] " + Animal.Fishprice.PIRANHA + "\t".repeat(8) + "Out of stock\t*");

        if (availableMoney > Animal.Fishprice.HYPERANCISTRUS_ZEBRA.price)
            System.out.println("* [5] Buy " + Animal.Fishprice.HYPERANCISTRUS_ZEBRA + "  " + "\t".repeat(4) + Animal.Fishprice.HYPERANCISTRUS_ZEBRA.price + " kr\t\t\t*");
        else System.out.println("* [ ] " + Animal.Fishprice.HYPERANCISTRUS_ZEBRA + "\t".repeat(5) + "Out of stock\t*");

        System.out.println("* [6] End turn" + "\t".repeat(12) + "*");


    }


    public void foodMenu(Player player) {

        System.out.printf("%1$s%n* \t\t\t\t\tStayfishy food shop \t\t\t\t\t*%n%1$s%n", starRow);

        System.out.println(
                "* [1] Buy meat\n" +
                        "* [2] Buy flakes\n" +
                        "* [3] Buy tetrabits\n" +
                        "* [4] End turn");

    }

    public void sellFishMenu(Player player) {
        System.out.printf("%1$s%n* \t\t\t\tStayfishy sell fish menu\t\tRound: %4$d\t*%n" +
                "* Playername: %2$s\t\t\t\t\t\t\tBank: %3$skr*%n%1$s%n", starRow, player.getName(), player.getMoney(), Game.gameRoundsLeft);
        System.out.println(
                "* [1] Show list of available fish\n" +
                        "* [2] Choose fish to sell\n" +
                        "* [3] End round");
    }


}
