package Game;

import java.io.File;
import java.io.FilenameFilter;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Paths;

public class GameLoader implements Serializable {

   private Game myGame;

    public GameLoader (Game myGame){
        this.myGame = myGame;
    }

    public void saveGame(Game GameLoader) {
        do {
            System.out.println("Enter name on savefile:");
            String fileName = ControlMethods.inputString() + ".ser";
            String filePath = "c:/testsave/";
            if (!Files.exists(Paths.get(fileName))) {
                boolean saveStatus = Serializer.serialize(filePath+ fileName, myGame);
                if (saveStatus) {
                    System.out.println("Created a savefile namned " + fileName);
                return;}
                else System.out.println("Error has occured during save");
            } else {
                System.out.println("Filename already exist.");
                System.out.println("[1] Overwrite existing savefile\n" +
                        "[2] Create a new one");
                if (ControlMethods.convertInputToInt(1, 2) == 1) {
                    Serializer.serialize(filePath+ fileName, myGame);
                    System.out.println("Created a savefile namned " + fileName);
                    return;
                }
            }
        } while (true);
    }

    void loadGame(){
        String[] pathnames;
        File f = new File("C:/testsave");

        FilenameFilter filter = new FilenameFilter() {
            @Override
            public boolean accept(File f, String name) {
                return name.endsWith(".ser");
            }
        };

        pathnames = f.list(filter);

        for (String pathname : pathnames)

            System.out.println(pathname);

        myGame = (Game) Serializer.deserialize("test.ser");
        myGame.gamePlay();




    }
}
