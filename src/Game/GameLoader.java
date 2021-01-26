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

    public void saveGame() {
        do {
            System.out.println("\nEnter name on savefile:");
            String fileName = GameUtils.inputString().toLowerCase() + ".ser";
            String filePath = "StayfishySaveFiles/";
            createControlSaveFolder(filePath);
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
                if (GameUtils.convertInputToInt(1, 2) == 1) {
                    Serializer.serialize(filePath+ fileName, myGame);
                    System.out.println("Created a savefile namned " + fileName);
                    return;
                }
            }
        } while (true);
    }

    public void loadGame() {
        String[] pathNames;
        File directoryPath = new File("StayfishySaveFiles/");

        if (directoryPath.exists() && directoryPath.isDirectory()) {

            FilenameFilter filter = new FilenameFilter() {
                @Override
                public boolean accept(File f, String name) {
                    return name.endsWith(".ser");
                }
            };
            pathNames = directoryPath.list(filter);
            System.out.println("\nYour saved files\n");
            for (String pathname : pathNames)
                System.out.println(pathname.replaceAll(".ser", ""));

            System.out.println("\nChoose which save file you want to load. If no saved files available press enter");
            String loadString = "StayFishySaveFiles/" + GameUtils.inputString().toLowerCase() + ".ser";
            try {
                myGame = (Game) Serializer.deserialize(loadString);
                myGame.gamePlay();
            } catch (Exception e) {
                System.out.println("Something went wrong with the loadfile.\n" +
                        "[1] Try again to load game\n" +
                        "[2] Go back to start menu");
                if (GameUtils.convertInputToInt(1, 2) == 1)
                    loadGame();
                else
                    myGame.setupGame();
            }
            System.out.println("Game loaded correctly, press enter to continue");
            GameUtils.inputString();
        }
        System.out.println("No saved files available");
        GameUtils.waitMilliSeconds(1200);
        myGame.setupGame();
    }
    private void createControlSaveFolder(String filePath){

        File saveFolder = new File(filePath);
        if(!saveFolder.exists()){
            System.out.println("Creating saving directory "+ saveFolder.getName());
            boolean result = false;
            try{
                saveFolder.mkdirs();
                result = true;
            }
            catch (SecurityException se){
                System.out.println(se.getMessage());
            }
            if (result){
                System.out.println("Folder created");
            }
        }
    }
}
