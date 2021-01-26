package Game;

import Animals.Animal;
import Food.*;

import java.io.Serializable;
import java.util.ArrayList;

public class Player implements Serializable {

    private Game myGame;

    private String name;
    private int money = 3000;
    private boolean playerActive = true;
    private boolean playerRoundChoice = false;

    private final ArrayList<Animal> ownedFishes = new ArrayList();


    private final Food[] ownedFood = {
            new Flakes(),
            new Tetrabits(),
            new Meat()};


    public void deathHealthAgeLoop() {

        System.out.println("Here comes a status on your fish");
        System.out.println("It will show if your fish gets below 50 in health and getting a high age.\n");


        for (int i = this.getOwnedFishes().size() - 1; i >= 0; i--) {
            Animal fish = this.getOwnedFishes().get(i);
            if (fish.health() < 1) {
                System.out.println("You just killed " + fish.getName() + " of the type " +
                        fish.getClass().getSimpleName());
                this.getOwnedFishes().remove(i);
            } else if (fish.getAgeFish() > fish.getMaxAgeFish()) {
                System.out.println(fish.getName() + " of the type " +
                        fish.getClass().getSimpleName() + " died because of age!");
                this.getOwnedFishes().remove(i);
            }
            if ((fish.getHealth() < 50) && (fish.getAgeFish() <= fish.getMaxAgeFish())) {
                System.out.println(fish.getName() + ". Of the type " + fish.getClass().getSimpleName() + " only has " +
                                fish.getHealth() + " health left and starving, feed it!");
            }
            if ((fish.getAgeFish()+3)> fish.getMaxAgeFish())
                System.out.println(fish.getName() + ". Of the type " + fish.getClass().getSimpleName()
                + " has less then 3 years to live");
        }
        System.out.println("\n");
        if ((this.getOwnedFishes().size() == 0) && (this.getMoney() == 0)) {
            playerActive = false;
        }
    }

    public Player(String name) {this.name = name;}

    public Food[] getOwnedFood() {return ownedFood;}

    public int getMoney() {return money;}

    public void setMoney(int money) {this.money = money;}

    public String getName() {return name;}

    public ArrayList<Animal> getOwnedFishes() {return ownedFishes;}

    public boolean isPlayerActive() {return playerActive;}

    public boolean isPlayerRoundChoice() {return playerRoundChoice;}

    public void setPlayerRoundChoice(boolean playerRoundChoice) {this.playerRoundChoice = playerRoundChoice;}

    public void setMyGame(Game myGame) {this.myGame = myGame;}
}
