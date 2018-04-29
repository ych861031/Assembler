import java.util.HashMap;

public class Symbol {

    String[] instruction = {"LDA","LDB","LDX","ADD","JSUB","JEQ","STA","J","ADDR","CLEAR","COMPR","SUBR",
            "TIX","RSUB"};
    String[] value = {"00","68","04","18","48","30","0C","3C","90","B4","A0","94","2C","4C"};

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
