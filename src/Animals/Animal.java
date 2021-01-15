package Animals;

import Game.Player;

public abstract class Animal {
    public enum Fishprice{
        MINOW(30),
        CORYDORAS_STERBAI(80),
        ANGELFISH(150),
        PIRANHA(300),
        HYPERANCISTRUS_ZEBRA(1100);

       public int price;
       private Fishprice(int price){
           this.price = price;
       }
    }

    private String name;
    private int health = 100;
    private String gender;
    private int price;

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {

        if ((!gender.equalsIgnoreCase("1")) && (!gender.equalsIgnoreCase("2")) || (gender.equalsIgnoreCase("breed"))) {
            if (!gender.equalsIgnoreCase("breed")) {
                System.out.println("The store picked a random gender");
            }
            gender = (Math.random() < 0.5) ? "female" : "male";
            System.out.printf("You got a %s%n", gender);
        }
        if (gender.equalsIgnoreCase("1"))
            gender = "female";
        else  if (gender.equalsIgnoreCase("2"))
            gender = "male";
        this.gender = gender;
    }


    private void breedAnimals() {

    }

    public int calculateValue() {

        return ((this.getHealth() * this.getPrice()) / 100);
    }


}

