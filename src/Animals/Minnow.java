package Animals;

public class Minnow extends Animal {

    public Minnow() {
    setPrice(Fishprice.MINNOW.fishPrice);
    setFlakes(true);
    setMaxAgeFish(5);
    setHealthBoostFlakes(10);
    setOffspring((int) (Math.random() * (10))+5);
    setBreedChance(20);
    }
}

