package Animals;

public class Corydoras_Sterbai extends Animal {

    public Corydoras_Sterbai(){
        setPrice(Fishprice.CORYDORAS_STERBAI.fishPrice);
        setTetrabits(true);
        setMaxAgeFish(20);
        setHealthBoostTetrabits(15);
        setOffspring((int) (Math.random() * (20))+5);
    }
}
