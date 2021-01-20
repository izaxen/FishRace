package Game;

import Animals.*;
import Food.Food;


public class Store {
    int fishToBuy, maxFishTobuy, foodToBuy, maxFoodToBuy;


    private int inputChoice;

    private Game mygame;

    public Store(Game mygame) {
        this.mygame = mygame;

    }

    public void buyFish(Player player) {

        do {
            mygame.menuSystem.fishMenu(player.getMoney(), player);
            inputChoice = ControlMethods.convertInputToInt();

            if ((inputChoice > 0) && (inputChoice < 7)) {
                switch (inputChoice) {
                    case 1: {
                                     maxFishTobuy = player.getMoney() / Animal.Fishprice.MINNOW.fishPrice;
                        if (maxFishTobuy > 0) {
                            player.setPlayerRoundChoice(true);
                            fishToBuy = maxFishToBuy(maxFishTobuy);
                            for (int i = 0; i < (fishToBuy); i++) {
                                player.setMoney(player.getMoney() - Animal.Fishprice.MINNOW.fishPrice);
                                addNewFishBought(player, new Minnow());

                            }
                        } else {
                            System.out.println(ControlMethods.errorOutOfStock);
                        }
                        break;
                    }
                    case 2: {

                        maxFishTobuy = player.getMoney() / Animal.Fishprice.CORYDORAS_STERBAI.fishPrice;
                        if (maxFishTobuy > 0) {
                            player.setPlayerRoundChoice(true);
                            fishToBuy = maxFishToBuy(maxFishTobuy);
                            for (int i = 0; i < fishToBuy; i++) {
                                player.setMoney(player.getMoney() - Animal.Fishprice.CORYDORAS_STERBAI.fishPrice);
                                addNewFishBought(player, new Corydoras_Sterbai());
                            }

                        } else {
                            System.out.println(ControlMethods.errorOutOfStock);
                        }
                        break;
                    }
                    case 3: {
                        maxFishTobuy = player.getMoney() / Animal.Fishprice.ANGELFISH.fishPrice;

                        if (maxFishTobuy > 0) {
                            player.setPlayerRoundChoice(true);
                            fishToBuy = maxFishToBuy(maxFishTobuy);
                            for (int i = 0; i < (fishToBuy); i++) {
                                player.setMoney(player.getMoney() - Animal.Fishprice.ANGELFISH.fishPrice);
                                addNewFishBought(player, new Angelfish());
                            }
                        } else {
                            System.out.println(ControlMethods.errorOutOfStock);
                        }
                        break;
                    }
                    case 4: {
                        maxFishTobuy = player.getMoney() / Animal.Fishprice.PIRANHA.fishPrice;
                        if (maxFishTobuy > 0) {
                            player.setPlayerRoundChoice(true);
                            fishToBuy = maxFishToBuy(maxFishTobuy);
                            for (int i = 0; i < (fishToBuy); i++) {
                                player.setMoney(player.getMoney() - Animal.Fishprice.PIRANHA.fishPrice);
                                addNewFishBought(player, new Piranha());
                            }
                        } else {
                            System.out.println(ControlMethods.errorOutOfStock);
                        }
                        break;
                    }
                    case 5: {
                        maxFishTobuy = player.getMoney() / Animal.Fishprice.HYPERANCISTRUS_ZEBRA.fishPrice;
                        if (maxFishTobuy > 0) {
                            player.setPlayerRoundChoice(true);
                            fishToBuy = maxFishToBuy(maxFishTobuy);
                            for (int i = 0; i < (fishToBuy); i++) {
                                player.setMoney(player.getMoney() - Animal.Fishprice.HYPERANCISTRUS_ZEBRA.fishPrice);
                                addNewFishBought(player, new Hyperancistrus_Zebra());
                            }
                        } else {
                            System.out.println(ControlMethods.errorOutOfStock);
                            break;
                        }
                        break;
                    }
                    case 6: {
                        if (player.isPlayerRoundChoice())
                        break;
                        else
                            mygame.chooseActionMainMenu(player);
                    }
                    default:
                        System.out.println(ControlMethods.errorNumber);

                }
            }
        } while (inputChoice != 6);
    }


    public void addNewFishBought(Player player, Animal toAdd) {
        System.out.println(ControlMethods.enterName);
        toAdd.setName(ControlMethods.inputString());
        System.out.println("Choose [1] for female and [2] for male if you want to specify gender else the shop will just pick a random");
        toAdd.setGender(ControlMethods.inputString());
        player.getOwnedFishes().add(toAdd);
        System.out.println(toAdd.getName() + " of the type "+ toAdd.getClass().getSimpleName() +" has been added to your owned fish.\n");


    }
    public void addNewFishBreeded(Player player, Animal toAdd) {
        System.out.println(ControlMethods.enterName);//TODO Add random name
        toAdd.setName(ControlMethods.inputString());

        toAdd.setGender("breed");
        player.getOwnedFishes().add(toAdd);
        System.out.println(toAdd.getName() + " of the type "+ toAdd.getClass().getSimpleName() +" has been added to your owned fish.\n");


    }

    public void sellFishChoice(Player player) {


        do {
            int index = 0;
            mygame.menuSystem.sellFishMenu(player);
            inputChoice = ControlMethods.convertInputToInt();

            switch (inputChoice) {

                case 1: {
                    System.out.println("\n\nIndex\tType:\tName:\t\t\tGender:\tHealth:\tValue:\t");
                    System.out.println(MenuSystem.starRow + "\n");
                    for (Animal fish : player.getOwnedFishes()) {
                        System.out.printf("%1$d\t\t%2$s\t\t%3$s\t\t%4$s\t\t%5$d\t\t%6$d%n", index, fish.getClass().getSimpleName(), fish.getName(), fish.getGender()
                                , fish.getHealth(), fish.calculateValue());
                        index++;

                    }
                    break;
                }
                case 2: {
                    int convert;
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
                                break;
                            }
                        }
                    }
                    System.out.println("Player money after sell " + player.getMoney());
                    break;
                }
                case 3:
                    if(player.isPlayerRoundChoice())
                        break;
                    else
                        mygame.chooseActionMainMenu(player);

                default:
                    System.out.println(ControlMethods.errorNumber);
            }
        } while (!(inputChoice == 3));

    }

    public void buyFood(Player player) {

        do {
           mygame.menuSystem.foodMenu(player.getMoney(), player);
            inputChoice = ControlMethods.convertInputToInt();
            switch (inputChoice) {
                case 1: {
                    maxFoodToBuy = player.getMoney() / Food.FoodPrice.FLAKES.foodPrice;
                    if (maxFoodToBuy > 0) {
                        player.setPlayerRoundChoice(true);
                        foodToBuy = maxFoodToBuy(maxFoodToBuy);
                        player.setMoney(player.getMoney() - (Food.FoodPrice.FLAKES.foodPrice * foodToBuy));
                        player.getOwnedFood()[0].setQuantityFood(player.getOwnedFood()[0].getQuantityFood() + foodToBuy);
                        System.out.println("You have bought "+foodToBuy+" new "+ Food.FoodPrice.FLAKES);
                    }
                    break;
                }
                case 2: {
                    maxFoodToBuy = player.getMoney() / Food.FoodPrice.TETRABITS.foodPrice;
                    if (maxFoodToBuy > 0) {
                        player.setPlayerRoundChoice(true);
                        foodToBuy = maxFoodToBuy(maxFoodToBuy);
                        player.setMoney(player.getMoney() - (Food.FoodPrice.TETRABITS.foodPrice * foodToBuy));
                        player.getOwnedFood()[1].setQuantityFood(player.getOwnedFood()[1].getQuantityFood() + foodToBuy);
                        System.out.println("You have bought "+foodToBuy+" new "+ Food.FoodPrice.TETRABITS);

                    }
                    break;

                }
                case 3: {
                    maxFoodToBuy = player.getMoney() / Food.FoodPrice.MEAT.foodPrice;
                    if (maxFoodToBuy > 0) {
                        player.setPlayerRoundChoice(true);
                        foodToBuy = maxFoodToBuy(maxFoodToBuy);
                        player.setMoney(player.getMoney() - (Food.FoodPrice.MEAT.foodPrice * foodToBuy));
                        player.getOwnedFood()[2].setQuantityFood(player.getOwnedFood()[2].getQuantityFood() + foodToBuy);
                        System.out.println("You have bought "+foodToBuy+" new "+ Food.FoodPrice.MEAT);
                    }
                    break;
                } case 4:
                    if(player.isPlayerRoundChoice())
                        break;
                    else
                        mygame.chooseActionMainMenu(player);
            }
        } while (!(inputChoice == 4));    //TODO Fix the loop
    }

    private int maxFishToBuy(int maxFishToBuy) {
        do {
            System.out.println(ControlMethods.maxFishToBuy + maxFishToBuy);
            System.out.println(ControlMethods.enterQuantity);
            fishToBuy = ControlMethods.convertInputToInt();
        } while ((fishToBuy > maxFishToBuy) || (fishToBuy < 1));
        return fishToBuy;
    }

    private int maxFoodToBuy(int maxFoodToBuy) {
        do {
            System.out.println(ControlMethods.maxFoodToBuy + maxFoodToBuy);
            System.out.println(ControlMethods.enterQuantity);
            foodToBuy = ControlMethods.convertInputToInt();

        } while ((foodToBuy > maxFoodToBuy) || foodToBuy < 1);
        return foodToBuy;
    }

    public void sellAllFishEndGame() {
        for (Player player : mygame.getContestants()) {
            for (int i = player.getOwnedFishes().size(); i >= 0; i--) {
                player.setMoney(player.getMoney() + player.getOwnedFishes().get(i).calculateValue());
                player.getOwnedFishes().remove(i);

            }
        }

    }
}






