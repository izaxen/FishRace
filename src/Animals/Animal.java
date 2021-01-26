package Animals;
import java.io.Serializable;

public abstract class Animal implements Serializable {
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

    private String gender;
    private String name;
    private int health = 100;
    private int price;
    private int maxAgeFish;
    private int ageFish;
    private int healthBoostFlakes;
    private int HealthBoostTetrabits;
    private int HealthBoostMeat;
    private int offspring;
    private int breedChance;
    private boolean flakes = false;
    private boolean tetrabits = false;
    private boolean meat = false;
    private boolean breeded = false;
    private boolean doneBreeding = true;



    public void setGender(String gender) {
        //When incoming String equals breed the method goes straight to choose a random gender for breeded animals.
        //If user hasn´t done a active choice it will also pick a random gender
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



    public void decreaseHealthAndAge() {
        this.health -= (int) (Math.random() * (20)) + 10; //10-30% of the HP will disappear
        this.ageFish = this.ageFish + 1;

    }

    public int calculateValue() {
       return 0;
    }

    public boolean isBreeded() {return breeded;}

    public boolean isDoneBreeding() {return doneBreeding;}

    public void setDoneBreeding(boolean doneBreeding) {
        this.doneBreeding = doneBreeding;
    }

    public int getOffspring() {
        return offspring;
    }

    public void setOffspring(int offspring) {
        this.offspring = offspring;
    }

    public int getHealthBoostFlakes() {
        return healthBoostFlakes;
    }

    public void setHealthBoostFlakes(int healthBoostFlakes) {
        this.healthBoostFlakes = healthBoostFlakes;
    }

    public void setHealthBoostTetrabits(int healthBoostTetrabits) {
        HealthBoostTetrabits = healthBoostTetrabits;
    }

    public void setHealthBoostMeat(int healthBoostMeat) {
        HealthBoostMeat = healthBoostMeat;
    }

    public int getAgeFish() {
        return ageFish;
    }

    public int getMaxAgeFish() {
        return maxAgeFish;
    }

    public boolean isFlakes() {
        return flakes;
    }

    public void setFlakes(boolean flakes) {
        this.flakes = flakes;
    }

    public void setTetrabits(boolean tetrabits) {
        this.tetrabits = tetrabits;
    }

    public void setMeat(boolean meat) {
        this.meat = meat;
    }

    public int price() {
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

    public int health() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setBreeded(boolean breeded) {this.breeded = breeded;}

    public void setMaxAgeFish(int maxAgeFish) {
        this.maxAgeFish = maxAgeFish;
    }

    public int getBreedChance() {
        return breedChance;
    }

    public void setBreedChance(int breedChance) {
        this.breedChance = breedChance;
    }

    public String getGender() {
        return gender;
    }

    public boolean isMeat() {
        return meat;
    }

    public boolean isTetrabits() {
        return tetrabits;
    }

    public int getHealthBoostTetrabits() {return HealthBoostTetrabits;}

    public int getHealthBoostMeat() {return HealthBoostMeat;}

    public int getHealth() {return health;}
}



