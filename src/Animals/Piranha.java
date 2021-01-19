package Animals;

public class Piranha extends Animal {

    public Piranha(){
        setPrice(Fishprice.PIRANHA.fishPrice);
        setMeat(true);
        setMaxAgeFish(30);
        setHealthBoostMeat(30);
        setOffspring((int) (Math.random() * (20))+10);
    }
}
