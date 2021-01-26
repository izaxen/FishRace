package Animals;

public class Angelfish extends Animal {

    public Angelfish() {
        setPrice(Fishprice.ANGELFISH.fishPrice);
        setFlakes(true);
        setTetrabits(true);
        setMeat(true);
        setMaxAgeFish(10);
        setHealthBoostFlakes(5);
        setHealthBoostTetrabits(20);
        setHealthBoostMeat(10);
        setOffspring((int) (Math.random() * (10)) + 10);
        setBreedChance(17);
    }

    @Override
    public int calculateValue() {
        int calculatedValue;
        int health = this.health();
        int price = this.price();

        if (this.getAgeFish() < 2)
            calculatedValue = (int) (((health * price) / 100) * 0.60);
        else if (this.getAgeFish() < 4)
            calculatedValue = (int) (((health * price) / 100) * 1.0);
        else if (this.getAgeFish() < 5)
            calculatedValue = (int) (((health * price) / 100) * 0.7);
        else
            calculatedValue = (int) (((health * price) / 100) * 0.5);

        if (calculatedValue < 31)
            calculatedValue = 30;
        if (isBreeded())
            calculatedValue = (int) (calculatedValue * 1.3);
        return calculatedValue;
    }
}