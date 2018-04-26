import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class Read {

    public static void main(String[] args) throws IOException {

        FileReader fileReader = new FileReader("/Users/rtc10/IdeaProjects/Assembler/src/input.txt");

        BufferedReader bufferedReader = new BufferedReader(fileReader);
        while(bufferedReader.ready()){
            System.out.println(bufferedReader.readLine());
        }
        fileReader.close();
    }

}
