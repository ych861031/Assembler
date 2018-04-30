import java.io.IOException;


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
        Symbol symbol = new Symbol();
        symbol.setHashMap();
//        System.out.println(symbol.getValue("LDX"));

        Loc loc = new Loc();
        loc.setLoc();
    }








}
