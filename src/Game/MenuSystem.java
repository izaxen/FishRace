package Game;

import Animals.Animal;
import Food.*;

import java.io.Serializable;

public class MenuSystem implements Serializable {

    private final Game myGame;

    public MenuSystem(Game mygame){
        this.myGame = mygame;
    }
    public static String starRow = "*".repeat(82);

    public void mainScreen() {

        System.out.printf("%n%1$s%n*\t\t\t\t\t\t\t\tWelcome to Stayfishy\t\t\t\t\t\t\t *%n%1$s%n", MenuSystem.starRow);
        System.out.printf("%n%s%n* \t\t\tThe rules of the game is, buy and sell your fishes. Don´t \t\t\t *\n" +
                "* \t\t\tforget to buy food and feed them or they will die. You can\t\t\t *%n" +
                "* \t\t\talso try to breed them to earn more money. You can do one\t\t\t *%n" +
                "* \t\t\tchoice a round. When everybody have played the last round\t\t\t *%n" +
                "* \t\t\tyou will sell all your fishes and winner is the one with\t\t\t *%n" +
                "* \t\t\tthe most money left." +"\t".repeat(12)+" *%n%1$s%n", MenuSystem.starRow);

        GameUtils.waitMilliSeconds(3000);
     }

    public void mainMenu(Player player) {

        System.out.printf("%s%n*\t\t\t\t\t\t\t\t%s \t\t\t\t\t\t\t *%n" +
                        "* \tPlayername: %-14.12s \t\tBank: %6.6s kr \t\t\t\tRound: %s \t *%n" +
                        "* \tOwned fish: %-3.3s\t\t\tOwned food: FLAKES: %-3.3s\tTETRABITS: %-3.3s\tMEAT: %-3.3s\t *%n" +
                        "%1$s%n", starRow, "Starfishy Fish Menu ", player.getName(), player.getMoney(), myGame.getGameRoundsLeft(), player.getOwnedFishes().size(),
                player.getOwnedFood()[0].getQuantityFood(), player.getOwnedFood()[1].getQuantityFood(), player.getOwnedFood()[2].getQuantityFood());
        System.out.println(
                "* [1] Buy fish" + "\t".repeat(17) + " *\n" +
                        "* [2] Sell your fish" + "\t".repeat(15) + " *\n" +
                        "* [3] Buy food" + "\t".repeat(17) + " *\n" +
                        "* [4] Feed your fish" + "\t".repeat(15) + " *\n" +
                        "* [5] Try to breed your fish" + "\t".repeat(13) + " *\n" +
                        "* [6] Sit back and go to next round" + "\t".repeat(12) + " *\n" +
                        "* [7] Show owned fish" + "\t".repeat(15) + " *\n" +
                        "* [8] Save game" + "\t".repeat(17) + " *\n" +
                        "* [9] Load game" + "\t".repeat(17) + " *\n"+
                        "* [10] Helpscreen" + "\t".repeat(16) + " *\n" +
                        "* [11] Quit game" + "\t".repeat(16) + " *");

    }

    public void fishMenu(int availableMoney, Player player) {


        System.out.printf("%s%n*\t\t\t\t\t\t\t\t%s \t\t\t\t\t\t\t *%n" +
                        "* \tPlayername: %-14.12s \t\tBank: %6.6s kr \t\t\t\tRound: %s \t *%n" +
                        "* \tOwned fish: %-3.3s\t\t\tOwned food: FLAKES: %-3.3s\tTETRABITS: %-3.3s\tMEAT: %-3.3s\t *%n" +
                        "%1$s%n", starRow, "Starfishy Fish Menu ", player.getName(), player.getMoney(), myGame.getGameRoundsLeft(), player.getOwnedFishes().size(),
                player.getOwnedFood()[0].getQuantityFood(), player.getOwnedFood()[1].getQuantityFood(), player.getOwnedFood()[2].getQuantityFood());
        System.out.printf("*%4.3s %-15.15s" + "\t".repeat(5) + "%-5.5s" + "\t".repeat(4) + "%-10s%n%n","ID","TYPE", "PRICE", "Available in store   *");


        if (availableMoney >= Animal.Fishprice.MINNOW.fishPrice)
            System.out.printf("* [1] %-15.15s" + "\t".repeat(5) + "%-2.3s kr" + "\t".repeat(4) + "%10s st\t\t *%n",Animal.Fishprice.MINNOW, Animal.Fishprice.MINNOW.fishPrice,
                    ((int)player.getMoney() / Animal.Fishprice.MINNOW.fishPrice));
        else
            System.out.println("* [ ] " + Animal.Fishprice.MINNOW + "\t".repeat(7) + "Out of stock" + "\t".repeat(7)+" *");

        if (availableMoney >= Animal.Fishprice.CORYDORAS_STERBAI.fishPrice)
            System.out.printf("* [2] %-20.20s" + "\t".repeat(4) + "%-2.3s kr" + "\t".repeat(4) + "%10s st\t\t *%n",Animal.Fishprice.CORYDORAS_STERBAI, Animal.Fishprice.CORYDORAS_STERBAI.fishPrice,
                    ((int) player.getMoney()/ Animal.Fishprice.CORYDORAS_STERBAI.fishPrice));
        else
            System.out.println("* [ ] " + Animal.Fishprice.CORYDORAS_STERBAI + "\t".repeat(5) + "Out of stock" +"\t".repeat(7)+" *");

        if (availableMoney >= Animal.Fishprice.ANGELFISH.fishPrice)
            System.out.printf("* [3] %-15.15s" + "\t".repeat(5) + "%-2.3s kr" + "\t".repeat(4) + "%10s st\t\t *%n",Animal.Fishprice.ANGELFISH, Animal.Fishprice.ANGELFISH.fishPrice,
                    ((int) player.getMoney()/ Animal.Fishprice.ANGELFISH.fishPrice));
        else
            System.out.println("* [ ] " + Animal.Fishprice.ANGELFISH + "\t".repeat(7) + "Out of stock" +"\t".repeat(7)+" *");
        if (availableMoney >= Animal.Fishprice.PIRANHA.fishPrice)
            System.out.printf("* [4] %-15.15s" + "\t".repeat(5) + "%-2.3s kr" + "\t".repeat(4) + "%10s st\t\t *%n",Animal.Fishprice.PIRANHA, Animal.Fishprice.PIRANHA.fishPrice,
                    ((int) player.getMoney()/ Animal.Fishprice.PIRANHA.fishPrice));
        else
            System.out.println("* [ ] " + Animal.Fishprice.PIRANHA + "\t".repeat(7) + "Out of stock" +"\t".repeat(7)+" *");

        if (availableMoney > Animal.Fishprice.HYPERANCISTRUS_ZEBRA.fishPrice)
            System.out.printf("* [5] %-23.23s" + "\t".repeat(3) + "%-2.4s kr" + "\t".repeat(4) + "%10s st\t\t *%n",Animal.Fishprice.HYPERANCISTRUS_ZEBRA, Animal.Fishprice.HYPERANCISTRUS_ZEBRA.fishPrice,
                    ((int) player.getMoney()/ Animal.Fishprice.HYPERANCISTRUS_ZEBRA.fishPrice));
        else System.out.println("* [ ] " + Animal.Fishprice.HYPERANCISTRUS_ZEBRA + "\t".repeat(4) + "Out of stock" + "\t".repeat(7)+" *");

        if (player.isPlayerRoundChoice())
            System.out.println("* [6] End turn" + "\t".repeat(17) + " *");
        else
            System.out.println("* [6] Go back" + "\t".repeat(17) + " *");


    }


    public void foodMenu(int availableMoney, Player player) {


        System.out.printf("%s%n*\t\t\t\t\t\t\t\t%s \t\t\t\t\t\t\t *%n" +
                        "* \tPlayername: %-14.12s \t\tBank: %6.6s kr \t\t\t\tRound: %s \t *%n" +
                        "* \tOwned fish: %-3.3s\t\t\tOwned food: FLAKES: %-3.3s\tTETRABITS: %-3.3s\tMEAT: %-3.3s\t *%n" +
                        "%1$s%n", starRow, "Starfishy Fish Menu ", player.getName(), player.getMoney(), myGame.getGameRoundsLeft(), player.getOwnedFishes().size(),
                player.getOwnedFood()[0].getQuantityFood(), player.getOwnedFood()[1].getQuantityFood(), player.getOwnedFood()[2].getQuantityFood());
        System.out.printf("*%4.3s %-15.15s" + "\t".repeat(5) + "%-5.5s" + "\t".repeat(4) + "%-10s%n%n","ID","TYPE", "PRICE", "Available in store   *");


        if (availableMoney > Food.FoodPrice.FLAKES.foodPrice)
            System.out.printf("* [1] %-15.15s" + "\t".repeat(5) + "%2.3s kr" + "\t".repeat(4) + "%10s st\t\t *%n",Food.FoodPrice.FLAKES, Food.FoodPrice.FLAKES.foodPrice,
                    ((int) player.getMoney()/ Food.FoodPrice.FLAKES.foodPrice));
        else
            System.out.println("* [ ] " + Food.FoodPrice.FLAKES + GameUtils.errorOutOfStock);

        if (availableMoney > Food.FoodPrice.TETRABITS.foodPrice)
            System.out.printf("* [2] %-15.15s" + "\t".repeat(5) + "%2.3s kr" + "\t".repeat(4) + "%10s st\t\t *%n",Food.FoodPrice.TETRABITS, Food.FoodPrice.TETRABITS.foodPrice,
                    ((int) player.getMoney()/ Food.FoodPrice.TETRABITS.foodPrice));
        else
            System.out.println("* [ ] " + Food.FoodPrice.TETRABITS + GameUtils.errorOutOfStock);

        if (availableMoney > Food.FoodPrice.MEAT.foodPrice)
            System.out.printf("* [3] %-15.15s" + "\t".repeat(5) + "%2.3s kr" + "\t".repeat(4) + "%10s st\t\t *%n",Food.FoodPrice.MEAT, Food.FoodPrice.MEAT.foodPrice,
                    ((int) player.getMoney()/ Food.FoodPrice.MEAT.foodPrice));
        else
            System.out.println("* [ ] " + Food.FoodPrice.MEAT + GameUtils.errorOutOfStock);

        if (player.isPlayerRoundChoice())
            System.out.println("* [4] End turn" + "\t".repeat(17) + "*");
        else System.out.println("* [4] Go back" + "\t".repeat(17) + " *");


    }

    public void sellFishMenu(Player player) {

        System.out.printf("%s%n*\t\t\t\t\t\t\t\t%s \t\t\t\t\t\t\t *%n" +
                        "* \tPlayername: %-14.12s \t\tBank: %6.6s kr \t\t\t\tRound: %s \t *%n" +
                        "* \tOwned fish: %-3.3s\t\t\tOwned food: FLAKES: %-3.3s\tTETRABITS: %-3.3s\tMEAT: %-3.3s\t *%n" +
                        "%1$s%n", starRow, "Starfishy Fish Menu ", player.getName(), player.getMoney(), myGame.getGameRoundsLeft(), player.getOwnedFishes().size(),
                player.getOwnedFood()[0].getQuantityFood(), player.getOwnedFood()[1].getQuantityFood(), player.getOwnedFood()[2].getQuantityFood());

        System.out.println("* [1] Show list of available fish" + "\t".repeat(12) + " *");
        System.out.println("* [2] Choose fish to sell" + "\t".repeat(14) + " *");

        if (player.isPlayerRoundChoice())
            System.out.println("* [3] End turn" + "\t".repeat(17) + " *");

        else System.out.println("* [3] Go back" + "\t".repeat(17) + " *");
    }

    public void feedFishMenu(Player player) {
        int countFishFlakes = 0;
        int countFishTetrabits = 0;
        int countFishMeat = 0;

        System.out.printf("%s%n*\t\t\t\t\t\t\t\t%s \t\t\t\t\t\t\t *%n" +
                        "* \tPlayername: %-14.12s \t\tBank: %6.6s kr \t\t\t\tRound: %s \t *%n" +
                        "* \tOwned fish: %-3.3s\t\t\tOwned food: FLAKES: %-3.3s\tTETRABITS: %-3.3s\tMEAT: %-3.3s\t *%n" +
                        "%1$s%n", starRow, "Starfishy Fish Menu ", player.getName(), player.getMoney(), myGame.getGameRoundsLeft(), player.getOwnedFishes().size(),
                player.getOwnedFood()[0].getQuantityFood(), player.getOwnedFood()[1].getQuantityFood(), player.getOwnedFood()[2].getQuantityFood());

        for (Animal fish: player.getOwnedFishes()){
            if ((fish.isFlakes()) && (fish.getHealth()<100))
                countFishFlakes++;
            if ((fish.isTetrabits())&& (fish.getHealth()<100))
                countFishTetrabits++;
            if ((fish.isMeat())&& (fish.getHealth()<100))
                countFishMeat++;
        }


        System.out.printf("* [1] Feed fish with %-7.6s" + "\t".repeat(6)+ "Available fish to feed: %-4.3s *%n",Food.FoodPrice.FLAKES, countFishFlakes);
        System.out.printf("* [2] Feed fish with %-10.9s" + "\t".repeat(6)+ "Available fish to feed: %-4.3s *%n", Food.FoodPrice.TETRABITS, countFishTetrabits);
        System.out.printf("* [3] Feed fish with %-7.6s" + "\t".repeat(6)+ "Available fish to feed: %-4.3s *%n",Food.FoodPrice.MEAT, countFishMeat);
        if (player.isPlayerRoundChoice())
            System.out.println("* [4] End turn" + "\t".repeat(17) + " *");
        else
            System.out.println("* [4] Go back" + "\t".repeat(17) + " *");

    }
}
