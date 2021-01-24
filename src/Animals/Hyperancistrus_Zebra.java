package Animals;

public class Hyperancistrus_Zebra extends Animal {

    public Hyperancistrus_Zebra() {
        setPrice(Fishprice.HYPERANCISTRUS_ZEBRA.fishPrice);
        setTetrabits(true);
        setMeat(true);
        setMaxAgeFish(10);
        setHealthBoostTetrabits(15);
        setHealthBoostMeat(20);
        setOffspring((int) (Math.random() * (15)) + 5);
        setBreedChance(15);
    }

    @Override
    public int calculateValue() {
        int calculatedValue;
        int health = this.health();
        int price = this.price();
        if (this.getAgeFish() < 3)
            calculatedValue = (int) (((health * price) / 100) * 1.0);
        else
            calculatedValue = (int) (((health * price) / 100) * 0.8);

        if (calculatedValue < 300)
            calculatedValue = 300;
        if (isBreeded())
            calculatedValue = (calculatedValue * 2);

        return calculatedValue;

    }
}