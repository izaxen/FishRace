package Game;

import Animals.Animal;
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
        this.myGame = myGame;
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

    public ArrayList<Animal> getOwnedFishes() {
        return ownedFishes;
    }

    public boolean isPlayerActive() {
        return playerActive;
    }

    public boolean isPlayerRoundChoice() {
        return playerRoundChoice;
    }

    public void setPlayerRoundChoice(boolean playerRoundChoice) {
        this.playerRoundChoice = playerRoundChoice;
    }

    public void deathLoop() {

        for (int i = this.getOwnedFishes().size() - 1; i >= 0; i--) {
            if (this.getOwnedFishes().get(i).health() < 1) {
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




}
