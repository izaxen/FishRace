package Stayfishy;
import java.util.Scanner;

public class Game {
    private int inputInt;
    public int gameRounds;
    private String error = "You have entered invalid number, enter a new:";
    MenuSystem menuSystem = new MenuSystem();
    ControlMethods controlMethods = new ControlMethods();
    Scanner input = new Scanner(System.in);


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
                    System.out.println(player.getMoney());
                }


            } else
                System.out.println(error);


        } while (!(inputInt > 0 && inputInt < 5));

        System.out.println("Please insert how many round you want to play 5-30:");
        do {
            inputInt = controlMethods.convertInputToInt();
            if (inputInt > 4 && inputInt < 31)
                gameRounds = inputInt;

            else
                System.out.println(error);

        } while (!(inputInt > 4 && inputInt < 31));

    }
}