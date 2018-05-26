import java.security.acl.LastOwnerException;

public class Loc {
    public static String[] locTest = {"0000", "0000", "0003","    " ,"0006", "000A", "000D","0010","0013", "0017", "001A", "001D", "0020",
            "0023", "0026", "002A", "002D", "0030", "0033", "0036","    ","    ","    ",  "1036","1038", "103A", "103C", "1040", "1043", "1046",
            "1049", "104B", "104E","1051", "1053", "1056", "1059", "105C","    ","    ","    ",  "105D", "105F", "1062", "1065", "1068","106B","106E","1070","1073","1076","    "};

    public static String LocaTion[] = new String[100];


    public void setLoc() {

        boolean boolcheckPlus  = false;
        boolean boolcheckEqualSign = false;
        int x;
        for(x=0;x<100;x++) {
            LocaTion[x] ="0000";
        }

        int i ;
        LocaTion[0] = Decompose.Operend[0];
        LocaTion[0]=checkForFourNum(LocaTion[0]);
        for(i=1;i<100;i++) {
            switch (Decompose.Operation[i - 1]) {
                case "START":
                    LocaTion[i] = Decompose.Operend[i - 1];
                    LocaTion[i] = checkForFourNum(LocaTion[i]);
                    break;
                case "BYTE":
                    String a = Decompose.Operend[i - 1];

                    String BeforeAscii = a.substring(2, a.length() - 1);

                    String b;
                    b = a.substring(0, 1);//取第一個符號 C'EOF'

                    //判斷b 是C還是X
                    if (b.equals("C")) {
                        int j;
                        String ascii = "";
                        for (j = 0; j < BeforeAscii.length(); j++) {
                            int temp = (int) BeforeAscii.charAt(j);
                            ascii = ascii + Integer.toHexString(temp);
                        }

                        long tmp = Long.parseLong(LocaTion[i - 1], 16);
                        tmp = tmp + ascii.length() / 2;
                        long last = Long.parseLong(LocaTion[i], 16);
                        last = last + tmp;
                        LocaTion[i] = Long.toHexString(last);
                        LocaTion[i] = checkForFourNum(LocaTion[i]);

                    } else if (b.equals("X")) {
                        String Xcontent = a.substring(2, a.length() - 1);
                        long tmp = Long.parseLong(LocaTion[i - 1], 16);
                        tmp = tmp + Xcontent.length() / 2;
                        long last = Long.parseLong(LocaTion[i], 16);
                        last = last + tmp;
                        LocaTion[i] = Long.toHexString(last);
                        LocaTion[i] = checkForFourNum(LocaTion[i]);
                    }
                    break;
//                case "WORD":
//                    break;
                case "RESB":
                    long tempResb = Long.parseLong(Decompose.Operend[i - 1], 10);//radix轉10進位
                    long PreRowResb = Long.parseLong(LocaTion[i - 1], 16);
                    long mergeResb = tempResb + PreRowResb;

                    LocaTion[i] = Long.toHexString(mergeResb);
                    LocaTion[i] = checkForFourNum(LocaTion[i]);
                    break;
                case "RESW":
                    long tempResW = Long.parseLong(Decompose.Operend[i - 1], 10);//radix轉10進位
                    long PreRowResW = Long.parseLong(LocaTion[i - 1], 16);
                    long merge = tempResW * 3 + PreRowResW;

                    LocaTion[i] = Long.toHexString(merge);
                    LocaTion[i] = checkForFourNum(LocaTion[i]);

                    break;
                case "END":
                    break;
                case "BASE":
                    LocaTion[i] = LocaTion[i - 1];
                    LocaTion[i - 1] = LocaTion[i - 2];
                    break;

                case "":
                    LocaTion[i] = LocaTion[i - 1];
                    LocaTion[i - 1] = "    ";
                    break;
                case "CLEAR":
                    long tmpCLEAR = Long.parseLong(LocaTion[i - 1], 16);
                    tmpCLEAR = tmpCLEAR + 2;
                    long lastCLEAR = Long.parseLong(LocaTion[i], 16);
                    lastCLEAR = lastCLEAR + tmpCLEAR;
                    LocaTion[i] = Long.toHexString(lastCLEAR);
                    LocaTion[i] = checkForFourNum(LocaTion[i]);
                    break;
                case "COMPR":
                    long tmpCOMPR = Long.parseLong(LocaTion[i - 1], 16);
                    tmpCOMPR = tmpCOMPR + 2;
                    long lastCOMPR = Long.parseLong(LocaTion[i], 16);
                    lastCOMPR = lastCOMPR + tmpCOMPR;
                    LocaTion[i] = Long.toHexString(lastCOMPR);
                    LocaTion[i] = checkForFourNum(LocaTion[i]);
                    break;
                case "TIXR":
                    long tmpTIXR = Long.parseLong(LocaTion[i - 1], 16);
                    tmpTIXR = tmpTIXR + 2;
                    long lastTIXR = Long.parseLong(LocaTion[i], 16);
                    lastTIXR = lastTIXR + tmpTIXR;
                    LocaTion[i] = Long.toHexString(lastTIXR);
                    LocaTion[i] = checkForFourNum(LocaTion[i]);
                    break;
                case "EQU":
                    String tmpEQU = Decompose.Operend[i-1];
                    System.out.println(tmpEQU+"\"\"");
                    int EQUi=0;
                    for(EQUi=0;EQUi<tmpEQU.length();EQUi++){
                        char checktest;//找四則運算符號
                        checktest = tmpEQU.charAt(EQUi);
                        System.out.println(checktest+"%@#^*(");
//                        if(checktest!=null){
//
////                        }
                    }
                    break;
                case "LTORG":
                    LocaTion[i] = LocaTion[i - 1];
                    LocaTion[i - 1] = LocaTion[i - 2];
                    break;
                default:
                    boolcheckPlus = checkPlus(Decompose.Operation[i - 1]);//需要確認是不是有其他+的可能
                    boolcheckEqualSign = checkEqualSign(Decompose.Operation[i - 1]);
                    if (boolcheckPlus == true) {
                        long tmp = Long.parseLong(LocaTion[i - 1], 16);
                        tmp = tmp + 4;
                        long last = Long.parseLong(LocaTion[i], 16);
                        last = last + tmp;
                        LocaTion[i] = Long.toHexString(last);
                        LocaTion[i] = checkForFourNum(LocaTion[i]);
                        boolcheckPlus = false;
                    } else if (boolcheckEqualSign == true) {
                        String contentEx = "";
                        contentEx = Decompose.Operend[i - 1].substring(2, Decompose.Operend[i - 1].length() - 1);//取C'EOF'
                        System.out.println(contentEx+"222");


                        boolcheckEqualSign = false;
                    } else {
                        long tmp = Long.parseLong(LocaTion[i - 1], 16);
                        tmp = tmp + 3;
                        long last = Long.parseLong(LocaTion[i], 16);
                        last = last + tmp;
                        LocaTion[i] = Long.toHexString(last);
                        LocaTion[i] = checkForFourNum(LocaTion[i]);
                    }

                break;
            }
            if (Decompose.Operation[i].equals("END") ){
                break;
            }
        }
        changeUpper(LocaTion);//改成大寫
//        Final(LocaTion);

    }

    public static String checkForFourNum(String test){
        while(test.length()<4){
            test = "0"+test;

        }
        return test;
    }
    public boolean checkPlus(String plustest){
        String temporary="";
        if(plustest!="") {
            temporary = plustest.substring(0, 1);
        }
        if(temporary.equals("+")){

            return true;
        }else {
            return false;
        }
    }

    public boolean checkEqualSign(String signtest) {

        String temporary="";
//        System.out.println(signtest);
        if(signtest!="") {
            temporary = signtest.substring(0, 1);
        }
        if(temporary.equals("=")){
            return true;
        }else {
            return false;
        }

    }

    public  void Final(String Location[]){
        int i = 0;
        System.out.println("-----------------------------------");
        for(i=0;i<55;i++){
            Location[i] = Location[i].toUpperCase();//改成大寫
            System.out.println(Location[i]);
        }
    }
    public void changeUpper(String Location[]){
        int i = 0;
        for(i=0;i<100;i++){
            Location[i] = Location[i].toUpperCase();//改成大寫

        }

    }


}
