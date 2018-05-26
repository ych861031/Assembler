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

        Loc loc = new Loc();
        loc.setLoc();

        Sytab sytab = new Sytab();
        sytab.set();

        //test sytab
//        System.out.println(sytab.get("RDREC"));


        GenerateOpcode generateOpcode = new GenerateOpcode();
        generateOpcode.generate();
        illegal_test.hashMap.put(0,"****illegal test****");


        output_LISFILE.output();
        output_OBJFILE.output();
//        String split = "EOF";
//        for (int j=0;j<split.length();j++){
//            System.out.print(Integer.toHexString((int)split.charAt(j)).toUpperCase());
//        }
//        System.out.println(Decompose.Operation.length);



    }








}
