package Game;

import Animals.Animal;
import java.util.ArrayList;
import java.util.Comparator;

public class Game {
    private int inputInt;
    private int gameRounds;
    public static int gameRoundsLeft;

    private ArrayList<Player> contestants = new ArrayList<>();

    Store store = new Store(this);
    MenuSystem menuSystem = new MenuSystem(this);
    Breeding breeding = new Breeding(this);


    public Game() {
        setupGame();
    }

    private void setupGame() {

        menuSystem.mainScreen();
        System.out.println("Welcome, now we gonna setup the game\n\n" +
                "Please insert how many players 1-4.");

        do {
            inputInt = ControlMethods.convertInputToInt();
            if (inputInt > 0 && inputInt < 5) {
                for (int i = 0; i < inputInt; i++) {
                    System.out.printf("Enter player %d name:%n", i + 1);
                    Player player = new Player(ControlMethods.inputString());
                    contestants.add(player);
                    player.setMyGame(this);
                }

            } else
                System.out.println(ControlMethods.errorNumber);


        } while (!(inputInt > 0 && inputInt < 5));

        System.out.println("Please insert how many round you want to play 5-30:");
        do {
            inputInt = ControlMethods.convertInputToInt();
            if (inputInt > 4 && inputInt < 31)
                gameRounds = 2; //TODO inputInt;

            else
                System.out.println(ControlMethods.errorNumber);

        } while (!(inputInt > 4 && inputInt < 31));
        gamePlay();
    }

    private void gamePlay() {
        for (int i = 0; i < gameRounds; i++) {
            gameRoundsLeft = gameRoundsLeft + 1;
            for (Player player : contestants) {

                if (player.isPlayerActive()) {//TODO Put in roundactive:False
                    for (Animal fish : player.getOwnedFishes()) {
                        fish.decreaseHealthAndAge();
                    }
                    player.deathLoop();
                }

                if (player.isPlayerActive()) {

                    chooseActionMainMenu(player);
                } else
                    System.out.println(player.getName() + " is out of the game\n" +
                            "Next player");
            }
        }
        store.sellAllFishEndGame();
        endGameScoreList();
    }

    public void chooseActionMainMenu(Player player) {

        do {
            menuSystem.mainMenu(player);
            inputInt = ControlMethods.convertInputToInt();

            switch (inputInt) {
                case 1: {
                    // Buy fish
                    store.buyFish(player);
                    break;
                }
                case 2: {
                    //Sell fish
                    store.sellFishChoice(player);

                    break;
                }
                case 3: {
                    //Buy food
                    store.buyFood(player);
                    break;
                }
                case 4: {
                    //Feed fish
                    player.feedYourFish();

                    break;
                }
                case 5: {
                    //breed fish
                    breeding.checkForPossibleBreedingCouples(player);
                }

                default: {
                    System.out.println(ControlMethods.errorNumber);
                }
            }

        } while ((inputInt < 1) || (inputInt > 6));
    }

    public void endGameScoreList() {
        contestants.sort(Comparator.comparing(Player::getMoney).reversed());
        System.out.println("Result of the game");
        for (int i = 0; i < contestants.size(); i++) {
            if (i != 0) {
                if (i > 2) {
                    if ((contestants.get(i).getMoney() == contestants.get(i - 3).getMoney()) && (i > 2)) {
                        System.out.println((i - 2) + " place: " + contestants.get(i).getName() + " with " + contestants.get(i).getMoney());
                    }
                } else if (i > 1) {
                    if ((contestants.get(i).getMoney() == contestants.get(i - 2).getMoney())) {
                        System.out.println((i - 1) + " place: " + contestants.get(i).getName() + " with " + contestants.get(i).getMoney());
                    }
                }
                else if (contestants.get(i).getMoney() == contestants.get(i - 1).getMoney()) {
                    System.out.println((i) + " place: " + contestants.get(i).getName() + " with " + contestants.get(i).getMoney());
                }
            } else
                System.out.println((i + 1) + " place: " + contestants.get(i).getName() + " with " + contestants.get(i).getMoney());
        }
    }

    public ArrayList<Player> getContestants() {
        return contestants;
    }
}