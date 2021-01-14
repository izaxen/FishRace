package Game;

import Animals.*;



public class Store {
    int i = 0, fishToBuy, maxFishTobuy;
    ControlMethods controlMethods = new ControlMethods();
    MenuSystem menuSystem = new MenuSystem();
    // Animal animal= new Animal();

    private int inputChoice;
    private Game mygame;
    public Store(Game mygame){

        this.mygame = mygame;

    }

    public void buyFish(Player player) {
        menuSystem.fishMenu();
        do {


            inputChoice = controlMethods.convertInputToInt();

            if ((inputChoice > 0) && (inputChoice < 6)) {
                switch (inputChoice) {
                    case 1: {
                        maxFishTobuy = player.getMoney() / 30;//TODO minizie IF to method and fix HARD Code for prize for all if

                        if (maxFishTobuy > 0) {
                            System.out.println(ControlMethods.maxFishToBuy + maxFishTobuy);
                            System.out.println(ControlMethods.enterQuantity);
                            fishToBuy = controlMethods.convertInputToInt();
                            for (int i = 0; i < (fishToBuy); i++)
                                addNewfishes(player, new Minow());
                        } else {
                            System.out.println(ControlMethods.errorEnoghMoney);
                        }
                        break;
                    }
                    case 2: {
                        maxFishTobuy = player.getMoney() / 80;
                        if (maxFishTobuy > 0) {
                            System.out.println(ControlMethods.maxFishToBuy + maxFishTobuy);
                            System.out.println(ControlMethods.enterQuantity);
                            fishToBuy = controlMethods.convertInputToInt();
                            for (int i = 0; i < (fishToBuy); i++)
                                addNewfishes(player, new Corydoras_Sterbai());

                        } else {
                            System.out.println(ControlMethods.errorEnoghMoney);
                        }
                        break;
                    }
                    case 3: {
                        maxFishTobuy = player.getMoney()/150;

                        if (maxFishTobuy > 0) {
                            System.out.println(ControlMethods.maxFishToBuy + maxFishTobuy);
                            System.out.println(ControlMethods.enterQuantity);
                            fishToBuy = controlMethods.convertInputToInt();
                            for (int i = 0; i < (fishToBuy); i++)
                                addNewfishes(player, new Angelfish());
                        } else {
                            System.out.println(ControlMethods.errorEnoghMoney);
                        }
                        break;
                    }
                    case 4: {
                        maxFishTobuy = player.getMoney() / 300;
                        if (maxFishTobuy > 0) {
                            System.out.println(ControlMethods.maxFishToBuy + maxFishTobuy);
                            System.out.println(ControlMethods.enterQuantity);
                            fishToBuy = controlMethods.convertInputToInt();
                            for (int i = 0; i < (fishToBuy); i++)
                                addNewfishes(player, new Piranha());
                        } else {
                            System.out.println(ControlMethods.errorEnoghMoney);
                        }
                        break;
                    }
                    case 5: {
                        maxFishTobuy = player.getMoney()/1050;
                        if (maxFishTobuy > 0) {
                            System.out.println(ControlMethods.maxFishToBuy + maxFishTobuy);
                            System.out.println(ControlMethods.enterQuantity);
                            fishToBuy = controlMethods.convertInputToInt();
                            for (int i = 0; i < (fishToBuy); i++)
                                addNewfishes(player, new Hyperancistrus_Zebra());
                        } else {
                            System.out.println(ControlMethods.errorEnoghMoney);
                        }
                        break;
                    }
                    case 6: {
                        mygame.chooseAction(player);
                        break;
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
        System.out.println("Insert male or female if you want to choose or the shop will just pick a random");
        toAdd.setGender(controlMethods.inputString()); //TODO lägg in ev en If sats med breed som inkommande
        player.ownedFishes.add(toAdd);
    }

    public void sellFishChoice(Player player) {
        int index = 0;

        do {
            menuSystem.sellFishMenu(player);
            inputChoice = controlMethods.convertInputToInt();

            switch (inputChoice) {

                case 1: {
                    System.out.println("\n\nIndex\tType:\tName:\t\t\tGender:\tHealth:\tValue:\t");
                    System.out.println(MenuSystem.starRow + "\n");
                    for (Animal fish : player.ownedFishes) {
                        //System.out.printf("%1$d\t\t%2$s\t\t\t%3$s\t\t\t%3$s\t%4$s%\t%5$d%%n",index,fish.getClass(), fish.getName(),
                                //fish.getGender(), fish.getHealth());
                        System.out.printf("%1$d\t\t%2$s\t\t%3$s\t\t%4$s\t\t%5$d\t\t%6$d%n",index,fish.getClass().getSimpleName(), fish.getName(), fish.getGender()
                        , fish.getHealth(), fish.calculateValue());
                        index++;
                                //,fish.calculateValue()
                    }
                    break;
                }
                case 2: {
                    //Sell fish
                }
                default:
                    System.out.println(ControlMethods.errorNumber);
            }
        } while (!(inputChoice == 3));
    }
}



