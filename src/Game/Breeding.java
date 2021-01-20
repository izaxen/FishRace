package Game;

import Animals.*;

public class Breeding {

    private Game myGame;

    public Breeding(Game myGame) {
        this.myGame = myGame;

    }


    public void checkForPossibleBreedingCouples(Player player) {
        System.out.println("Here comes a list of breedable fish"); //TODO Lägg till om du inte kan breeda
        int checkBreedable = 0;
        for (int i = 0; i < player.getOwnedFishes().size(); i++) {
            if ((player.getOwnedFishes().get(i).getGender().equalsIgnoreCase("male")) &&(!player.getOwnedFishes().get(i).isDoneBreeding())){
                int idNumber = 0;

                for (Animal checkBreedableMate : player.getOwnedFishes()) {

                    if ((checkBreedableMate.getGender().equalsIgnoreCase("female")) && (!player.getOwnedFishes().get(idNumber).isDoneBreeding())) {
                        if (checkBreedableMate.getClass() == player.getOwnedFishes().get(i).getClass()) {
                            System.out.println(player.getOwnedFishes().get(i).getClass().getSimpleName() + " - Male: " + "[" + i + "]" + player.getOwnedFishes().get(i).getName() + "\t\tFemale: " + "[" + idNumber + "]" + checkBreedableMate.getName());
                        checkBreedable++;
                        }
                    }
                    idNumber++;
                }
                System.out.println("\n");
            }
        }
        if(checkBreedable != 0)
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
        if ((player.getOwnedFishes().get(maleId).getClass().getSimpleName().equalsIgnoreCase(player.getOwnedFishes().get(femaleId).getClass().getSimpleName())) && (player.getOwnedFishes().get(maleId).getGender() != player.getOwnedFishes().get(femaleId).getGender())) {
            int breed = (int) (Math.random() * (player.getOwnedFishes().get(femaleId).getBreedChance())) + 1;
            if (breed > 10) {
                player.getOwnedFishes().get(maleId).setDoneBreeding(true);
                player.getOwnedFishes().get(femaleId).setDoneBreeding(true);
                System.out.println("The breeding went successful, you got "+ player.getOwnedFishes().get(femaleId).getOffspring()+" new fish");
                for (int i = 0; i < player.getOwnedFishes().get(femaleId).getOffspring(); i++) {
                    switch (player.getOwnedFishes().get(femaleId).getClass().getSimpleName()) {
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

    private void addNewFishBreeded(Player player, Animal toAdd) {
        System.out.println(ControlMethods.enterName);//TODO Add random name
        toAdd.setName(ControlMethods.inputString());
        toAdd.setBreeded(true);
        toAdd.setGender("breed");
        player.getOwnedFishes().add(toAdd);
        System.out.println(toAdd.getName() + " of the type " + toAdd.getClass().getSimpleName() + " has been added to your owned fish.\n");
    }
}
