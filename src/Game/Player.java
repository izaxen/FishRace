package Game;

import Animals.Animal;
import Animals.Minnow;
import Food.*;
import java.util.ArrayList;

public class Player {


    private String name;
    private int money = 600;
    private boolean playerActive = true;
    private boolean playerRoundChoice = false;



    private Game myGame;


    private ArrayList<Animal> ownedFishes = new ArrayList();


    private Food[] ownedFood = {
            new Flakes(),
            new Tetrabits(),
            new Meat()};


    public Player(String name) {
        this.name = name;

    }

    public void setMyGame(Game myGame) {
        this.myGame = myGame ;
    }

    public Food[] getOwnedFood() {
        return ownedFood;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void addNewFish(Animal toAdd) {//TODO SKALL DENNA ANVÄNDAS?

        ownedFishes.add(toAdd);
    }

    public ArrayList<Animal> getOwnedFishes() {
        return ownedFishes;
    }

    public boolean isPlayerActive() {
        return playerActive;
    }

    public void setPlayerActive(boolean playerActive) {
        this.playerActive = playerActive;
    }

    public boolean isPlayerRoundChoice() {
        return playerRoundChoice;
    }

    public void setPlayerRoundChoice(boolean playerRoundChoice) {
        this.playerRoundChoice = playerRoundChoice;
    }

    public void deathLoop() {

        for (int i = this.getOwnedFishes().size() - 1; i >= 0; i--) {
            if (this.getOwnedFishes().get(i).getHealth() < 1) {
                System.out.println("You just killed " + this.getOwnedFishes().get(i).getName() + " of the type " +
                        this.getOwnedFishes().get(i).getClass().getSimpleName());
                this.getOwnedFishes().remove(i);
            } else if (this.getOwnedFishes().get(i).getAgeFish() > this.getOwnedFishes().get(i).getMaxAgeFish()) {
                System.out.println(this.getOwnedFishes().get(i).getName() + " of the type " +
                        this.getOwnedFishes().get(i).getClass().getSimpleName() + " died because of age!");
                this.getOwnedFishes().remove(i);
            }
        }
        if ((this.getOwnedFishes().size() == 0) && (this.getMoney() == 0)) {

            playerActive = false;
        }

    }

    public void feedYourFish() {
        int inputChoice;

        do {
            myGame.menuSystem.feedFishMenu(this);
            inputChoice = ControlMethods.convertInputToInt();
            switch (inputChoice) {
                case 1: {
                    for (Animal feedFish : this.getOwnedFishes()) {

                        if (feedFish.isFlakes()) {
                            if (feedFish.getHealth() > 99) {
                                System.out.println(feedFish.getName() + " of the type " + feedFish.getClass().getSimpleName() + " already has full health no need for more food");
                            } else if (this.getOwnedFood()[0].getQuantityFood() > 0) {
                                System.out.println("Do you want to feed " + feedFish.getName() + " of the type " + feedFish.getClass().getSimpleName());
                                System.out.println("If you don´t want to feed the fish type NO else just press enter");
                                if (!ControlMethods.inputString().equalsIgnoreCase("no")) {
                                    this.getOwnedFood()[0].setQuantityFood(this.getOwnedFood()[0].getQuantityFood() - 1);
                                    feedFish.setHealth(feedFish.getHealthBoostFlakes() + feedFish.getHealth());
                                    setPlayerRoundChoice(true);
                                    if (feedFish.getHealth() > 100) {
                                        feedFish.setHealth(100);
                                    }
                                }
                            } else {
                                System.out.println(Food.FoodPrice.FLAKES + " is" + ControlMethods.errorOutOfStock + ". And " + feedFish.getName() + " starved");
                            }
                        }
                    }
                    break;
                }
                case 2: {
                    for (Animal feedFish : this.getOwnedFishes()) {
                        if (feedFish.isTetrabits()) {
                            if (feedFish.getHealth() > 99) {
                                System.out.println(feedFish.getName() + " of the type " + feedFish.getClass().getSimpleName() + " already has full health no need for more food");
                            } else if (this.getOwnedFood()[0].getQuantityFood() > 0) {
                                System.out.println("Do you want to feed " + feedFish.getName() + " of the type " + feedFish.getClass().getSimpleName());
                                System.out.println("If you don´t want to feed the fish type NO else just press enter");
                                if (!ControlMethods.inputString().equalsIgnoreCase("no")) {
                                    this.getOwnedFood()[0].setQuantityFood(this.getOwnedFood()[0].getQuantityFood() - 1);
                                    feedFish.setHealth(feedFish.getHealthBoostFlakes() + feedFish.getHealth());
                                    setPlayerRoundChoice(true);
                                    if (feedFish.getHealth() > 100) {
                                        feedFish.setHealth(100);
                                    }
                                }
                            } else {
                                System.out.println(Food.FoodPrice.TETRABITS + " is" + ControlMethods.errorOutOfStock + ". And " + feedFish.getName() + " starved");
                            }
                        }
                    }
                    break;
                }
                case 3: {
                    for (Animal feedFish : this.getOwnedFishes()) {
                        if (feedFish.isMeat()) {
                            if (feedFish.getHealth() > 99) {
                                System.out.println(feedFish.getName() + " of the type " + feedFish.getClass().getSimpleName() + " already has full health no need for more food");
                            }

                            if (this.getOwnedFood()[0].getQuantityFood() > 0) {
                                System.out.println("Do you want to feed " + feedFish.getName() + " of the type " + feedFish.getClass().getSimpleName());
                                System.out.println("If you don´t want to feed the fish type NO else just press enter");
                                if (!ControlMethods.inputString().equalsIgnoreCase("no")) {
                                    this.getOwnedFood()[0].setQuantityFood(this.getOwnedFood()[0].getQuantityFood() - 1);
                                    feedFish.setHealth(feedFish.getHealthBoostFlakes() + feedFish.getHealth());
                                    setPlayerRoundChoice(true);
                                    if (feedFish.getHealth() > 100) {
                                        feedFish.setHealth(100);
                                    }
                                }
                            } else {
                                System.out.println(Food.FoodPrice.MEAT + " is" + ControlMethods.errorOutOfStock + ". And " + feedFish.getName() + " starved");
                            }
                        }
                    }
                    break;
                }
            }
        } while ((inputChoice > 0) && (inputChoice < 4));
    }

    public void checkForPossibleBreedingCouples() {
        System.out.println("Here comes a list of breedable fish");

        for (int i = 0; i < this.getOwnedFishes().size(); i++) {
            if (this.getOwnedFishes().get(i).getGender().equalsIgnoreCase("male")) {
                int idNumber = 0;
                for (Animal checkBreedableMate : this.getOwnedFishes()) {

                    if (checkBreedableMate.getGender().equalsIgnoreCase("female")) {
                        if (checkBreedableMate.getClass() == this.ownedFishes.get(i).getClass()) {
                            System.out.println(this.getOwnedFishes().get(i).getClass().getSimpleName() + " - Male: "+ "["+i+"]" +  this.getOwnedFishes().get(i).getName()   + "\t\tFemale: " + "["+idNumber+"]" + checkBreedableMate.getName());
                        }
                    }
                                        idNumber++;
                }
                System.out.println("\n");
            }
        }
        System.out.println("Choose which couple you want to breed from");
        System.out.println("Enter male ID");
        int maleId = ControlMethods.convertInputToInt();
        System.out.println("Enter female ID");
        int femaleId = ControlMethods.convertInputToInt();
        if((this.getOwnedFishes().get(maleId).getClass().getSimpleName().equalsIgnoreCase(this.getOwnedFishes().get(femaleId).getClass().getSimpleName())) && (this.getOwnedFishes().get(maleId).getGender() != this.getOwnedFishes().get(femaleId).getGender()))
        {
              int breed = (int) (Math.random() * (20))+1;
              if (breed >10)
              {
                  System.out.println("The breeding went successfull, you now have new fish");
                  //Skapa For loop med Case
                  myGame.store.addNewFishBreeded(this, new Minnow());
              }
              else System.out.println("Sorry the breeding didn´t work");
        }




    }
}
