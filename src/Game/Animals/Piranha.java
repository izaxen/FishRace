package Game.Animals;

public class Piranha extends Animal {

    public Piranha() {
        setPrice(Fishprice.PIRANHA.fishPrice);
        setMeat(true);
        setMaxAgeFish(30);
        setHealthBoostMeat(30);
        setOffspring((int) (Math.random() * (20)) + 10);
        setBreedChance(16);
    }

    @Override
    public int calculateValue() {
        int calculatedValue;
        int health = this.health();
        int price = this.price();

        if (this.getAgeFish() < 3)
            calculatedValue = (int) (((health * price) / 100) * 0.60);
        else if (this.getAgeFish() < 5)
            calculatedValue = (int) (((health * price) / 100) * 0.9);
        else if (this.getAgeFish() < 10)
            calculatedValue = (int) (((health * price) / 100) * 0.7);
        else
            calculatedValue = (int) (((health * price) / 100) * 0.3);

        if (calculatedValue < 51)
            calculatedValue = 50;
        if (isBreeded())
            calculatedValue = (int) (calculatedValue * 1.4);

        return calculatedValue;
    }
}