package Animals;

import Game.Player;

public abstract class Animal {

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


        if ((!gender.equalsIgnoreCase("female")) && (!gender.equalsIgnoreCase("male")) || (gender.equalsIgnoreCase("breed"))) {
            if (!gender.equalsIgnoreCase("breed")) {
                System.out.println("Since you didn´t make a correct choice the store just picks a random gender for you.");
            }

            gender = (Math.random() < 0.5) ? "female" : "male";
            System.out.printf("You got a %s%n", gender);
        }
        this.gender = gender;
    }


    private void breedAnimals() {

    }

    public int calculateValue() {

        return ((this.getHealth() * this.getPrice()) / 100);
    }


}

