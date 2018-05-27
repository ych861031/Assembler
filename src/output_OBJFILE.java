import java.io.FileWriter;
import java.io.IOException;

public class output_OBJFILE {

    public static void output()throws IOException {
        //下面這行可以拿到opcode
        //GenerateOpcode.Opcode_test;

        //去網路上找寫檔案的方法
        //ex: File ... = new file;

        //基本上就是按照規則把opcode 輸出到檔案上
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
        obj.write(name+start+endLocation+"\n");//第一行

        //T列處理
        String[] T_Line = new String[100];
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
                if (T_Line[T_Length].length() + GenerateOpcode.Opcode_test[i].length()<=58){
                    T_Line[T_Length]+=GenerateOpcode.Opcode_test[i];
                }else{
                    T_Length++;
                    T_Line[T_Length]+=GenerateOpcode.Opcode_test[i];
                }
            }
        }
        for (int i=0;i<T_Line.length&&!(T_Line[i].equals(""));i++){
            System.out.println(T_Line[i]);
        }
//        a="";
//        obj.write(a+Loc.locTest[Loc.locTest.length-1]+"\n");
//        obj.write("T");
//        for(i=Loc.locTest[1].length();i<6;i++)
//        {
//            a=a+"0";
//        }
//        a="";
//        obj.write(a+Loc.locTest[1]);
//        int b=0;
//        String c=" ";
//        for(i=0;i<GenerateOpcode.Opcode_test.length;i++)
//        {
//
//            b+=GenerateOpcode.Opcode_test[i].length();
//
//            if(b<=58)
//            {
//                obj.write(GenerateOpcode.Opcode_test[i]); //放了58個字母進去
//
//
//            }
//            c+=GenerateOpcode.Opcode_test[GenerateOpcode.Opcode_test[i].length()];
//            }
//            obj.write("\n"+"T");
//        for(i=Loc.locTest[1].length();i<6;i++)
//        {
//            a=a+"0";
//        }
//        obj.write(a+Loc.locTest[11]);
//            b=0;
//
//
//        for(i=0;i<GenerateOpcode.Opcode_test.length;i++)
//        {
//
//            b+=GenerateOpcode.Opcode_test[i].length();
//
//            if(b<=38)
//            {
//                obj.write(GenerateOpcode.Opcode_test[i]); //放了87個字母進去
//
//            }
//        }









//        if(Loc.locTest[Loc.locTest.length-52].length()<=6)
//        {
//            obj.write(name+"  00"+Loc.locTest[Loc.locTest.length-52]);
//        }
//        else
//        {
//            obj.write(name+"  "+Loc.locTest[Loc.locTest.length-52]);
//        }
//
//        if(Loc.locTest[Loc.locTest.length-1].length()<=6)
//            obj.write("00"+Loc.locTest[Loc.locTest.length-1]);
//        else
//            obj.write(Loc.locTest[Loc.locTest.length-1]+"\n");


      //  for(j=0;j<Loc.locTest.length-1;j++)
       // {


            //if(Loc.locTest[j].length()<=6)
         //   {
          //      obj.write("00"+Loc.locTest[j]);

        //    }

        obj.write("E"+start);
        obj.flush();
        obj.close();
        }



//
//
//
//
//
//        }



    }







