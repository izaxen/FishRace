package Animals;

public class Angelfish extends Animal {

    public Angelfish(){
        setPrice(Fishprice.ANGELFISH.fishPrice);
        setFlakes(true);
        setTetrabits(true);
        setMeat(true);
        setMaxAgeFish(10);
        setHealthBoostFlakes(5);
        setHealthBoostTetrabits(20);
        setHealthBoostMeat(10);
        setOffspring((int) (Math.random() * (20))+10);
        setBreedChance(18);
    }
}
