import java.util.HashMap;

public class Sytab {

    HashMap<String,String> hashMap = new HashMap<>();


    public void set(){
        int l=0;
        for (int i=0;i<Decompose.Label.length;i++){
            if (Decompose.Label[i]!=null){
                l++;
            }
        }

        for (int i=0;i<l;i++){
//            System.out.println(i + ":"+Decompose.Label[i]);
            hashMap.put(Decompose.Label[i],Loc.locTest[i]);
        }
    }

    public String get(String key){
        return hashMap.get(key);
    }
}
