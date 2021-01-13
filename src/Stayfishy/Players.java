package Stayfishy;

import java.util.ArrayList;

public class Players {


    private String name;
    private int money = 1000;
    private ArrayList<Animal> ownedFishes = new ArrayList();


    public Players(String name) {
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
}
