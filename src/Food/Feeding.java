package Food;

import Animals.*;
import Game.*;

public class Feeding {

    private Game myGame;

    public Feeding(Game myGame) {
        this.myGame = myGame;
    }

    public void chooseFoodToFeedWith(Player player) {
        int inputChoice;
        do {
            myGame.menuSystem.feedFishMenu(player);
            inputChoice = ControlMethods.convertInputToInt() - 1;
            switch (inputChoice) {
                case 0, 1, 2 -> feedYourFish(player, inputChoice);

                case 3 -> {
                    if (!player.isPlayerRoundChoice()) myGame.chooseActionMainMenu(player);
                }
            }
        } while (inputChoice != 3);
    }

    private void feedYourFish(Player player, int inputChoice) {
        Food food = player.getOwnedFood()[inputChoice];

        if (food.getQuantityFood() > 0) {
            for (Animal feedFish : player.getOwnedFishes()) {
                String fClass = feedFish.getClass().getSimpleName();
                String fName = feedFish.getName();

                if (feedFish.isFlakes() || feedFish.isTetrabits() || feedFish.isMeat()) {
                    if (feedFish.health() > 99) {
                        System.out.println(fName + " of the type " + fClass + " already has full health no need for more food");
                    } else if (food.getQuantityFood() > 0) {
                        System.out.println("Do you want to feed " + fName + " of the type " + fClass);
                        System.out.println("If you don´t want to feed the fish type NO else just press enter");
                        if (!ControlMethods.inputString().equalsIgnoreCase("no")) {
                            food.setQuantityFood(food.getQuantityFood() - 1);

                            if (food.toString().equalsIgnoreCase("0"))
                                feedFish.setHealth(feedFish.getHealthBoostFlakes() + feedFish.health());
                            else if (food.toString().equalsIgnoreCase("1"))
                                feedFish.setHealth(feedFish.getHealthBoostTetrabits() + feedFish.health());
                            else if (food.toString().equalsIgnoreCase("2"))
                                feedFish.setHealth(feedFish.getHealthBoostMeat() + feedFish.health());

                            player.setPlayerRoundChoice(true);
                            if (feedFish.health() > 100) {
                                feedFish.setHealth(100);
                            }
                        }
                    } else {
                        System.out.println(food.getPrice() + " is" + ControlMethods.errorOutOfStock + ". And " + feedFish.getName() + " starved");
                    }
                }
            }
        } else System.out.println(ControlMethods.errorOutOfStock);

    }
}
