package Food;

import Game.Player;

public abstract class Food {
    public enum FoodPrice {
        FLAKES(2),
        TETRABITS(15),
        MEAT(25);

        public int foodPrice;

        FoodPrice(int foodPrice) {
            this.foodPrice = foodPrice;
        }
    }


    private int price;
    private int quantityFood = 0;


    public int getQuantityFood() {
        return quantityFood;
    }

    public void setQuantityFood(int quantityFood) {
        this.quantityFood = quantityFood;
    }



    public void setPrice(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    }
