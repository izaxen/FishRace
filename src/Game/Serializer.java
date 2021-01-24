package Game;
import java.io.*;

public class Serializer implements Serializable{
    static public boolean serialize(String filePath, Object data) {

        try {

            var file = new FileOutputStream(filePath);
            var out = new ObjectOutputStream(file);
            out.writeObject(data);
            out.close();
            file.close();
            return true; // everything went fine
        }
        catch(Exception error){
            return false; // we couldn't complete the serialization
        }
    }

    static public Object deserialize(String filePath){

        try {
            var file = new FileInputStream(filePath);
            var in = new ObjectInputStream(file);
            var data = in.readObject();
            in.close();
            file.close();
            return data;
        }
        catch(Exception error){
            System.out.println(error);
            return false; // we couldn't complete deserialization
        }
    }
}
