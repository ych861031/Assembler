

public class Loc {
    public static String[] locTest = {"1000", "1000", "1003", "1006", "1009", "100C", "100F", "1012", "1015", "1018", "101B", "101E", "1021",
            "1024", "1027", "102A", "102D", "1030", "1033", "1036", "1039", "2039", "203C", "203F", "2042", "2045", "2048",
            "204B", "204E", "2051","2054", "2057", "205A", "205D", "205E", "2061", "2064", "2067", "206A", "206D","206E"};

    public String LocaTion[] = new String[100];


    public void setLoc() {

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
//                    int j;
//                    String ascii="";
//                    for(j=0;j<BeforeAscii.length();j++){
//                        int temp = (int)BeforeAscii.charAt(j);
//                        ascii = ascii+Integer.toHexString(temp);
//                    }
//
//                    System.out.println(Decompose.Operend[i-1]);
//
//                    System.out.println(BeforeAscii+"---"+ascii);


                    String b;
                    b = a.substring(0,1);

                    if (b.equals("C")){
//                        System.out.println(a.charAt(0)+"...C");
                        int j;
                        String ascii="";
                        for(j=0;j<BeforeAscii.length();j++){
                            int temp = (int)BeforeAscii.charAt(j);
                            ascii = ascii+Integer.toHexString(temp);
                        }

                        System.out.println(Decompose.Operend[i-1]);

                        System.out.println(BeforeAscii+"---"+ascii);

                    }else if(b.equals("X")){
//                        System.out.println("XXX");
                    }
                    break;
                case "WORD":
                    break;
                case "RESB":
                    break;
                case "RESW":
                    break;
                case "END":
                    break;
                default:
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




}
