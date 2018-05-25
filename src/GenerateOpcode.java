

public class GenerateOpcode {

    public static String[] Opcode_test = {
            "", "17202D", "69202D", "", "4B101036",
            "032026", "290000", "332007", "4B10105D", "3F2FEC",
            "032010", "0F2016", "010003", "0F200D", "4B10105D",
            "3E2003", "454F46", "", "", "", "", "", "",
            "B410", "B400", "B440", "75101000", "E32019", "332FFA", "DB2013", "A004", "332008", "57C003", "B850", "3B2FEA",
            "134000", "4F0000", "F1", "", "", "", "B410", "774000", "E32011", "332FFA", "53C003", "DF2008", "B850", "3B2FEF", "4F0000", "05", ""
    };

    public void generate() {

        for (int i=0;i<Decompose.Operation.length;i++){
            Disp("1000","1006");
        }

        System.out.println("!!!" + Disp("001A", "0006") + bits_operation("003","A0",2,"A,S"));

        System.out.println("!!!" + Disp("001A", "0006") + bits_operation("003","48",2,"A,S"));


    }


    //位移
    public String Disp(String hex1, String hex2) {
        int sum1 = Integer.parseInt(hex1, 16);
        int sum2 = Integer.parseInt(hex2, 16);
        int sum = sum2 - sum1;
        Integer.toHexString(sum).toUpperCase();


        //Integer.valueOf("FFFF",16).toString()

        if (sum < 0) {

            //String sumString = String.valueOf(sum);

            return Integer.toHexString(sum).toUpperCase().substring(5, 8);

        }

        return Integer.toHexString(sum).toUpperCase();

    }

    //格式操作
    public String bits_operation(String disp,String opcode,int format,String operend) {

        int bin;
        System.out.println(bin=Integer.parseInt(disp,16));

        String bin_string =  Integer.toBinaryString(bin);

        int strLen=disp.length()*4;
        for (int i =bin_string.length();i<strLen;i++){
            bin_string ="0"+bin_string;
        }
        System.out.println(bin_string);
//        if (strLen <strLength) {
//            while (strLen< strLength){
//                String.format("%12");
//            }
//        }

        switch(format){
            case 1:
                opcode=opcode;
                break;
            case 2:

                String b[] =operend.split(",") ;

                String c[] = new String[2];
                for(int i=0;i<b.length;i++)
                {
                    if(b[i].equals("A")){
                        c[i]="0";
                    }if(b[i].equals("X")){
                        c[i]="1";
                    }if(b[i].equals("L")){
                        c[i]="2";
                    }if(b[i].equals("B")){
                        c[i]="3";
                    }if(b[i].equals("S")){
                        c[i]="4";
                    }if(b[i].equals("T")){
                        c[i]="5";
                    }if(b[i].equals("F")){
                        c[i]="6";
                    }if(b[i].equals("PC")){
                        c[i]="8";
                    }if(b[i].equals("SW")){
                        c[i]="9";
                    }

                }
                if (c[1]==null){
                    c[1] = "0";
                }
                opcode=opcode+c[0]+c[1];
                break;
            case 3:
                //if(str.startsWith("as"))
                String d[] ={"1","1","0","0","1","0"};
                if(operend.charAt(0)=='@'){
                    d[0]="1";
                    d[1]="0";
                }if(operend.charAt(0)=='#'){
                    d[0]="0";
                    d[1]="1";
                }
            case 4:
                String d[] ={"1","1","0","0","1","1"};
        }


        return opcode;
    }


    }





