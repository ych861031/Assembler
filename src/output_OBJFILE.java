import java.io.FileWriter;
import java.io.IOException;

public class output_OBJFILE {

    public static void output()throws IOException {
        int length = Decompose.k;

        FileWriter obj=new FileWriter("OBJFILE.txt") ;

        String name = Decompose.Label[0];//程式名稱


        obj.write("H");
        for (int i=name.length();i<6;i++){
            name=name+" ";
        }
        String start=Loc.LocaTion[0];//程式起始位置

        for(int i=start.length();i<6;i++)
        {
            start="0"+start;
        }

        String endLocation=Loc.LocaTion[length];//程式結尾
        for(int i=endLocation.length();i<6;i++)
        {
            endLocation= "0"+endLocation;
        }
        obj.write(name+start+endLocation+"\r\n");//第一行

        //T列處理
        String[] T_Line = new String[100]; //T每列的所有opcode
        String[] T_Start = new String[100];
        for (int i=0;i<100;i++){
            T_Line[i] = "";
        }
        int T_Length=0;
        for (int i=0;i<length;i++){
            if (Decompose.Operation[i].equals("RESW")||Decompose.Operation[i].equals("RESB")){
                if (!T_Line[T_Length].equals("")){
                    T_Length++;
                }
            }else{
                //如果換行,還沒紀錄objcode
                if (T_Line[T_Length].equals("")){
                    T_Start[T_Length] = GenerateOpcode.Opcode[i];
                }
                //判斷是否在每行範圍內
                if (T_Line[T_Length].length() + GenerateOpcode.Opcode[i].length()<=58){
                    T_Line[T_Length]+=GenerateOpcode.Opcode[i];
                }else{
                    T_Length++;
                    T_Line[T_Length]+=GenerateOpcode.Opcode[i];
                    T_Start[T_Length]=GenerateOpcode.Opcode[i];
                }
            }
        }
//        for (int i=0;i<T_Line.length&&!(T_Line[i].equals(""));i++){
//            System.out.println(T_Line[i]);
//        }
//        for (int i=0;i<T_Line.length&&!(T_Line[i].equals(""));i++){
//            System.out.println(T_Start[i]);
//        }

        String[] T_Line_Start_Location= new String[T_Length+1];
        for (int i=0;i<T_Start.length;i++){
            for (int j=0;j<GenerateOpcode.Opcode.length;j++){
                if (GenerateOpcode.Opcode[j].equals(T_Start[i])){
//                    System.out.println(Loc.LocaTion[j]);
                    T_Line_Start_Location[i]=Loc.LocaTion[j];
                    break;
                }
            }
        }



        //Location改為長度必定是6
        for (int i =0;i<T_Line_Start_Location.length&&T_Line_Start_Location[i]!=null;i++){
            for (int j = T_Line_Start_Location[i].length();j<6;j++){
                T_Line_Start_Location[i] = "0" + T_Line_Start_Location[i];
            }
        }

        String[] T_Line_length = new String[T_Length+1];
        //計算T列每行長度
        for (int i=0;i<T_Length+1;i++){
            T_Line_length[i] = Integer.toHexString(T_Line[i].length()/2).toUpperCase();
        }
        //objfile.txt T欄
        for (int i=0;i<T_Length+1&&T_Line_Start_Location[i]!=null;i++){
            obj.write("T"+T_Line_Start_Location[i]+T_Line_length[i]+T_Line[i]+"\r\n");
        }

        String[] M_Line = new String[100];
        int M_Length=0;
        //objfile.txt M欄 找出M欄 如+JSUB
        for (int i=0;i<Decompose.Operation.length;i++){
            try{
                if (Decompose.Operation[i].charAt(0)=='+'){
                    if (Decompose.Operend[i].charAt(0)=='#'){
                        try{
                            Integer.parseInt(Decompose.Operend[i].substring(1,Decompose.Operend[i].length()));
                            continue;
                        }catch (Exception e){
                            M_Line[M_Length++] = GenerateOpcode.Opcode[i];
                        }
                    }else{
                        M_Line[M_Length++] = GenerateOpcode.Opcode[i];
                    }
                }
            }catch (Exception e){
                continue;
            }
        }

        //找出M欄的Location
        String[] M_location = new String[M_Length];
        for (int i=0,j=0;i<M_Length;i++){
            for (;j<GenerateOpcode.Opcode.length;j++){
                if (M_Line[i].equals(GenerateOpcode.Opcode[j])){
                    M_location[i] = Loc.LocaTion[j++];
                    break;
                }
            }
        }

        //M欄+1 補0
        for (int i=0;i<M_Length;i++){
            M_location[i] = Integer.toHexString(Integer.parseInt(M_location[i],16)+1);
            for (int j=M_location[i].length();j<6;j++){
                M_location[i] = "0"+M_location[i];
            }
        }

        //M欄輸出
        for (int i=0;i<M_Length;i++){
            obj.write("M"+M_location[i]+"05"+"\r\n");
        }

        obj.write("E"+start);
        obj.flush();
        obj.close();
        }
    }







