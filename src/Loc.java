

public class Loc {
    public String[] locTest = {"1000", "1000", "1003", "1006", "1009", "100C", "100F", "1012", "1015", "1018", "101B", "101E", "1021",
            "1024", "1027", "102A", "102D", "1030", "1033", "1036", "1039", "2039", "203C", "203F", "2042", "2045", "2048",
            "204B", "204E", "2051","2054", "2057", "205A", "205D", "205E", "2061", "2064", "2067", "206A", "206D","206E"};

    public String LocaTion[] = new String[100];


    public void setLoc() {

//        int i = 200;
        int x;
        for(x=0;x<100;x++) {
            LocaTion[x] ="0000";
        }
//        String test1 = Integer.toOctalString(i);
//        String test2 = Integer.toHexString(i);
//        String test3 = Integer.toBinaryString(i);
//
//        System.out.println(test1);
//        System.out.println(test2);
//        System.out.println(test3);

//        long x = Long.parseLong(locTest[0],16); //(radix)進位 轉 十進位
//        System.out.println(x);
//        System.out.println(Decompose.Label[0]);
//        System.out.println(Decompose.Operation[0]);
//        System.out.println(Decompose.Operend[0]);
        int i ;
        for(i=0;i<100;i++) {
            switch (Decompose.Operation[i]) {
                case "START":
                    LocaTion[i] = Decompose.Operend[i];
                    System.out.println(LocaTion[i]);
                    break;
                case "RESW":
                    System.out.println(Decompose.Operation[i]);
                    break;
                case "RESB":
                    System.out.println(Decompose.Operation[i]);
                    break;
                case "END":
                    System.out.println(Decompose.Operation[i]);
                    break;
//                case "":
//                    break;
//                case "":
//                    break;
                default:
                    if(Decompose.Operation[i-1].equals("START")){
                        LocaTion[i] = Decompose.Operend[i-1];
                        System.out.println(LocaTion[i]);
                    }else{
                        long tmp = Long.parseLong(LocaTion[i-1],16);
                        tmp=tmp+3;
                        LocaTion[i] =Long.toHexString(tmp);
                        System.out.println(LocaTion[i]);

                    }
//                    System.out.println(Decompose.Operation[i]+"*");
                    break;
            }

            if (Decompose.Operation[i].equals("END") ){
                break;
            }


        }

    }




}
