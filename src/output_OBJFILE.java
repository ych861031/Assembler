import java.io.FileWriter;
import java.io.IOException;

public class output_OBJFILE {

    public static void output()throws IOException {
        //下面這行可以拿到opcode
        //GenerateOpcode.Opcode_test;

        //去網路上找寫檔案的方法
        //ex: File ... = new file;

        //基本上就是按照規則把opcode 輸出到檔案上

        FileWriter obj=new FileWriter("obj.txt") ;



        String name = Decompose.Label[0];

        int i,j;
        obj.write("H");

        Loc.locTest[0].length();
        String a="";



        for(i=Loc.locTest[0].length();i<6;i++)
        {
            a=a+"0";
        }

       obj.write(name+"  "+a+Loc.locTest[0]);

        a="";
        for(i=Loc.locTest[Loc.locTest.length-1].length();i<6;i++)
        {
            a=a+"0";
        }

        a="";
        obj.write(a+Loc.locTest[Loc.locTest.length-1]+"\n");
        obj.write("T");
        for(i=Loc.locTest[1].length();i<6;i++)
        {
            a=a+"0";
        }
        a="";
        obj.write(a+Loc.locTest[1]);
        int b=0;
        String c=" ";
        for(i=0;i<GenerateOpcode.Opcode_test.length;i++)
        {

            b+=GenerateOpcode.Opcode_test[i].length();

            if(b<=58)
            {
                obj.write(GenerateOpcode.Opcode_test[i]); //放了58個字母進去


            }
            c+=GenerateOpcode.Opcode_test[GenerateOpcode.Opcode_test[i].length()];
            }
            obj.write("\n"+"T");
        for(i=Loc.locTest[1].length();i<6;i++)
        {
            a=a+"0";
        }
        obj.write(a+Loc.locTest[11]);
            b=0;


        for(i=0;i<GenerateOpcode.Opcode_test.length;i++)
        {

            b+=GenerateOpcode.Opcode_test[i].length();

            if(b<=38)
            {
                obj.write(GenerateOpcode.Opcode_test[i]); //放了87個字母進去

            }
        }









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







