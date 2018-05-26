import java.util.HashMap;

public class Sytab {

    public static HashMap<String,String> hashMap = new HashMap<>();


    public void set(){
        int l=0;
        for (int i=0;i<Decompose.Label.length;i++){
            if (Decompose.Label[i]!=null){
                l++;
            }
        }

        for (int i=0;i<l;i++){

            hashMap.put(Decompose.Label[i],Loc.locTest[i]);
        }
    }


}
