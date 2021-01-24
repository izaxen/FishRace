package Animals;
import Game.*;

import java.io.Serializable;


public class Breeding implements Serializable {
    private Game myGame;
    public Breeding(Game myGame){
        this.myGame = myGame;
    }

    public void checkForPossibleBreedingCouples(Player player) {
        System.out.println("Here comes a list of breedable fish");//TODO Fix the printout
        System.out.printf("%-15.15s\t\t%3.3s\t%-10.10s\t\t\t%2$3.3s\t%-10.10s%n","TYPE","ID","MALENAME","FEMALENAME");
        int checkBreedable = 0;

        for (int i = 0; i < player.getOwnedFishes().size(); i++) {
            Animal fish = player.getOwnedFishes().get(i);

            if ((fish.getGender().equalsIgnoreCase("male")) && (fish.isDoneBreeding())) { //Checking for males that never been breeding
                int idNumber = 0;

                for (Animal checkBreedableMate : player.getOwnedFishes()) {

                    if ((checkBreedableMate.getGender().equalsIgnoreCase("female")) && (player.getOwnedFishes().get(idNumber).isDoneBreeding())) { //Checking for females that never been breeded
                        if (checkBreedableMate.getClass() == fish.getClass()) {
                            System.out.printf("%-15.15s\t\t[%1.3s]\t%-10.10s\t\t\t[%1.3s]\t%-10.10s%n",fish.getClass().getSimpleName(),i,fish.getName(), idNumber,checkBreedableMate.getName());
                            checkBreedable++;
                        }
                    }
                    idNumber++;
                }
                System.out.println("\n");
            }
        }
        if (checkBreedable != 0)
            tryToBreed(player);

        else
        {System.out.println("You have no breedable couples");}

        System.out.println("Press enter to continue");
        ControlMethods.inputString();



    }

    private void tryToBreed(Player player) {
        player.setPlayerRoundChoice(true);
        System.out.println("Choose which couple you want to breed from");
        System.out.println("Enter ID on first fish");
        int maleId = ControlMethods.convertInputToInt();
        System.out.println("Enter ID on second fish");
        int femaleId = ControlMethods.convertInputToInt();

        Animal maleFish = player.getOwnedFishes().get(maleId);
        Animal femaleFish = player.getOwnedFishes().get(femaleId);

        if ((maleFish.getClass().getSimpleName().equalsIgnoreCase(femaleFish.getClass().getSimpleName())) && (!maleFish.getGender().equals(femaleFish.getGender()))) { //Compare   that there is a breedable male and femlae from same class
            int breed = (int) (Math.random() * (femaleFish.getBreedChance())) + 1;

            if (breed > 9) {
                maleFish.setDoneBreeding(false);
                femaleFish.setDoneBreeding(false);
                System.out.println("The breeding went successful, you got " + femaleFish.getOffspring() + " new fish");

                for (int i = 0; i < femaleFish.getOffspring(); i++) {
                    switch (femaleFish.getClass().getSimpleName()) {
                        case "Minnow"-> addNewFishBreeded(player, new Minnow());
                        case "Corydoras_Sterbai"-> addNewFishBreeded(player, new Corydoras_Sterbai());
                        case "Angelfish"-> addNewFishBreeded(player, new Angelfish());
                        case "Piranha"-> addNewFishBreeded(player, new Piranha());
                        case "Hyperancistrus_Zebra"-> addNewFishBreeded(player, new Hyperancistrus_Zebra());
                    }
                }
            } else System.out.println("Sorry the breeding didn´t work");
        }
    }

    private void addNewFishBreeded(Player player, Animal fishToAdd) {
        System.out.println(ControlMethods.enterName);//TODO Add random name
        fishToAdd.setName(ControlMethods.inputString());
        fishToAdd.setBreeded(true);
        fishToAdd.setGender("breed");
        player.getOwnedFishes().add(fishToAdd);
        System.out.println(fishToAdd.getName() + " of the type " + fishToAdd.getClass().getSimpleName() + " with gender :"+ fishToAdd.getGender()+ " has been added to your owned fish.\n");
    }
}
