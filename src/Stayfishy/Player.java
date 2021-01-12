package Stayfishy;

import java.util.ArrayList;

public class Player {
    public int getMoney() {
        return money;
    }

    private String name;
private int money = 1000;
private ArrayList<Animal> ownedFishes =new ArrayList();


    public void setMoney(int money) {
        this.money = money;
    }

    public String getName() {
        return name;
    }


    public Player(String name){
        this.name = name;



    }
}
