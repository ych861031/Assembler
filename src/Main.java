import java.io.*;
import java.lang.annotation.Annotation;


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

        GenerateOpcode generateOpcode = new GenerateOpcode();
        generateOpcode.generate();


        //
//        String test = "EOF";
//        System.out.println(Integer.toHexString((int)test.charAt(0)).toUpperCase()+Integer.toHexString((int)test.charAt(1)).toUpperCase()
//                +Integer.toHexString((int)test.charAt(2)).toUpperCase());

//        for (int i=0;i<Decompose.Operend.length;i++) {
//
//            if (!(Decompose.Annotaion.get(i)==null)){
//                System.out.println(Decompose.Annotaion.get(i));
//            }
//        }

    }








}
