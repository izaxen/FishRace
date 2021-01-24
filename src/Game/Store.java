package Game; //TODO Lista when selling

import Animals.*;
import Food.Food;

import java.io.Serializable;


public class Store implements Serializable {
    int fishToBuy, maxFishTobuy, foodToBuy, maxFoodToBuy;


    private final Game myGame;

    public Store(Game myGame) {
        this.myGame = myGame;

    }

    public void buyFishChoice(Player player) {
        int inputChoiceBFC;
        do {
            myGame.menuSystem.fishMenu(player.getMoney(), player);
            inputChoiceBFC = ControlMethods.convertInputToInt(1, 6);

            switch (inputChoiceBFC) {
                case 1 -> buyFish(player, Animal.Fishprice.MINNOW.fishPrice, inputChoiceBFC);
                case 2 -> buyFish(player, Animal.Fishprice.CORYDORAS_STERBAI.fishPrice, inputChoiceBFC);
                case 3 -> buyFish(player, Animal.Fishprice.ANGELFISH.fishPrice, inputChoiceBFC);
                case 4 -> buyFish(player, Animal.Fishprice.PIRANHA.fishPrice, inputChoiceBFC);
                case 5 -> buyFish(player, Animal.Fishprice.HYPERANCISTRUS_ZEBRA.fishPrice, inputChoiceBFC);
                case 6 -> {
                    if (!player.isPlayerRoundChoice())
                        myGame.chooseActionMainMenu(player);
                }
            }
        } while (inputChoiceBFC != 6);
    }

    public void buyFish(Player player, int price, int inputChoice) {

        maxFishTobuy = player.getMoney() / price;
        if (maxFishTobuy > 0) {
            player.setPlayerRoundChoice(true);
            fishToBuy = maxFishToBuy(maxFishTobuy);
            for (int i = 0; i < (fishToBuy); i++) {
                player.setMoney(player.getMoney() - price);
                switch (inputChoice) {
                    case 1 -> addNewFishBought(player, new Minnow());
                    case 2 -> addNewFishBought(player, new Corydoras_Sterbai());
                    case 3 -> addNewFishBought(player, new Angelfish());
                    case 4 -> addNewFishBought(player, new Piranha());
                    case 5 -> addNewFishBought(player, new Hyperancistrus_Zebra());
                }
            }
        } else
            System.out.println(ControlMethods.errorOutOfStock);
    }

    public void addNewFishBought(Player player, Animal toAdd) {
        System.out.println(ControlMethods.enterName);
        toAdd.setName(ControlMethods.inputString());
        System.out.println("Choose [1] for female and [2] for male if you want to specify gender else the shop will just pick a random");
        toAdd.setGender(ControlMethods.inputString());
        player.getOwnedFishes().add(toAdd);
        System.out.println(toAdd.getName() + " of the type " + toAdd.getClass().getSimpleName() + " has been added to your owned fish.\n");
    }

    public void sellFishChoice(Player player) {

        int inputChoiceSFC;
        do {
            myGame.menuSystem.sellFishMenu(player);
            inputChoiceSFC = ControlMethods.convertInputToInt(1, 3);

            switch (inputChoiceSFC) {

                case 1 -> {
                    int index = 0;
                    System.out.printf("* %-6.3s%-22.20s%-12.10s%-9.7s%9.6s%8.5s%12.9s *%n", "ID", "TYPE", "NAME", "GENDER", "HEALTH", "VALUE", "BREEDABLE");
                    System.out.println(MenuSystem.starRow + "\n");
                    for (Animal fish : player.getOwnedFishes()) {
                        System.out.printf("* %-6.3s%-22.20s%-12.10s%-9.7s%9.6s%8.5s%12.9s *%n", index, fish.getClass().getSimpleName(), fish.getName(), fish.getGender(), fish.health(), fish.calculateValue(), fish.isDoneBreeding());
                        index++;

                    }

                }
                case 2 -> {
                    int convert;
                    listOwnedFish(player);
                    System.out.println("Choose which fish you want to sell by their ID number\n" +
                            "If you want to sell more then one fish just enter their ID after a blankspace");
                    String[] numberAsString = ControlMethods.inputString().split(" ");
                    player.setPlayerRoundChoice(true);
                    for (int i = player.getOwnedFishes().size() - 1; i >= 0; i--) {

                        for (String testPrint : numberAsString) {
                            try {
                                convert = Integer.parseInt(testPrint);
                            } catch (Exception e) {
                                continue;
                            }
                            if (i == convert) {
                                player.setMoney((player.getMoney()) + player.getOwnedFishes().get(i).calculateValue());
                                player.getOwnedFishes().remove(i);
                            }
                        }
                    }
                    System.out.println("Player money after sell " + player.getMoney());

                }
                case 3 -> {
                    if (!player.isPlayerRoundChoice())
                        myGame.chooseActionMainMenu(player);
                }
            }
        } while (inputChoiceSFC != 3);
    }

    private int maxFishToBuy(int maxFishToBuy) {
        do {
            System.out.println(ControlMethods.maxFishToBuy + maxFishToBuy);
            System.out.println(ControlMethods.enterQuantity);
            fishToBuy = ControlMethods.convertInputToInt();
        } while ((fishToBuy > maxFishToBuy) || (fishToBuy < 1));
        return fishToBuy;
    }

    public void buyFoodChoice(Player player) {

        int inputChoiceBF;
        do {
            myGame.menuSystem.foodMenu(player.getMoney(), player);
            inputChoiceBF = ControlMethods.convertInputToInt(1, 4);

            switch (inputChoiceBF) {
                case 1 -> buyFood(player, inputChoiceBF - 1, Food.FoodPrice.FLAKES);
                case 2 -> buyFood(player, inputChoiceBF - 1, Food.FoodPrice.TETRABITS);
                case 3 -> buyFood(player, inputChoiceBF - 1, Food.FoodPrice.MEAT);
                case 4 -> {
                    if (!player.isPlayerRoundChoice())
                        myGame.chooseActionMainMenu(player);
                }
            }
        } while (inputChoiceBF != 4);
    }

    private void buyFood(Player player, int inputChoice, Food.FoodPrice type) {
        maxFoodToBuy = player.getMoney() / type.foodPrice;

        if (maxFoodToBuy > 0) {
            player.setPlayerRoundChoice(true);

            System.out.println(ControlMethods.maxFoodToBuy + maxFoodToBuy);
            System.out.println(ControlMethods.enterQuantity);

            foodToBuy = ControlMethods.convertInputToInt(1, maxFoodToBuy);
            player.setMoney(player.getMoney() - (type.foodPrice * foodToBuy));
            player.getOwnedFood()[inputChoice].setQuantityFood(player.getOwnedFood()[inputChoice].getQuantityFood() + foodToBuy);

            System.out.println("You have bought " + foodToBuy + " new " + type);
        } else
            System.out.println(ControlMethods.errorOutOfStock);

    }


    public void sellAllFishEndGame() {
        for (Player player : myGame.getContestants()) {
            if (player.getOwnedFishes().size() != 0)
                for (int i = player.getOwnedFishes().size() - 1; i >= 0; i--) {
                    player.setMoney(player.getMoney() + player.getOwnedFishes().get(i).calculateValue());
                    player.getOwnedFishes().remove(i);

                }
        }

    }

    public void listOwnedFish(Player player) {
        int index = 0;
        System.out.printf("* %-6.3s%-22.20s%-12.10s%-7.7s%7.6s%6.5s%8.5s%12.9s%n", "ID", "TYPE", "NAME", "GENDER", "HEALTH", "AGE", "VALUE", "BREEDABLE");
        System.out.println(MenuSystem.starRow + "\n");
        for (Animal fish : player.getOwnedFishes()) {
            System.out.printf("* %-6.3s%-22.20s%-12.10s%-9.7s%5.5s%6.5s%8.5s%10.7s *%n", index, fish.getClass().getSimpleName(), fish.getName(), fish.getGender(), fish.health(), fish.getAgeFish(), fish.calculateValue(), fish.isDoneBreeding());
            index++;
        }
        System.out.println("\n");
    }
}







