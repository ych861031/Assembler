import java.awt.*;
import java.util.HashMap;

public class illegal_test {
    public static HashMap<Integer,String> hashMap = new HashMap<>();



    public static void find_error(){

        //檢查是否有程式名稱
        if (Decompose.Label[0].equals("")){
            put(0,"Missing label in START statement");
        }
        for (int i =0;i<Decompose.k;i++){
            //END statement 是否有值
            if (Decompose.Operation[i].equals("END")){
                if (Decompose.Operend[i].equals(" ")||Decompose.Operend[i].equals("")||Decompose.Operend[i].equals(null)){
                    put(i,"Undefined label in END statement");
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
