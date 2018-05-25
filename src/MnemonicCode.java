import java.util.HashMap;

public class MnemonicCode {
    String[] instruction = {"ADD","ADDF","ADDR","AND","","","","","","","","","","","","","","","","","","","","","","","",""};

    String[] value = {"18","58","90","40","","","","","","","","","","","","","","","","","","","","","","","","","","",""};

    public HashMap<String,String> hashMap = new HashMap<>();
    public  void setHashMap(){
        for (int i=0;i<instruction.length;i++){
            this.hashMap.put(instruction[i],value[i]);
        }
    }


    public String getValue(String key){
        return hashMap.get(key);
    }
}
