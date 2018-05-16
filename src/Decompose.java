import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Decompose {

    public static String[] Label;
    public static String[] Operation;
    public static String[] Operend;
    public static String[] Comments;
    public static HashMap<Integer,String> Annotaion = new HashMap<>();
    public static ArrayList Ann = new ArrayList();

    public void decompose(String[] Lines){

        System.out.println("decompose...");
        Label = new String[100];
        System.out.println("Label...");
        int ann=0;
        for (int i=0;i<Lines.length;i++){
            char dot = Lines[i].charAt(0);
            if (dot == '.'){
                Annotaion.put(i,Lines[i]);
                continue;
            }

            String label = "";
            for (int j=0;j<6;j++){
                char c = Lines[i].charAt(j);
                if (!String.valueOf(c).equals(" ")){
                    label = label+c;
                }else {
                    break;
                }
            }
//            System.out.println(label);
            Label[i] = label;
        }

        Operation = new String[100];
        System.out.println("operation...");
        for (int i=0;i<Lines.length;i++){
            String operation = "";
            try{
                for (int j=8;j<15;j++){
                    char c = Lines[i].charAt(j);
                    if (!String.valueOf(c).equals(" ")){
                       operation = operation+c;
                    }
                }
            }catch (Exception e){
                Operation[i] = operation;
                continue;
            }
//            System.out.println(operation);
            Operation[i] = operation;

        }

        Operend = new String[100];
        System.out.println("operend...");
        for (int i=0;i<Lines.length;i++){
            String operend = "";
            try{
                for (int j=16;j<23;j++){
                    char c = Lines[i].charAt(j);
                    if (!String.valueOf(c).equals(" ")){
                       operend = operend + c;
                    }else {
//                        System.out.println(operend);
//                        Operend[i] = operend;
                    }
                }
            }catch (Exception e){
                //無compoment時寫法
//                System.out.println(operend);
                Operend[i] = operend;
                continue;
            }
            Operend[i] = operend;

        }

        System.out.println("Comments....");
        Comments = new String[100];
        for (int i=0;i<Lines.length;i++){
            try{
                char c = Lines[i].charAt(26);
                if (!String.valueOf(c).equals(" ")){
                    Comments[i] = Lines[i].substring(26,Lines[i].length());
                }
            }catch (Exception e){
                continue;
            }

        }
//        可忽略,查看分解除來的
//        System.out.println("Look Label...");
//        for (int k=0;k<Label.length;k++){
//            if (Label[k]!=null){
//                System.out.println(Label[k]);
//            }
//        }

//        System.out.println("Look Operation...");
//        for (int k=0;k<Operation.length;k++){
//            if (Operation[k]!=null){
//                System.out.println(Operation[k]);
//            }
//
//        }

//        System.out.println("Look Operend...");
//        for (int k=0;k<Operend.length;k++){
//            if (Operend[k]!=null){
//                System.out.println(Operend[k]);
//            }
//        }

//          System.out.println("Look Cppments...");
//          for (int k=0;k<Label.length;k++){
//              if (Comments[k]!=null){
//                  System.out.println(Comments[k]);
//              }
//          }

    }
}
