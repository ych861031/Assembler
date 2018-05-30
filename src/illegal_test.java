import java.util.HashMap;

public class illegal_test {
    public static HashMap<Integer,String> hashMap = new HashMap<>();


    public static void put(int i, String newString){

        if (hashMap.containsKey(i)){

            String s = hashMap.get(i);
            hashMap.put(i,s+"\n"+newString);

        }else{
            hashMap.put(i,newString);
        }
    }
}
