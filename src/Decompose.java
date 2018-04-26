import java.io.FileReader;
import java.io.IOException;

public class Decompose {

    public void decompose(FileReader fileReader){
        System.out.println(fileReader.getEncoding());
        try {
            fileReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }






}
