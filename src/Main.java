import java.io.*;


public class Main {

    public static void main(String[] args) throws IOException {
        Read readFile = new Read();
        try {
            readFile.read();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Decompose de = new Decompose();
        de.decompose(readFile.getLines());

        MnemonicCode mnemonicCode = new MnemonicCode();
        mnemonicCode.setHashMap();

//        System.out.println(symbol.getValue("LDX"));

//        Loc loc = new Loc();
//        loc.setLoc();

        GenerateOpcode generateOpcode = new GenerateOpcode();
        generateOpcode.generate();

    }








}
