

public class Loc {
    public static String[] locTest = {"0000", "0000", "0003","    " ,"0006", "000A", "000D","0010","0013", "1017", "001A", "001D", "0020",
            "0023", "0026", "002A", "002D", "0030", "0033", "0036","    ","    ","    ",  "1036","1038", "103A", "103C", "1040", "1043", "1046",
            "1049", "104B", "104E","1051", "1053", "1056", "1059", "105C","    ","    ","    ",  "105D", "105F", "1062", "1065", "1068","106B","106E","1070","1073","1076","    "};

    public String LocaTion[] = new String[100];


    public void setLoc() {

//        int findfault=0;
        int x;
        for(x=0;x<100;x++) {
            LocaTion[x] ="0000";
        }

        int i ;
        System.out.println(Decompose.Operation[2]);
        LocaTion[0] = Decompose.Operend[0];
        System.out.println(LocaTion[0]);
        for(i=1;i<100;i++){
            switch (Decompose.Operation[i-1]){
                case "START":
                    LocaTion[i]=Decompose.Operend[i-1];
                    System.out.println(LocaTion[i]);
                    break;
                case "BYTE":
                    String a = Decompose.Operend[i-1];

                    String BeforeAscii = a.substring(2,a.length()-1);


//                    int ascii = (int)ASCII.charAt(0);
//                    int ascii2 = (int)ASCII.charAt(1);
//                    String tmp = Integer.toString(ascii)+Integer.toString(ascii2);
//                    String tmp = Integer.toString(ascii);
//                    int temp = Integer.valueOf(tmp);
//                    tmp = Integer.toHexString(temp);
//


                    String b;
                    b = a.substring(0,1);//取第一個符號

                    //判斷b 是C還是X
                    if (b.equals("C")){
                        int j;
                        String ascii="";
                        for(j=0;j<BeforeAscii.length();j++){
                            int temp = (int)BeforeAscii.charAt(j);
                            ascii = ascii+Integer.toHexString(temp);
                        }

//                        System.out.println(Decompose.Operend[i-1]);

//                        System.out.println(BeforeAscii+"---"+ascii);
                        long tmp = Long.parseLong(LocaTion[i-1],16);
                        tmp=tmp+ascii.length()/2;
                        long last = Long.parseLong(LocaTion[i],16);
                        last = last+tmp;
                        LocaTion[i] =Long.toHexString(last);
                        LocaTion[i] =checkForFourNum(LocaTion[i]);
                        System.out.println(LocaTion[i]+"---"+ascii);
//                        findfault = 1;

                    }else if(b.equals("X")){
                        String Xcontent = a.substring(2,a.length()-1);
//                      System.out.println(Xcontent);
                        long tmp = Long.parseLong(LocaTion[i-1],16);
                        tmp=tmp+ Xcontent.length()/2;
                        long last = Long.parseLong(LocaTion[i],16);
                        last = last+tmp;
                        LocaTion[i] =Long.toHexString(last);
                        LocaTion[i]=checkForFourNum(LocaTion[i]);
                        System.out.println(LocaTion[i]+"---X");
                    }
                    break;
//                case "WORD":
//                    break;
                case "RESB":
                    long tempResb = Long.parseLong(Decompose.Operend[i-1],10);//radix轉10進位
                    long PreRowResb  = Long.parseLong(LocaTion[i-1],16);
                    long mergeResb  = tempResb + PreRowResb ;

                    LocaTion[i] = Long.toHexString(mergeResb );
                    LocaTion[i] = checkForFourNum(LocaTion[i]);
                    System.out.println(LocaTion[i]);
                    break;
                case "RESW":
                    long tempResW  = Long.parseLong(Decompose.Operend[i-1],10);//radix轉10進位
                    long PreRowResW  = Long.parseLong(LocaTion[i-1],16);
                    long merge = tempResW  *3 + PreRowResW  ;

                    LocaTion[i] = Long.toHexString(merge);
                    LocaTion[i] = checkForFourNum(LocaTion[i]);
                    System.out.println(LocaTion[i]);

                    break;
                case "END":
                    break;
                default:
                    long tmp = Long.parseLong(LocaTion[i-1],16);
                    tmp=tmp+3;
                    long last = Long.parseLong(LocaTion[i],16);
                    last = last+tmp;
                    LocaTion[i] =Long.toHexString(last);
                    LocaTion[i]=checkForFourNum(LocaTion[i]);
                    System.out.println(LocaTion[i]);
//                    if(findfault==1){
//                        System.out.println(LocaTion[i-4]+"**");
//                        findfault=0;
//                    }
                    break;
            }
            if (Decompose.Operation[i].equals("END") ){
                break;
            }
        }
//        for(i=0;i<100;i++) {

//            switch (Decompose.Operation[i]) {
//                case "START":
//                    LocaTion[i] = Decompose.Operend[i];
//                    System.out.println(LocaTion[i]);
//                    break;
//                case "RESW":
//                    long temp = Long.parseLong(LocaTion[i-1],16);
//                    long temp2 = Long.parseLong(Decompose.Operend[i],10);
//
//                    temp2 = temp+temp2*3;
//                    LocaTion[i] = Long.toHexString(temp2);
//                    System.out.println(LocaTion[i]);
//                    break;
//                case "RESB":
//
//                    long Temp = Long.parseLong(LocaTion[i-1],16);
//                    long Temp2 = Long.parseLong(Decompose.Operend[i],10);
//
//                    Temp2 = Temp+Temp2;
//                    LocaTion[i] = Long.toHexString(Temp2);
//                    System.out.println(LocaTion[i]);
//
//                    break;
//                case "END":
//                    System.out.println(Decompose.Operation[i]);
//                    break;
//                case "":
//                    break;
//                case "":
//                    break;
//                default:
//                    if(Decompose.Operation[i-1].equals("START")){
//                        LocaTion[i] = Decompose.Operend[i-1];
//                        System.out.println(LocaTion[i]);
//                    }else{
//                        long tmp = Long.parseLong(LocaTion[i-1],16);
//                        tmp=tmp+3;
//                        long last = Long.parseLong(LocaTion[i],16);
//                        last = last+tmp;
//                        LocaTion[i] =Long.toHexString(last);
//                        System.out.println(LocaTion[i]);
//
//                    }

//                    System.out.println(Decompose.Operation[i]+"*");
//                    break;
//            }
//
//            if (Decompose.Operation[i].equals("END") ){
//                break;
//            }
//
//
//        }
//
    }

    public static String checkForFourNum(String test){
        while(test.length()<4){
            test = "0"+test;

        }
        return test;
    }



}
