import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class Read {

    public FileReader fileReader;
    public String[] Lines;
    public static int lines;
    public void read() throws IOException {
        String path = "SRCFILE.txt";
        fileReader = new FileReader(path);

        lines = count();
        Lines = new String[lines];

        fileReader = new FileReader(path);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        int i = 0;
        while(bufferedReader.ready()){
            Lines[i] = bufferedReader.readLine();
            i++;
        }

        for (i=0 ;i<Lines.length;i++){
            System.out.println(Lines[i]);
        }
        fileReader.close();
        if (lines>1000){
            illegal_test.hashMap.put(lines,"***more than 1000***");
        }
    }
    public String[] getLines(){
        return this.Lines;
    }

    public int count() throws IOException {
        int i= 0;
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        while (bufferedReader.ready()){
            bufferedReader.readLine();
            i++;
        }
        fileReader.close();
        return i;
    }

}
