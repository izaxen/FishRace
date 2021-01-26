package Game;

import Game.Animals.*;
import Game.Food.*;
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
    Breeding breeding = new Breeding(this);
    Feeding feeding = new Feeding(this);
    GameLoader gameLoader = new GameLoader(this);
    public RandomNames randomNames = new RandomNames();
    public MenuSystem menuSystem = new MenuSystem(this);

    public Game() {
        setupGame();
    }

    public void setupGame() {
        System.out.printf("%n%1$s%n*\t\t\t\t\t\t\tWelcome to the game Stayfishy\t\t\t\t\t\t *%n%1$s%n", MenuSystem.starRow);
        System.out.println("\t\t\t\t\t\t\t[1] Start a new game\n" +
                "\t\t\t\t\t\t\t[2] Load Game\n");

        GameUtils.introFish();
        int loadGame = GameUtils.convertInputToInt(1,2);

        if (loadGame == 1) {

            menuSystem.mainScreen();
            System.out.println("Welcome, now we gonna setup the game\n\n" +
                    "Please insert how many players 1-4.");

            inputInt = GameUtils.convertInputToInt(1, 4);
            for (int i = 0; i < inputInt; i++) {
                System.out.printf("Enter player %d name:%n", i + 1);
                Player player = new Player(GameUtils.inputString());
                contestants.add(player);
                player.setMyGame(this);
            }
            System.out.println("Please insert how many round you want to play 5-30:");
            gameRounds = GameUtils.convertInputToInt(5, 30);
            gamePlay();
        }
        if (loadGame ==2) gameLoader.loadGame();
    }

    public void gamePlay() {
        while (gameRoundsLeft <= gameRounds) {
            while (activePlayer < contestants.size() )
             {  Player playa = contestants.get(activePlayer);
                GameUtils.clearScreen();
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
            inputInt = GameUtils.convertInputToInt(1, 11);
            switch (inputInt) {
                case 1 -> store.buyFishChoice(player);
                case 2 -> store.sellFishChoice(player);
                case 3 -> store.buyFoodChoice(player);
                case 4 -> feeding.chooseFoodToFeedWith(player); //Feed fish
                case 5 -> breeding.checkForPossibleBreedingCouples(player);
                case 6 -> System.out.println("Lazy one");
                case 7 -> store.listOwnedFish(player);
                case 8 -> gameLoader.saveGame();
                case 9 -> gameLoader.loadGame();
                case 10 ->GameUtils.helpScreen();
                case 11 ->System.exit(0);
            }
        } while (inputInt > 6 || inputInt == 5 && (!player.isPlayerRoundChoice()));
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

    private void scoreListFour(int i) { //Compares scores if they have the same with 4 players
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