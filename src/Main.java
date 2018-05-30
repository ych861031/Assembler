import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        Read readFile = new Read();
        try {
            readFile.read();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try{
            Decompose de = new Decompose();
            de.decompose(readFile.getLines());

            MnemonicCode mnemonicCode = new MnemonicCode();
            mnemonicCode.setHashMap();

            Loc loc = new Loc();
            loc.setLoc();

            Sytab sytab = new Sytab();
            sytab.set();


            GenerateOpcode generateOpcode = new GenerateOpcode();
            generateOpcode.generate();

            output_OBJFILE.output();
            output_LISFILE.output();

        }catch (Exception e){
            e.printStackTrace();
            FileWriter fr = new FileWriter("Error.txt");
            fr.write(e.toString());
            fr.flush();
            fr.close();
        }



    }









}
