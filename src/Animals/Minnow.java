package Animals;

public class Minnow extends Animal {

    public Minnow() {
    setPrice(Fishprice.MINNOW.fishPrice);
    setFlakes(true);
    setMaxAgeFish(5);
    setHealthBoostFlakes(15);
    setOffspring((int) (Math.random() * (10))+5);


    }

}

