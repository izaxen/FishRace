package Game;

import Animals.*;

import java.util.Collections;


public class Store {
    int fishToBuy, maxFishTobuy;
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
                        maxFishTobuy = player.getMoney() / Animal.Fishprice.MINOW.price;

                        if (maxFishTobuy > 0) {
                            fishToBuy = mmaxFishToBuy(maxFishTobuy);
                            for (int i = 0; i < (fishToBuy); i++) {
                                player.setMoney(player.getMoney() - Animal.Fishprice.MINOW.price);
                                addNewfishes(player, new Minow());

                            }
                        } else {
                            System.out.println(ControlMethods.errorOutOfStock);
                        }
                        break;
                    }
                    case 2: {
                        maxFishTobuy = player.getMoney() / Animal.Fishprice.CORYDORAS_STERBAI.price;
                        if (maxFishTobuy > 0) {
                            fishToBuy = mmaxFishToBuy(maxFishTobuy);
                            for (int i = 0; i < fishToBuy; i++) {
                                player.setMoney(player.getMoney() - Animal.Fishprice.CORYDORAS_STERBAI.price);
                                addNewfishes(player, new Corydoras_Sterbai());
                            }

                        } else {
                            System.out.println(ControlMethods.errorOutOfStock);
                        }
                        break;
                    }
                    case 3: {
                        maxFishTobuy = player.getMoney() / Animal.Fishprice.ANGELFISH.price;

                        if (maxFishTobuy > 0) {
                            fishToBuy = mmaxFishToBuy(maxFishTobuy);
                            for (int i = 0; i < (fishToBuy); i++) {
                                player.setMoney(player.getMoney() - Animal.Fishprice.ANGELFISH.price);
                                addNewfishes(player, new Angelfish());
                            }
                        } else {
                            System.out.println(ControlMethods.errorOutOfStock);
                        }
                        break;
                    }
                    case 4: {
                        maxFishTobuy = player.getMoney() / Animal.Fishprice.PIRANHA.price;
                        if (maxFishTobuy > 0) {
                            fishToBuy = mmaxFishToBuy(maxFishTobuy);
                            for (int i = 0; i < (fishToBuy); i++) {
                                player.setMoney(player.getMoney() - Animal.Fishprice.PIRANHA.price);
                                addNewfishes(player, new Piranha());
                            }
                        } else {
                            System.out.println(ControlMethods.errorOutOfStock);
                        }
                        break;
                    }
                    case 5: {
                        maxFishTobuy = player.getMoney() / Animal.Fishprice.HYPERANCISTRUS_ZEBRA.price;
                        if (maxFishTobuy > 0) {
                            fishToBuy = mmaxFishToBuy(maxFishTobuy);
                            for (int i = 0; i < (fishToBuy); i++) {
                                player.setMoney(player.getMoney() - Animal.Fishprice.HYPERANCISTRUS_ZEBRA.price);
                                addNewfishes(player, new Hyperancistrus_Zebra());
                            }
                        } else {
                            System.out.println(ControlMethods.errorOutOfStock);
                            break;
                        }
                        break;
                    }
                    case 6: {
                        mygame.chooseAction(player);
                        break;
                    }
                    case 7: {
                    }
                }
            }
        } while (inputChoice < 1);
    }

    public void buyFood(int inputChoice) {

    }

    public void addNewfishes(Player player, Animal toAdd) {
        System.out.println(ControlMethods.enterName);
        toAdd.setName(controlMethods.inputString());
        System.out.println("Choose [1] for female and [2] for male if you want to specify gender else the shop will just pick a random");
        toAdd.setGender(controlMethods.inputString()); //TODO lägg in ev en If sats med breed som inkommande
        player.getOwnedFishes().add(toAdd);

        System.out.println(toAdd.isFlakes());
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

    private int mmaxFishToBuy(int maxFishTobuy) {
        do {
            System.out.println(ControlMethods.maxFishToBuy + maxFishTobuy);
            System.out.println(ControlMethods.enterQuantity);
            fishToBuy = controlMethods.convertInputToInt();
        } while ((fishToBuy > maxFishTobuy) || (fishToBuy < 1));
        return fishToBuy;
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






