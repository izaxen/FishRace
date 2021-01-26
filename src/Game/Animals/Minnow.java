package Game.Animals;

public class Minnow extends Animal {

    public Minnow() {
    setPrice(Fishprice.MINNOW.fishPrice);
    setFlakes(true);
    setMaxAgeFish(5);
    setHealthBoostFlakes(10);
    setOffspring((int) (Math.random() * (10))+5);
    setBreedChance(30);
   }
   @Override
   public int calculateValue(){
       int calculatedValue;
       int health = this.health();
       int price = this.price();

       if (this.getAgeFish() == 1)
           calculatedValue = (int) (((health * price) / 100) * 0.8);// Makes value on the fish depending on health and age
       else if (this.getAgeFish() == 2)
           calculatedValue = (int) (((health * price) / 100) * 0.9);
       else
           calculatedValue = (int) (((health * price) / 100) * 0.8);

       if (calculatedValue < 6)
           calculatedValue = 5; // a minimum value for a fish that is alive.
       if (isBreeded())
           calculatedValue = (int) (calculatedValue * 1.2);//If the fish is breeded you get a better price for the fish

       return calculatedValue;
   }
}

