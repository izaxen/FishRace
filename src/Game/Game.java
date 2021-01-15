package Game;

import Animals.Animal;

import java.util.ArrayList;
import java.util.Scanner;

public class Game {
    private int inputInt;
    private int gameRounds;
    public static int gameRoundsLeft;
    MenuSystem menuSystem = new MenuSystem();
    Store store = new Store(this);
    ControlMethods controlMethods = new ControlMethods();
    Scanner input = new Scanner(System.in);
    public ArrayList<Player> contestants = new ArrayList<>();


    public Game() {
        setupGame();
    }

    private void setupGame() {

        menuSystem.mainScreen();
        System.out.println("Welcome, now we gonna setup the game\n\n" +
                "Please insert how many players 1-4.");

        do {
            inputInt = controlMethods.convertInputToInt();
            if (inputInt > 0 && inputInt < 5) {
                for (int i = 0; i < inputInt; i++) {
                    System.out.println("Enter new players name:");
                    Player player = new Player(input.nextLine());
                    contestants.add(player);
                }

            } else
                System.out.println(ControlMethods.errorNumber);


        } while (!(inputInt > 0 && inputInt < 5));

        System.out.println("Please insert how many round you want to play 5-30:");
        do {
            inputInt = controlMethods.convertInputToInt();
            if (inputInt > 4 && inputInt < 31)
                gameRounds = inputInt;

            else
                System.out.println(ControlMethods.errorNumber);

        } while (!(inputInt > 4 && inputInt < 31));
        gamePlay();
    }

    private void gamePlay() {//TODO Fixa loop om båda dör samtidigt
        for (int i = 0; i < gameRounds; i++) {
            gameRoundsLeft = gameRoundsLeft + 1;
            for (Player player : contestants) {

                for (Animal fish : player.getOwnedFishes()) {
                    fish.decreaseHealth();
                }
                for (i = player.getOwnedFishes().size() - 1; i >= 0; i--) {
                    if (player.getOwnedFishes().get(i).getHealth() < 1) {
                        System.out.println("You just killed " + player.getOwnedFishes().get(i).getName() + " of the type " +
                                player.getOwnedFishes().get(i).getClass().getSimpleName());
                        player.getOwnedFishes().remove(i);
                    }
                }
                if((player.getOwnedFishes().size() == 0)&&(player.getMoney()==0))
                {
                    System.out.println("Player "+player.getName() +  " has no money or fish and is out of the game!\n" +
                            "Next player"); continue;}

                menuSystem.mainMenu(player);
                chooseAction(player);
            }
        }
    }

    public void chooseAction(Player player) {

        do {
            inputInt = controlMethods.convertInputToInt();

            switch (inputInt) {
                case 1: {
                    store.buyFish(player);
                    break;
                }
                case 2: {

                    store.sellFishChoice(player);

                    break;
                }
                case 3: {
                    //Buy food
                    store.buyFood(controlMethods.convertInputToInt());
                    break;
                }
                case 4: {
                    //Feed fish

                    break;
                }
                case 5: {
                    //breed fish

                }

                default: {
                    System.out.println(ControlMethods.errorNumber);
                }
            }

        } while ((inputInt < 1) || (inputInt > 6));
    }
}