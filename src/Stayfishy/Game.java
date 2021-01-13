package Stayfishy;
import java.util.ArrayList;
import java.util.Scanner;

public class Game {
    private int inputInt;
    private int gameRounds;
    public static int gameRoundsLeft;
    MenuSystem menuSystem = new MenuSystem();
    Store store = new Store();
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

    private void gamePlay() {
        for (int i = 0; i < gameRounds; i++) {

            for (Player player : contestants) {

                menuSystem.mainMenu(player);
                chooseAction(player);

                //menuSystem.foodMenu(controlMethods.convertInputToInt()); Kalla på inkommande värde
            }
        }

    }

    private void chooseAction(Player player) {
        int inputInt;
        do {
            inputInt = controlMethods.convertInputToInt();

                switch (inputInt) {
                    case 1: {
                        menuSystem.fishMenu();
                        store.buyFish(controlMethods.convertInputToInt(), player);
                        break;
                    }
                    case 2: {
                        menuSystem.foodMenu(player);
                        store.buyFood(controlMethods.convertInputToInt());
                        break;
                    }

                    case 3: {
                        //Feed Fish
                        break;
                    }

                    case 4: {
                        //Breed fish
                        System.out.println();
                        break;
                    }
                    case 5: {

                    }

                    default: {
                        System.out.println(ControlMethods.errorNumber);
                    }


                }

        } while ((inputInt < 1) || (inputInt >5));
    }

}