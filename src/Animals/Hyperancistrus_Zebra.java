package Animals;

public class Hyperancistrus_Zebra extends Animal {

    public Hyperancistrus_Zebra(){
        setPrice(Fishprice.HYPERANCISTRUS_ZEBRA.fishPrice);
        setTetrabits(true);
        setMeat(true);
        setMaxAgeFish(10);
        setHealthBoostTetrabits(15);
        setHealthBoostMeat(20);
        setOffspring((int) (Math.random() * (10))+5);
    }
}
