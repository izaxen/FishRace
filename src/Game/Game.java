package Game;

import Animals.*;
import Food.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;


public class Game implements Serializable {

    private int inputInt;
    private int gameRounds;
    private int activePlayer = 0;
    private int gameRoundsLeft = 1;
    private final ArrayList<Player> contestants = new ArrayList<>();

    Store store = new Store(this);
    public MenuSystem menuSystem = new MenuSystem(this);
    Breeding breeding = new Breeding(this);
    Feeding feeding = new Feeding(this);
    GameLoader gameLoader = new GameLoader(this);

    public Game() {
        setupGame();
    }

    private void setupGame() {
        System.out.printf("%n%1$s%n*\t\t\t\t\t\t\tWelcome to the game Stayfishy\t\t\t\t\t\t *%n%1$s%n", MenuSystem.starRow);
        System.out.println("\t\t\t\t\t\t\t[1] Start a new game\n" +
                "\t\t\t\t\t\t\t[2] Load Game\n");
        int loadGame = ControlMethods.convertInputToInt(1,2);

        if (loadGame == 1) {

            menuSystem.mainScreen();
            System.out.println("Welcome, now we gonna setup the game\n\n" +
                    "Please insert how many players 1-4.");

            inputInt = ControlMethods.convertInputToInt(1, 4);
            for (int i = 0; i < inputInt; i++) {
                System.out.printf("Enter player %d name:%n", i + 1);
                Player player = new Player(ControlMethods.inputString());
                contestants.add(player);
                player.setMyGame(this);
            }


            System.out.println("Please insert how many round you want to play 5-30:");
            gameRounds = ControlMethods.convertInputToInt(5, 30);
            gamePlay();
        }

        if (loadGame ==2) gameLoader.loadGame();
    }

    public void gamePlay() {

        while (gameRoundsLeft < gameRounds) {

            while (activePlayer < contestants.size() )
             {  Player playa = contestants.get(activePlayer);
                ControlMethods.clearScreen();

                if ((playa.isPlayerActive()) && (gameRoundsLeft > 1)) {
                    playa.setPlayerRoundChoice(false);
                    for (Animal fish : playa.getOwnedFishes()) {
                        fish.decreaseHealthAndAge();
                    }
                    playa.deathHealthAgeLoop();
                }
                if (playa.isPlayerActive()) {
                    chooseActionMainMenu(playa);
                } else
                {System.out.println(playa.getName() + " is out of the game\n" +
                            "Next player");}
                activePlayer++;

             }
            activePlayer = 0;
            gameRoundsLeft++;
                    }
        store.sellAllFishEndGame();
        endGameScoreList();

    }

    public void chooseActionMainMenu(Player player) {
        do {
            menuSystem.mainMenu(player);
            inputInt = ControlMethods.convertInputToInt(1, 9);//TODO Fix Load game
            switch (inputInt) {
                case 1 -> store.buyFishChoice(player);
                case 2 -> store.sellFishChoice(player);
                case 3 -> store.buyFoodChoice(player);
                case 4 -> feeding.chooseFoodToFeedWith(player); //Feed fish
                case 5 -> breeding.checkForPossibleBreedingCouples(player);
                case 6 -> store.listOwnedFish(player);
                case 7 -> System.out.println("Lazy one");
                case 8 -> gameLoader.saveGame(this);
                case 9 -> gameLoader.loadGame();
            }
        } while (((inputInt == 6) || (inputInt == 8) || ((inputInt == 5) && (!player.isPlayerRoundChoice()))));
    }

    private void endGameScoreList() {
        contestants.sort(Comparator.comparing(Player::getMoney).reversed());
        System.out.println("Result of the game");

        for (int i = 0; i < contestants.size(); i++) {
            Player player = contestants.get(i);
            switch (i) {

                case 3 -> scoreListFour(i);
                case 2 -> scoreListThree(i);
                case 1 -> {
                    if (player.getMoney() == contestants.get(i - 1).getMoney()) {
                        System.out.println((i) + " place: " + player.getName() + " with " + player.getMoney());
                    } else
                        System.out.println((i + 1) + " place: " + player.getName() + " with " + player.getMoney());
                }
                case 0 -> System.out.println((1) + " place: " + player.getName() + " with " + player.getMoney());
            }
        }
    }

    private void scoreListFour(int i) {
        Player player = contestants.get(i);

        if (player.getMoney() == contestants.get(i - 3).getMoney()) {
            System.out.println((i - 2) + " place: " + player.getName() + " with " + player.getMoney());
        } else if (player.getMoney() == contestants.get(i - 2).getMoney()) {
            System.out.println((i - 1) + " place: " + player.getName() + " with " + player.getMoney());
        } else if (player.getMoney() == contestants.get(i - 1).getMoney()) {
            System.out.println((i) + " place: " + player.getName() + " with " + player.getMoney());
        } else System.out.println((i + 1) + " place: " + player.getName() + " with " + player.getMoney());
    }

    private void scoreListThree(int i) {

        Player player = contestants.get(i);
        if (player.getMoney() == contestants.get(i - 2).getMoney()) {
            System.out.println((i - 1) + " place: " + player.getName() + " with " + player.getMoney());
        } else if (player.getMoney() == contestants.get(i - 1).getMoney()) {
            System.out.println((i) + " place: " + player.getName() + " with " + player.getMoney());
        } else System.out.println((i + 1) + " place: " + player.getName() + " with " + player.getMoney());
    }

    public ArrayList<Player> getContestants() {
        return contestants;
    }
    public int getGameRoundsLeft() {
        return gameRoundsLeft;
    }

}