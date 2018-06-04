import java.awt.*;
import java.util.HashMap;

public class illegal_test {
    public static HashMap<Integer,String> hashMap = new HashMap<>();



    public static void find_error(){

        //檢查是否有程式名稱
        if (Decompose.Label[0].equals("")){
            put(0,"Missing label in START statement");
        }
        if (Decompose.Operend[0].equals("")){
            put(0,"Missing operand in START statement");
        }

        for (int i =0;i<Decompose.k;i++){
            //END statement 是否有值
            if (Decompose.Operation[i].equals("END")){
                if (Decompose.Operend[i].equals(" ")||Decompose.Operend[i].equals("")||Decompose.Operend[i]==null){
                    put(i,"Undefined label in END statement");
                }
            }
            if (Decompose.Operation[i].equals("WORD")){
                if (Decompose.Operend[i].equals(" ")||Decompose.Operend[i].equals("")||Decompose.Operend[i]==null){
                    put(i,"Missing operand in WORD statement");
                }
            }

            if (Decompose.Operation[i].equals("RESB")){
                if (Decompose.Operend[i].equals(" ")||Decompose.Operend[i].equals("")||Decompose.Operend[i]==null){
                    put(i,"Missing operand in RESB statement");
                }
            }
            if (Decompose.Operation[i].equals("RESW")){
                if (Decompose.Operend[i].equals(" ")||Decompose.Operend[i].equals("")||Decompose.Operend[i]==null){
                    put(i,"Missing operand in RESW statement");
                }
            }
            if (Decompose.Operation[i].equals("BASE")){
                if (Decompose.Operend[i].equals(" ")||Decompose.Operend[i].equals("")||Decompose.Operend[i]==null){
                    put(i,"Missing operand in BASE statement");
                }
            }

            if (Decompose.Operation[i].equals("EQU")){
                if (Decompose.Label[i].equals(" ")||Decompose.Label[i].equals("")||Decompose.Label[i]==null){
                    put(i,"Missing label in EQU statement");
                }
            }
            if (Decompose.Operation[i].equals("EQU")){
                if (Decompose.Operend[i].equals(" ")||Decompose.Operend[i].equals("")||Decompose.Operend[i]==null){
                    put(i,"Missing operand in EQU statement");
                }
            }
            if (Decompose.Operation[i].equals("BYTE")){
                if (Decompose.Operend[i].equals(" ")||Decompose.Operend[i].equals("")||Decompose.Operend[i]==null){
                    put(i,"Missing operand in BYTE statement");
                }
            }
            if (i!=0){
                if (Decompose.Operation[i].equals("START")){
                    put(i,"Duplicate START statement");
                }
            }
            if (Decompose.Operation[0].equals("START")){
                if (i!=0&&Decompose.Operation[i].equals("START")){
                    put(i,"Misplaced START statement");
                }
            }

        }
    }


    public static void put(int i, String newString){

        if (hashMap.containsKey(i)){

            String s = hashMap.get(i);
            hashMap.put(i,s+"\n"+newString);

        }else{
            hashMap.put(i,newString);
        }
    }
}
