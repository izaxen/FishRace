package Game;

import Animals.*;
import Food.Food;


public class Store {
    int fishToBuy, maxFishTobuy, foodToBuy, maxFoodToBuy;
    ControlMethods controlMethods = new ControlMethods();
    MenuSystem menuSystem = new MenuSystem();

    private int inputChoice;
    private Game mygame;

    public Store(Game mygame) {

        this.mygame = mygame;

    }

    public void buyFish(Player player) {
        menuSystem.fishMenu(player.getMoney(), player);
        do {

            inputChoice = controlMethods.convertInputToInt();

            if ((inputChoice > 0) && (inputChoice < 6)) {
                switch (inputChoice) {
                    case 1: {
                        maxFishTobuy = player.getMoney() / Animal.Fishprice.MINNOW.fishPrice;

                        if (maxFishTobuy > 0) {
                            fishToBuy = maxFishToBuy(maxFishTobuy);
                            for (int i = 0; i < (fishToBuy); i++) {
                                player.setMoney(player.getMoney() - Animal.Fishprice.MINNOW.fishPrice);
                                addNewfishes(player, new Minnow());

                            }
                        } else {
                            System.out.println(ControlMethods.errorOutOfStock);
                        }
                        break;
                    }
                    case 2: {
                        maxFishTobuy = player.getMoney() / Animal.Fishprice.CORYDORAS_STERBAI.fishPrice;
                        if (maxFishTobuy > 0) {
                            fishToBuy = maxFishToBuy(maxFishTobuy);
                            for (int i = 0; i < fishToBuy; i++) {
                                player.setMoney(player.getMoney() - Animal.Fishprice.CORYDORAS_STERBAI.fishPrice);
                                addNewfishes(player, new Corydoras_Sterbai());
                            }

                        } else {
                            System.out.println(ControlMethods.errorOutOfStock);
                        }
                        break;
                    }
                    case 3: {
                        maxFishTobuy = player.getMoney() / Animal.Fishprice.ANGELFISH.fishPrice;

                        if (maxFishTobuy > 0) {
                            fishToBuy = maxFishToBuy(maxFishTobuy);
                            for (int i = 0; i < (fishToBuy); i++) {
                                player.setMoney(player.getMoney() - Animal.Fishprice.ANGELFISH.fishPrice);
                                addNewfishes(player, new Angelfish());
                            }
                        } else {
                            System.out.println(ControlMethods.errorOutOfStock);
                        }
                        break;
                    }
                    case 4: {
                        maxFishTobuy = player.getMoney() / Animal.Fishprice.PIRANHA.fishPrice;
                        if (maxFishTobuy > 0) {
                            fishToBuy = maxFishToBuy(maxFishTobuy);
                            for (int i = 0; i < (fishToBuy); i++) {
                                player.setMoney(player.getMoney() - Animal.Fishprice.PIRANHA.fishPrice);
                                addNewfishes(player, new Piranha());
                            }
                        } else {
                            System.out.println(ControlMethods.errorOutOfStock);
                        }
                        break;
                    }
                    case 5: {
                        maxFishTobuy = player.getMoney() / Animal.Fishprice.HYPERANCISTRUS_ZEBRA.fishPrice;
                        if (maxFishTobuy > 0) {
                            fishToBuy = maxFishToBuy(maxFishTobuy);
                            for (int i = 0; i < (fishToBuy); i++) {
                                player.setMoney(player.getMoney() - Animal.Fishprice.HYPERANCISTRUS_ZEBRA.fishPrice);
                                addNewfishes(player, new Hyperancistrus_Zebra());
                            }
                        } else {
                            System.out.println(ControlMethods.errorOutOfStock);
                            break;
                        }
                        break;
                    }
                    case 6: {
                        mygame.chooseActionMainMenu(player);
                        break;
                    }
                    case 7: {
                        return;
                    }
                }
            }
        } while (inputChoice ==7);
    }


    public void addNewfishes(Player player, Animal toAdd) {
        System.out.println(ControlMethods.enterName);
        toAdd.setName(controlMethods.inputString());
        System.out.println("Choose [1] for female and [2] for male if you want to specify gender else the shop will just pick a random");
        toAdd.setGender(controlMethods.inputString()); //TODO lägg in ev en If sats med breed som inkommande
        player.getOwnedFishes().add(toAdd);
        System.out.println(toAdd.getName() + " of the type "+ toAdd.getClass().getSimpleName() +" has been added to your owned fish.\n");


    }

    public void sellFishChoice(Player player) {


        do {
            int index = 0;
            menuSystem.sellFishMenu(player);
            inputChoice = controlMethods.convertInputToInt();

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
                    String[] numberAsString = controlMethods.inputString().split(" ");
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
                default:
                    System.out.println(ControlMethods.errorNumber);
            }
        } while (!(inputChoice == 3));

    }

    public void buyFood(Player player) {

        do {
            menuSystem.foodMenu(player.getMoney(), player);
            inputChoice = controlMethods.convertInputToInt();
            switch (inputChoice) {
                case 1: {
                    maxFoodToBuy = player.getMoney() / Food.FoodPrice.FLAKES.foodPrice;
                    if (maxFoodToBuy > 0) {
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
                        foodToBuy = maxFoodToBuy(maxFoodToBuy);
                        player.setMoney(player.getMoney() - (Food.FoodPrice.MEAT.foodPrice * foodToBuy));
                        player.getOwnedFood()[2].setQuantityFood(player.getOwnedFood()[2].getQuantityFood() + foodToBuy);
                        System.out.println("You have bought "+foodToBuy+" new "+ Food.FoodPrice.MEAT);
                    }
                    break;
                }
            }
        } while (!(inputChoice == 4));    //TODO Fix the loop
    }

    private int maxFishToBuy(int maxFishToBuy) {
        do {
            System.out.println(ControlMethods.maxFishToBuy + maxFishToBuy);
            System.out.println(ControlMethods.enterQuantity);
            fishToBuy = controlMethods.convertInputToInt();
        } while ((fishToBuy > maxFishToBuy) || (fishToBuy < 1));
        return fishToBuy;
    }

    private int maxFoodToBuy(int maxFoodToBuy) {
        do {
            System.out.println(ControlMethods.maxFoodToBuy + maxFoodToBuy);
            System.out.println(ControlMethods.enterQuantity);
            foodToBuy = controlMethods.convertInputToInt();

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






