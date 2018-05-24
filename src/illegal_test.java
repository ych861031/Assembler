import java.util.HashMap;

public class illegal_test {
    public static HashMap<Integer,String> hashMap = new HashMap<>();
    private  HashMap<Integer,String> hashMap2 = new HashMap<>();

    public void set(int i,String s){
        this.hashMap2.put(5,"1000");
    }

    public String get(int i){
        System.out.println(this.hashMap2.get(i));
        return this.hashMap2.get(i);
    }

}
