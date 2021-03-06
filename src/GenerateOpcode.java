public class GenerateOpcode {


    public static String[] Opcode = new String[Decompose.k+1];
    public String base = "";
    public String pc;


    public void generate() {


        for (int i=0;Decompose.Label[i]!=null;i++){
            System.out.println(Decompose.Operation[i]);
            pc = Loc.LocaTion[i+1];
//            System.out.println(i+":"+MnemonicCode.hashMap.get(Decompose.Operation[i]));
            if (Decompose.Operation[i].equals("LTORG")){
                Opcode[i]= "";
                continue;
            }
            if (Decompose.Operation[i].equals("EQU")){
                Opcode[i] = "";
                continue;
            }


            if (Decompose.Operation[i].length() > 0){
                if (Decompose.Operation[i].charAt(0)=='='){
                    String str = Decompose.Operation[i].substring(3,Decompose.Operation[i].length()-1);
                    Opcode[i] = "";
                    if (Decompose.Operation[i].charAt(1)=='X'){
                        Opcode[i] = str;
                    }else{
                        for (int s = 0;s<str.length();s++){
                            Opcode[i] += Integer.toHexString((int)str.charAt(s)).toUpperCase();
                        }
                    }
                    continue;
                }
                if (Decompose.Operation[i].equals("BASE")||Decompose.Operation[i].equals("START")||
                        Decompose.Operation[i].equals("RESW")||Decompose.Operation[i].equals("RESB")||
                        Decompose.Operation[i].equals("END")){

                    if (Decompose.Operation[i].equals("BASE")){
                        if (Decompose.Operend[i].charAt(0)=='#'||Decompose.Operend[i].charAt(0)=='@'){

                            base=Sytab.hashMap.get(Decompose.Operend[i].substring(1,Decompose.Operend[i].length()));

                            Opcode[i] = "";
                            continue;
                        }
                        base=Sytab.hashMap.get(Decompose.Operend[i]);

                    }
                    Opcode[i] = "";
                    continue;
                }
                if (Decompose.Operation[i].equals("BYTE")){
                    if (Decompose.Operend[i].charAt(0)=='C'){
                        String split = Decompose.Operend[i].substring(2,Decompose.Operend[i].length()-1);
                        Opcode[i] = "";
                        for (int j=0;j<split.length();j++){
//                           System.out.println(Integer.toHexString((int)split.charAt(j)).toUpperCase());
                           Opcode[i] += Integer.toHexString((int)split.charAt(j)).toUpperCase();
                        }
                        continue;
                    }else {
                        String split = Decompose.Operend[i].substring(2,Decompose.Operend[i].length()-1);
                        Opcode[i] = split;
                        continue;
                    }
                }
                if (Decompose.Operation[i].equals("RSUB")){
                    Opcode[i] = "4F0000";
                    continue;
                }
                //format 4
                if (Decompose.Operation[i].charAt(0) == '+'){
                    if (Decompose.Operend[i].charAt(0)=='#'||Decompose.Operend[i].charAt(0)=='@'){
                        String loc_spilit=Decompose.Operend[i].substring(1,Decompose.Operend[i].length());
                        try{
                            Integer.parseInt(loc_spilit);//如果不是數字 去找SYTAB;如果是數字 直接計算
                            Opcode[i] = bits_operation(Integer.toHexString(Integer.parseInt(loc_spilit)),
                                    MnemonicCode.hashMap.get(Decompose.Operation[i].substring(1,Decompose.Operation[i].length())),
                                    4,
                                    Decompose.Operend[i]);
                            continue;
                        }catch (Exception e){
                            Opcode[i] = bits_operation(Sytab.hashMap.get(loc_spilit),
                                MnemonicCode.hashMap.get(Decompose.Operation[i].substring(1,Decompose.Operation[i].length())),
                                4,
                                Decompose.Operend[i]);
                            continue;
                        }
                    }else{
                        if (Decompose.Operend[i].charAt(0)=='='){
                            for (int z=0;z<Decompose.k;z++) {
                                if (Decompose.Operend[i].equals(Decompose.Operation[z])) {

                                    Opcode[i] = bits_operation(Loc.LocaTion[z],
                                            MnemonicCode.hashMap.get(Decompose.Operation[i].substring(1,Decompose.Operation[i].length())),
                                            4,Decompose.Operend[i]);
                                    break;
                                }
                            }
                            continue;
                        }
                        Opcode[i] = bits_operation(Sytab.hashMap.get(Decompose.Operend[i]),
                                MnemonicCode.hashMap.get(Decompose.Operation[i].substring(1,Decompose.Operation[i].length())),
                                4,
                                Decompose.Operend[i]);
                        continue;
                    }
                }
                //format 2
                if (Decompose.Operation[i].equals("ADDR")||Decompose.Operation[i].equals("CLEAR")
                        ||Decompose.Operation[i].equals("COMPR")||Decompose.Operation[i].equals("MULR")
                        ||Decompose.Operation[i].equals("RMO")||Decompose.Operation[i].equals("SHIFTL")
                        ||Decompose.Operation[i].equals("SHIFTR")||Decompose.Operation[i].equals("SUBR")
                        ||Decompose.Operation[i].equals("SVC")||Decompose.Operation[i].equals("TIXR")){
                    Opcode[i] = bits_operation("",MnemonicCode.hashMap.get(Decompose.Operation[i]),2,Decompose.Operend[i]);
                    continue;
                }
                //format 1
                if (Decompose.Operation[i].equals("DIV")||Decompose.Operation[i].equals("DIVF")||
                        Decompose.Operation[i].equals("DIVR")||Decompose.Operation[i].equals("NORM")||
                        Decompose.Operation[i].equals("SIO")||Decompose.Operation[i].equals("TIO")){
                    Opcode[i] = MnemonicCode.hashMap.get(Decompose.Operation[i]);
                    continue;
                }
                //format 3

                String location_now = Loc.LocaTion[i];
                String location_next;
                for (int j =i;;j++){
                    if (Loc.LocaTion[j+1].equals("")||Loc.LocaTion[j+1].equals("    ")){
                        continue;
                    }
                    if (Loc.LocaTion[j+1].equals(location_now)){
                        continue;
                    }
                        location_next = Loc.LocaTion[j+1];
                    break;
                }
                String target = "";
                if (Decompose.Operend[i].charAt(0)=='@'||Decompose.Operend[i].charAt(0)=='#'){
                    target = Sytab.hashMap.get(Decompose.Operend[i].substring(1,Decompose.Operend[i].length()));
                    if (target==null){
                        try {
                            Integer.parseInt(Decompose.Operend[i].substring(1,Decompose.Operend[i].length()));
                            String a = Decompose.Operend[i].substring(1,Decompose.Operend[i].length());
                            for (int j=a.length();j<4;j++){
                                a="0"+a;
                            }
                            String opcode = Integer.toHexString(Integer.parseInt(MnemonicCode.hashMap.get(Decompose.Operation[i]),16)+1);
                            if (opcode.length()<2){
                                opcode = "0"+opcode;
                            }
                            Opcode[i] = opcode+a;
                        }catch (Exception e){
                            illegal_test.hashMap.put(i,"Operend not found");

                        }
                        continue;
                    }
//                    System.out.println(i+":"+MnemonicCode.hashMap.get(Decompose.Operation[i]));
                    Opcode[i] = bits_operation(Disp(location_next,target),MnemonicCode.hashMap.get(Decompose.Operation[i]),3,Decompose.Operend[i]);
                    continue;
                }else {
                    if (Decompose.Operend[i].charAt(0)=='='){
                        try{
                            Opcode[i] = "";
                            for (int z=0;z<Decompose.k;z++){
                                if (Decompose.Operend[i].equals(Decompose.Operation[z])){
                                    Opcode[i] = bits_operation(Disp(location_next,Loc.LocaTion[z]),MnemonicCode.hashMap.get(Decompose.Operation[i]),3,Decompose.Operend[i]);
                                    break;
                                }
                            }
                            continue;
                        }catch (Exception e){
                            e.printStackTrace();
                        }
                    }


                    if(Sytab.hashMap.get(Decompose.Operend[i])!=null){
                        target = Sytab.hashMap.get(Decompose.Operend[i]);
//                        System.out.println(i+":"+MnemonicCode.hashMap.get(Decompose.Operation[i]));
                        Opcode[i] = bits_operation(Disp(location_next,target),MnemonicCode.hashMap.get(Decompose.Operation[i]),3,Decompose.Operend[i]);
                        continue;
                    }else{
                        if (Decompose.Operend[i].contains(",")){
                            String[] split =Decompose.Operend[i].split(",");
                            System.out.println(split[0]);
                            target = Sytab.hashMap.get(split[0]);
                            Opcode[i] = bits_operation(Disp(location_next,target),MnemonicCode.hashMap.get(Decompose.Operation[i]),3,Decompose.Operend[i]);
                            continue;
                        }
                        Opcode[i] = "";
//                        illegal_test.hashMap.put(i,"Operend not found");
                        continue;
                    }
                }
            }

            //
            if (MnemonicCode.hashMap.get(Decompose.Operation[i])==null){
                Opcode[i] = "";
            }
        }
    }

    boolean boom=false;
    //位移
    public String Disp(String hex1, String hex2) {
        int sum1 = Integer.parseInt(hex1, 16);
        int sum2 = Integer.parseInt(hex2, 16);
        int sum = sum2 - sum1;

        if(sum>2047||sum<-2048){
            boom=true;
        }
        else{boom=false;}
        Integer.toHexString(sum).toUpperCase();
        //Integer.valueOf("FFFF",16).toString()

        if (sum < 0) {

            //String sumString = String.valueOf(sum);

            return Integer.toHexString(sum).toUpperCase().substring(5,8);

        }

        return Integer.toHexString(sum).toUpperCase();


    }

    //格式操作
    public String bits_operation(String disp,String opcode,int format,String operend) {
//        System.out.println(disp+" "+opcode+" "+operend);

        switch(format){
            case 2:
                System.out.println("format 2");
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
                int opcode_1_1=Integer.parseInt(opcode,16);
                String opcode_2_1=Integer.toBinaryString(opcode_1_1);
                String object_code_2= opcode_2_1;

                String final_2 =Integer.toHexString(Integer.parseInt(object_code_2,2));
                for(int i=final_2.length();i<4;i++){
                    final_2="0"+final_2;
                }
                System.out.println(final_2.toUpperCase());
                return final_2.toUpperCase();
            case 3:
                System.out.println("format 3");

                String[] d = {"1","1","0","0","1","0"};
                if(operend.charAt(0)=='@'){
                    d[0]="1";
                    d[1]="0";
                }
                if(operend.charAt(0)=='#'){
                    d[0]="0";
                    d[1]="1";
                }
                String x[] =operend.split(",");
                if(x.length>=2) {
                    if (x[1].equals("X")) {
                        d[2] = "1";
                    }
                }
                if(boom){//==true
                    d[3]="1";
                    d[4]="0";

                    if (base.equals("")){
                        return "";
                    }
                    int baseToDec;
                    try{
                        baseToDec=Integer.parseInt(base,16);
                    }catch (Exception e){
                        return "";
                    }

                    if (operend.charAt(0)!='#'||operend.charAt(0)!='@'){
                        int location = Integer.parseInt(Sytab.hashMap.get(x[0]),16);
                        disp = Integer.toHexString(location-baseToDec);
                    }else{
                        int location = Integer.parseInt(Sytab.hashMap.get(operend.substring(1,operend.length())),16);
                        disp = Integer.toHexString(location-baseToDec);
                    }
                }

                    int j;
                    for(j=0;j<Decompose.Operation.length;j++){
                        if(Decompose.Operend[j].equals(operend)){
                            break;
                        }
                }

                String set_3=d[0]+d[1]+d[2]+d[3]+d[4]+d[5];
                int opcode_1_2=Integer.parseInt(opcode,16);

                String opcode_2_2=Integer.toBinaryString(opcode_1_2);
                int strLen_2=opcode.length()*4;
                for (int i =opcode_2_2.length();i<strLen_2;i++){
                    opcode_2_2 ="0"+opcode_2_2;
                }
                //System.out.println(opcode_2_2);
                String object_code_3= opcode_2_2.substring(0,6)+set_3;

                //int bin_1;
                //bin_1=Integer.parseInt(disp,16);


                String bin_string_1 =  disp;

                //  int strLen=disp.length()*4;
                for (int i =bin_string_1.length();i<3;i++){
                    bin_string_1 ="0"+bin_string_1;
                }
                String final_3 =Integer.toHexString(Integer.parseInt(object_code_3,2))+bin_string_1;
                for(int i=final_3.length();i<6;i++){
                    final_3="0"+final_3;
                }

                System.out.println(final_3.toUpperCase());
                return final_3.toUpperCase();

            case 4:
                System.out.println("format 4");
                String[] e = {"1","1","0","0","0","1"};
                if(operend.charAt(0)=='@'){
                    e[0]="1";
                    e[1]="0";
                }if(operend.charAt(0)=='#'){
                e[0]="0";
                e[1]="1";
                }if(operend.contains("X")){
                    e[2]="1";
                }
                int k;
                for(k=0;k<Decompose.Operation.length;k++){
                    if(Decompose.Operend[k].equals(operend)){
                        break;
                    }
                }
                if(Decompose.Operation[k+1].equals("BASE")){
                    e[3]="1";
                    e[4]="0";
                }
                String set_4=e[0]+e[1]+e[2]+e[3]+e[4]+e[5];
                int opcode_1_3=Integer.parseInt(opcode,16);
                String opcode_2_3=Integer.toBinaryString(opcode_1_3);

                int strLen_3=opcode.length()*4;
                for (int i =opcode_2_3.length();i<strLen_3;i++){
                    opcode_2_3 ="0"+opcode_2_3;
                }
                String object_code_4= opcode_2_3.substring(0,6)+set_4;


                int bin_2;
                bin_2=Integer.parseInt(disp,16);


                String bin_string_2 =  disp;

                //  int strLen=disp.length()*4;
                for (int i =bin_string_2.length();i<5;i++){
                    bin_string_2 ="0"+bin_string_2;
                }
                String final_4 =Integer.toHexString(Integer.parseInt(object_code_4,2))+bin_string_2;
                for(int i=final_4.length();i<8;i++){
                    final_4="0"+final_4;
                }
                System.out.println(final_4.toUpperCase());
                return final_4.toUpperCase();
        }




        return "";
    }
    }





