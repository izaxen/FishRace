package Animals;

import java.util.Random;

public abstract class Animal {
    public enum Fishprice {
        MINNOW(30),
        CORYDORAS_STERBAI(80),
        ANGELFISH(150),
        PIRANHA(300),
        HYPERANCISTRUS_ZEBRA(1100);

        public int fishPrice;

        Fishprice(int fishPrice) {
            this.fishPrice = fishPrice;
        }
    }

    private String name;
    private int health = 100;

    public boolean isBreeded() {
        return breeded;
    }

    public void setBreeded(boolean breeded) {
        this.breeded = breeded;
    }

    private String gender;
    private int price;
    private boolean flakes = false;
    private boolean tetrabits = false;
    private boolean meat = false;
    private boolean breeded = false;
    private int healthBoostFlakes;
    private int HealthBoostTetrabits;
    private int HealthBoostMeat;

    public int getHealthBoostFlakes() {
        return healthBoostFlakes;
    }

    public void setHealthBoostFlakes(int healthBoostFlakes) {
        this.healthBoostFlakes = healthBoostFlakes;
    }

    public int getHealthBoostTetrabits() {
        return HealthBoostTetrabits;
    }

    public void setHealthBoostTetrabits(int healthBoostTetrabits) {
        HealthBoostTetrabits = healthBoostTetrabits;
    }

    public int getHealthBoostMeat() {
        return HealthBoostMeat;
    }

    public void setHealthBoostMeat(int healthBoostMeat) {
        HealthBoostMeat = healthBoostMeat;
    }



    public int getAgeFish() {
        return ageFish;
    }

    public void setAgeFish(int ageFish) {
        this.ageFish = ageFish;
    }

    public int getMaxAgeFish() {
        return maxAgeFish;
    }

    private int maxAgeFish;
    private int ageFish;

    public boolean isFlakes() {
        return flakes;
    }

    public void setFlakes(boolean flakes) {
        this.flakes = flakes;
    }

    public boolean isTetrabits() {
        return tetrabits;
    }

    public void setTetrabits(boolean tetrabits) {
        this.tetrabits = tetrabits;
    }

    public boolean isMeat() {
        return meat;
    }

    public void setMeat(boolean meat) {
        this.meat = meat;
    }

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
        else if (gender.equalsIgnoreCase("2"))
            gender = "male";
        this.gender = gender;
    }


    private void breedAnimals() {

    }

    public void setMaxAgeFish(int maxAgeFish) {
        this.maxAgeFish = maxAgeFish;
    }

    public void decreaseHealthAndAge() {
        Random random = new Random();
        //this.health = this.health - (random.ints(10, 31).findFirst().getAsInt());
        this.health -=  (int) (Math.random() * (20))+10;
        this.ageFish = this.ageFish + 1;
        if ((this.health > 0) && (this.ageFish <= this.maxAgeFish)) {
            System.out.println(this.health + " in health left for " + this.getName() + ". Of the type " + this.getClass().getSimpleName() + "" +
                    "\nAnd have reached the age of " + this.ageFish);
        }
    }


    public int calculateValue() {
        int calculatedValue = 0;
        if (this instanceof Minnow) {
            if (this.ageFish == 1)
                calculatedValue = (int) (((this.getHealth() * this.getPrice()) / 100) * 1.2);
            else if (this.ageFish == 2)
                calculatedValue = (int) (((this.getHealth() * this.getPrice()) / 100) * 0.8);
            else if (this.ageFish >= 3)
                calculatedValue = (int) (((this.getHealth() * this.getPrice()) / 100) * 0.6);

            if (calculatedValue < 6)
                calculatedValue = 5;
            if (breeded = true)
                calculatedValue = (int) (calculatedValue * 1.1);

        }
        if (this instanceof Corydoras_Sterbai) {
            if (this.ageFish < 3)
                calculatedValue = (int) (((this.getHealth() * this.getPrice()) / 100) * 1.2);
            else if (this.ageFish < 5)
                calculatedValue = (int) (((this.getHealth() * this.getPrice()) / 100) * 0.8);
            else if (this.ageFish >= 5)
                calculatedValue = (int) (((this.getHealth() * this.getPrice()) / 100) * 0.6);

            if (calculatedValue < 16)
                calculatedValue = 15;
            if (breeded = true)
                calculatedValue = (int) (calculatedValue * 1.2);

        }
        if (this instanceof Angelfish) {
            if (this.ageFish < 3)
                calculatedValue = (int) (((this.getHealth() * this.getPrice()) / 100) * 1.2);
            else if (this.ageFish < 5)
                calculatedValue = (int) (((this.getHealth() * this.getPrice()) / 100) * 0.8);
            else if (this.ageFish >= 5)
                calculatedValue = (int) (((this.getHealth() * this.getPrice()) / 100) * 0.6);

            if (calculatedValue < 31)
                calculatedValue = 30;
            if (breeded = true)
                calculatedValue = (int) (calculatedValue * 1.3);

        }
        if (this instanceof Piranha) {
            if (this.ageFish < 3)
                calculatedValue = (int) (((this.getHealth() * this.getPrice()) / 100) * 1.0);
            else if (this.ageFish < 10)
                calculatedValue = (int) (((this.getHealth() * this.getPrice()) / 100) * 0.9);
            else if (this.ageFish >= 10)
                calculatedValue = (int) (((this.getHealth() * this.getPrice()) / 100) * 0.6);

            if (calculatedValue < 51)
                calculatedValue = 50;
            if (breeded = true)
                calculatedValue = (int) (calculatedValue * 1.4);

        }
        if (this instanceof Hyperancistrus_Zebra) {
            if (this.ageFish < 3)
                calculatedValue = (int) (((this.getHealth() * this.getPrice()) / 100) * 1.2);
            else if (this.ageFish < 5)
                calculatedValue = (int) (((this.getHealth() * this.getPrice()) / 100) * 0.9);
            else if (this.ageFish >= 5)
                calculatedValue = (int) (((this.getHealth() * this.getPrice()) / 100) * 0.8);

            if (calculatedValue < 51)
                calculatedValue = 50;
            if (breeded = true)
                calculatedValue = (int) (calculatedValue * 2);

        }
        return calculatedValue;
    }
}



