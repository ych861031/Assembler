import javax.swing.*;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.annotation.Annotation;

public class output_LISFILE {


    public static void  output()throws IOException {

        FileWriter fr = new FileWriter("LISFILE.txt");

        for (int i=0;i<Read.lines;i++){

            if (Decompose.Annotaion.get(i)!=null){
                fr.write(Decompose.Annotaion.get(i)+"\n");
                continue;
            }

            //opcode 格式調整
            String opcode ;
            if (!GenerateOpcode.Opcode_test[i].equals("")){
                opcode = GenerateOpcode.Opcode_test[i];
                for (int space = GenerateOpcode.Opcode_test[i].length(); space < 8 ;space++){
                    opcode += " ";
                }
            }else{
                opcode = "        ";//" "*8
            }
            String label;
            if (Decompose.Label[i]==null||Decompose.Label[i].equals("")){
                label="      ";
            }else {
                label = Decompose.Label[i];
                if (label.length()<6){
                    for (int space=label.length();space<6;space++){
                        label+=" ";
                    }
                }
            }


            String operation;
            if (Decompose.Operation[i]==null||Decompose.Operation[i].equals("")){
                operation = "      ";//" "*6
            }else{
                if ((Decompose.Operation[i].charAt(0) =='+')){
                    operation = Decompose.Operation[i];
                }else{

                    operation = " "+Decompose.Operation[i];
                }

                if (operation.length()<6){
                    for (int space = operation.length();space<6;space++){
                        operation +=" ";
                    }
                }
            }

            String operend;
            if (Decompose.Operend[i]== null||Decompose.Operend[i].equals("")){
                operend = "            ";//" "*12
            }else{
                if (Decompose.Operend[i].charAt(0)=='#'||Decompose.Operend[i].charAt(0)=='@'){
                    operend = Decompose.Operend[i];
                }else{
                    operend = " "+Decompose.Operend[i];
                }

                if (operend.length()<12){
                    for (int space = operend.length();space<12;space++){
                        operend+=" ";
                    }
                }
            }


            String comments = "";
            if (Decompose.Comments[i]!=null){
                comments = Decompose.Comments[i];
            }

            fr.write(Loc.LocaTion[i]+ " "  + opcode + " " +label+ " " + operation + " "+ operend +" "+ comments +"\n");

            illegal_test illegal = new illegal_test();

            if (illegal_test.hashMap.containsKey(i)){
                fr.write(illegal_test.hashMap.get(i)+"\n");
            }
        }
        fr.flush();
        fr.close();

    }
}
