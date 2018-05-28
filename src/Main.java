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

        Loc loc = new Loc();
        loc.setLoc();

        Sytab sytab = new Sytab();
        sytab.set();


        GenerateOpcode generateOpcode = new GenerateOpcode();
        generateOpcode.generate();



        output_LISFILE.output();
        output_OBJFILE.output();


//        for (int i=0;i<GenerateOpcode.Opcode.length;i++){
//            System.out.println(i+":"+GenerateOpcode.Opcode[i]);
//        }

    }









}
