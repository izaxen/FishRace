package Stayfishy;

public class Store {
    int i = 0, fishToBuy, maxFishTobuy;
    ControlMethods controlMethods = new ControlMethods();

    public void buyFish(int inputChoice, Player player) {


        if ((inputChoice > 0) && (inputChoice < 6)) {
            switch (inputChoice) {
                case 1: {
                    maxFishTobuy = player.getMoney()/ Animal.Fishprice.MINOW.price;

                    if (maxFishTobuy > 0) { //TODO minizie IF to method
                        System.out.println(ControlMethods.maxFishToBuy+maxFishTobuy);
                        System.out.println(ControlMethods.enterQuantity);
                        fishToBuy = controlMethods.convertInputToInt();
                        for(int i = 0; i < (fishToBuy);i++)
                        addNewfishes(player, new Minow());
                    } else {
                        System.out.println(ControlMethods.errorEnoghMoney);
                    }
                    break;
                }
                case 2: {
                    maxFishTobuy = player.getMoney()/ Animal.Fishprice.CORYDORAS.price;
                    if (maxFishTobuy > 0) {
                        System.out.println(ControlMethods.maxFishToBuy+maxFishTobuy);
                        System.out.println(ControlMethods.enterQuantity);
                        fishToBuy = controlMethods.convertInputToInt();
                        for(int i = 0; i < (fishToBuy);i++)
                            addNewfishes(player, new Corydoras_Sterbai());

                    } else {
                        System.out.println(ControlMethods.errorEnoghMoney);
                    }
                    break;
                }
                case 3: {
                    maxFishTobuy = player.getMoney() / Animal.Fishprice.ANGELFISH.price;

                    if (maxFishTobuy > 0) {
                        System.out.println(ControlMethods.maxFishToBuy+maxFishTobuy);
                        System.out.println(ControlMethods.enterQuantity);
                        fishToBuy = controlMethods.convertInputToInt();
                        for(int i = 0; i < (fishToBuy);i++)
                            addNewfishes(player, new Angelfish());
                    } else {
                        System.out.println(ControlMethods.errorEnoghMoney);
                    }
                    break;
                }
                case 4: {
                    maxFishTobuy =  player.getMoney() / Animal.Fishprice.PIRANHA.price;
                    if (Animal.Fishprice.PIRANHA.price < player.getMoney()) {
                        System.out.println(ControlMethods.maxFishToBuy+maxFishTobuy);
                        System.out.println(ControlMethods.enterQuantity);
                        fishToBuy = controlMethods.convertInputToInt();
                        for(int i = 0; i < (fishToBuy);i++)
                            addNewfishes(player, new Piranha());
                    } else {
                        System.out.println(ControlMethods.errorEnoghMoney);
                    }
                    break;
                }
                case 5: {
                    if (Animal.Fishprice.HYPERANCISTRUS.price < player.getMoney()) {
                        System.out.println(ControlMethods.maxFishToBuy+maxFishTobuy);
                        System.out.println(ControlMethods.enterQuantity);
                        fishToBuy = controlMethods.convertInputToInt();
                        for(int i = 0; i < (fishToBuy);i++)
                            addNewfishes(player, new Hyperancistrus_Zebra());
                    } else {
                        System.out.println(ControlMethods.errorEnoghMoney);
                    }
                    break;
                }
                case 6: {
                    break;

                }

            }
        }
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


}
