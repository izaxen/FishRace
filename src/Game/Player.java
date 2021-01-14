package Game;

import Animals.Animal;

import java.util.ArrayList;

public class Player {


    private String name;
    private int money = 1100;
    public ArrayList<Animal> ownedFishes = new ArrayList();


    public Player(String name) {
        this.name = name;

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

    public void addNewFish(Animal toAdd){

        ownedFishes.add(toAdd);


    }
}
