package Animals;
import Game.*;
import java.io.Serializable;

public class Breeding implements Serializable {
    private final Game myGame;

    public Breeding(Game myGame) {
        this.myGame = myGame;
    }

    public void checkForPossibleBreedingCouples(Player player) {
        System.out.println("Here comes a list of breedable fish");
        System.out.printf("%-15.15s\t\t%3.3s\t%-10.10s\t\t\t%2$3.3s\t%-10.10s%n", "TYPE", "ID", "MALENAME", "FEMALENAME");
        int checkBreedable = 0;

        for (int i = 0; i < player.getOwnedFishes().size(); i++) {
            Animal fish = player.getOwnedFishes().get(i);

            if ((fish.getGender().equalsIgnoreCase("male")) && (fish.isDoneBreeding())) { //Checking for males that never been breeding
                int idNumber = 0;

                for (Animal checkBreedableMate : player.getOwnedFishes()) {

                    if ((checkBreedableMate.getGender().equalsIgnoreCase("female")) && (player.getOwnedFishes().get(idNumber).isDoneBreeding())) { //Checking for females that never been breeded
                        if (checkBreedableMate.getClass() == fish.getClass()) {
                            System.out.printf("%-15.15s\t\t[%1.3s]\t%-10.10s\t\t\t[%1.3s]\t%-10.10s%n", fish.getClass().getSimpleName(), i, fish.getName(), idNumber, checkBreedableMate.getName());
                            checkBreedable++;
                        }
                    }
                    idNumber++;
                }
                System.out.println("\n");
            }
        }
        if (checkBreedable != 0)
        {tryToBreed(player);
        return;}

        else {
            System.out.println("You have no breedable couples");
        }
        GameUtils.waitMilliSeconds(1200);
    }

    private void tryToBreed(Player player) {
        player.setPlayerRoundChoice(true);
        System.out.println("Choose which couple you want to breed from");
        System.out.println("Enter ID on first fish");
        int maleId = GameUtils.convertInputToInt(0, player.getOwnedFishes().size()-1);
        System.out.println("Enter ID on second fish");
        int femaleId = GameUtils.convertInputToInt(0, player.getOwnedFishes().size()-1);

        Animal maleFish = player.getOwnedFishes().get(maleId);
        Animal femaleFish = player.getOwnedFishes().get(femaleId);

        if (((maleFish.getClass().getSimpleName().equalsIgnoreCase(femaleFish.getClass().getSimpleName())) &&
                (!maleFish.getGender().equals(femaleFish.getGender()))) && maleFish.isDoneBreeding() && femaleFish.isDoneBreeding()) { //Compare that there is a breedable male and female from same class and not been breed before

            int breed = (int) (Math.random() * (femaleFish.getBreedChance())) + 1;

            if (breed > 9) {
                maleFish.setDoneBreeding(false);
                femaleFish.setDoneBreeding(false);
                System.out.println("The breeding went successful, you got " + femaleFish.getOffspring() + " new fish");

                for (int i = 0; i < femaleFish.getOffspring(); i++) {
                    switch (femaleFish.getClass().getSimpleName()) {
                        case "Minnow" -> addNewFishBreeded(player, new Minnow());
                        case "Corydoras_Sterbai" -> addNewFishBreeded(player, new Corydoras_Sterbai());
                        case "Angelfish" -> addNewFishBreeded(player, new Angelfish());
                        case "Piranha" -> addNewFishBreeded(player, new Piranha());
                        case "Hyperancistrus_Zebra" -> addNewFishBreeded(player, new Hyperancistrus_Zebra());
                    }
                }
            } else {
                System.out.println("Sorry the breeding didn´t work");
                GameUtils.waitMilliSeconds(1200);
            }
        }else
        {System.out.println("You have entered invalid ID ");
        checkForPossibleBreedingCouples(player);}
    }

    private void addNewFishBreeded(Player player, Animal fishToAdd) {
        System.out.println(GameUtils.enterName);
        System.out.println(GameUtils.randomName);
        fishToAdd.setName(GameUtils.inputString());
        fishToAdd.setBreeded(true);
        fishToAdd.setGender("breed");
        if (fishToAdd.getName().equals("")) {
            fishToAdd.setName(myGame.randomNames.genderSelectNames(fishToAdd.getGender()));
        }
        player.getOwnedFishes().add(fishToAdd);
        System.out.println(fishToAdd.getName() + " of the type " + fishToAdd.getClass().getSimpleName() + " with gender :" + fishToAdd.getGender() + " has been added to your owned fish.\n");
    }
}
