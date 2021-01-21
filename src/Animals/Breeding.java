package Animals;
import Game.*;




public class Breeding {

    private Game myGame;

    public Breeding(Game myGame) {
        this.myGame = myGame;

    }

    public void checkForPossibleBreedingCouples(Player player) {
        System.out.println("Here comes a list of breedable fish"); //TODO Lägg till om du inte kan breeda
        int checkBreedable = 0;

        for (int i = 0; i < player.getOwnedFishes().size(); i++) {
            Animal fish = player.getOwnedFishes().get(i);

            if ((fish.getGender().equalsIgnoreCase("male")) && (!fish.isDoneBreeding())) { //Checking for males that never been breeding
                int idNumber = 0;

                for (Animal checkBreedableMate : player.getOwnedFishes()) {

                    if ((checkBreedableMate.getGender().equalsIgnoreCase("female")) && (!player.getOwnedFishes().get(idNumber).isDoneBreeding())) { //Checking for females that never been breeded
                        if (checkBreedableMate.getClass() == fish.getClass()) {
                            System.out.println(fish.getClass().getSimpleName() + " - Male: " + "[" + i + "]" + fish.getName() + "\t\tFemale: " + "[" + idNumber + "]" + checkBreedableMate.getName());
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
            System.out.println("You have no breedable couples");
    }

    private void tryToBreed(Player player) {
        System.out.println("Choose which couple you want to breed from");
        System.out.println("Enter male ID");
        int maleId = ControlMethods.convertInputToInt();
        System.out.println("Enter female ID");
        int femaleId = ControlMethods.convertInputToInt();

        Animal maleFish = player.getOwnedFishes().get(maleId);
        Animal femaleFish = player.getOwnedFishes().get(femaleId);

        if ((maleFish.getClass().getSimpleName().equalsIgnoreCase(femaleFish.getClass().getSimpleName())) && (maleFish.getGender() != femaleFish.getGender())) {
            int breed = (int) (Math.random() * (femaleFish.getBreedChance())) + 1;

            if (breed > 9) {
                maleFish.setDoneBreeding(true);
                femaleFish.setDoneBreeding(true);
                System.out.println("The breeding went successful, you got " + femaleFish.getOffspring() + " new fish");

                for (int i = 0; i < femaleFish.getOffspring(); i++) {
                    switch (femaleFish.getClass().getSimpleName()) {
                        case "Minnow": {
                            addNewFishBreeded(player, new Minnow());
                            break;
                        }
                        case "Corydoras_Sterbai": {
                            addNewFishBreeded(player, new Corydoras_Sterbai());
                            break;
                        }
                        case "Angelfish": {
                            addNewFishBreeded(player, new Angelfish());
                        }
                        case "Piranha": {
                            addNewFishBreeded(player, new Piranha());
                            break;
                        }
                        case "Hyperancistrus_Zebra": {
                            addNewFishBreeded(player, new Hyperancistrus_Zebra());
                        }
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
        System.out.println(fishToAdd.getName() + " of the type " + fishToAdd.getClass().getSimpleName() + " has been added to your owned fish.\n");
    }
}
