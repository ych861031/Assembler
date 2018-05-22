import java.io.FileWriter;
import java.io.IOException;
import java.lang.annotation.Annotation;

public class output_LISFILE {

    public static void  output()throws IOException {
        //可以拿到location
        //Loc.locTest;

        //可以拿到Ｌabel
        //Decompose.Label;
        //operation operend comments 也是用同樣的方法

        //要輸出LISFILE
        //上網找檔案輸出方法
        //ex:Ｆile ... = new file;
        //檔案輸出的形式可以看看assembler exercise 的LISFILE
        //先把這個檔案的ＳＲＣＦＩＬＥ.txt的檔案內容複製到ＳＲＣＦＩＬＥ裡 執行sicasm.exe 就可以開ＬＩＳＦＩＬＥ看結果

        int l=0;
        for (int i =0;i<Decompose.Operation.length;i++){
            if (Decompose.Operation[i]!=null){
                l++;
            }
        }


        FileWriter fr = new FileWriter("LISFILE.txt");

        for (int i=0;i<l;i++){

            if (Decompose.Annotaion.get(i)!=null){
                fr.write(Decompose.Annotaion.get(i)+"\n");
                continue;
            }



            //opcode 格式調整
            String opcode ;
            if (!GenerateOpcode.Opcode_test[i].equals("")){
                opcode = GenerateOpcode.Opcode_test[i];
                for (int space = GenerateOpcode.Opcode_test[i].length(); space <= 8 ;space++){
                    opcode += " ";
                }
            }else{
                opcode = "         ";//" "*8
            }

            String operation = "";
            if (Decompose.Operation[i]==null){
                operation = "      ";//" "*8
            }else{
                operation = Decompose.Operation[i];
                if (Decompose.Operation[i].length()<6){
                    for (int space = Decompose.Operation[i].length();space<=6;space++){
                        operation+=" ";
                    }
                }
            }








            fr.write(Loc.locTest[i]+"   "  + opcode + "   " + operation +"\n");
        }
        fr.flush();
        fr.close();
    }
}
