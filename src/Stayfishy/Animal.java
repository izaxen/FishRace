package Stayfishy;

abstract class Animal {


    public enum Fishprice {

        MINOW(30),
        CORYDORAS(80),
        ANGELFISH(150),
        PIRANHA(250),
        HYPERANCISTRUS(1050);

        public int price;


        private Fishprice(int price) {
            this.price = price;
        }
    }

    private String name;
    private int health = 100;
    private String gender;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {


        if ((!gender.equalsIgnoreCase("female")) && (!gender.equalsIgnoreCase("male")) || (gender.equalsIgnoreCase("breed")))
        { if (!gender.equalsIgnoreCase("breed"))
            {System.out.println("Since you didn´t make a correct choice the store just picks a random gender for you.");}

            gender = (Math.random() < 0.5) ? "female" : "male";
            System.out.printf("You got a %s%n",gender);
        }
        this.gender = gender;
    }


    private void breedAnimals() {

    }



}

