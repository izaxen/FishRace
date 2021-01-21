package Animals;

public class Corydoras_Sterbai extends Animal {

    public Corydoras_Sterbai(){
        setPrice(Fishprice.CORYDORAS_STERBAI.fishPrice);
        setTetrabits(true);
        setMaxAgeFish(20);
        setHealthBoostTetrabits(15);
        setOffspring((int) (Math.random() * (20))+5);
        setBreedChance(19);
    }
    @Override
    public int calculateValue(){
        int calculatedValue;
        int health = this.health();
        int price = this.price();

        if (this.getAgeFish() < 3)
            calculatedValue = (int) (((health * price) / 100) * 0.95);
        else if (this.getAgeFish() < 5)
            calculatedValue = (int) (((health * price) / 100) * 0.8);
        else
            calculatedValue = (int) (((health * price) / 100) * 0.6);

        if (calculatedValue < 16)
            calculatedValue = 15;
        if (isBreeded())
            calculatedValue = (int) (calculatedValue * 1.2);

        return calculatedValue;

    }
}
