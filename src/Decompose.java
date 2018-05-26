
import java.util.ArrayList;
import java.util.HashMap;


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
        Operation = new String[100];
        Operend = new String[100];
        Comments = new String[100];


        int k=-1;//save index all save was change

        for (int i=0;i<Lines.length;i++){
            k++;
            char dot = Lines[i].charAt(0);
            if (dot == '.'){
                Annotaion.put(i,Lines[k]);
                Label[k] = "";
                Operation[k] = "";
                Operend[k] = "";
                continue;
            }

            //label
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
            Label[k] = label;

            //opeation
            String operation="";

            try{
                if (Lines[i].charAt(7)=='+'){
                    operation = String.valueOf(Lines[i].charAt(7));
                }
                for (int j=8;j<15;j++){
                    char c = Lines[i].charAt(j);
                    if (!String.valueOf(c).equals(" ")){
                        operation = operation+c;
                    }
                }
            }catch (Exception e){
                Operation[k] = operation;
                if (Operation[k].equals("LTORG")){
                    Label[k] = "";
                    Operend[k] = "";
                    Comments[k] = "";
                    int j;
                    for (j=0;j<i;j++){
                        if (Decompose.Operend[j].charAt(0)=='='){
                            break;
                        }
                    }
                    ++k;
                    Label[k] = "*";
                    Operation[k] = Operend[j];
                    Operend[k] = "";
                    Comments[k] = "";
                }
                continue;
            }
//            System.out.println(operation);
            Operation[k] = operation;

            Operation[k] = operation;
            if (Operation[k].equals("LTORG")){
                Label[k] = "";
                Operend[k] = "";
                Comments[k] = "";
                int j;
                for (j=0;j<i;j++){
                    if (Decompose.Operend[j].charAt(0)=='='){
                        break;
                    }
                }
                ++k;
                Label[k] = "*";
                Operation[k] = Operend[j];
                Operend[k] = "";
                Comments[k] = "";
                continue;
            }
          //operend
            String operend = "";
            try{
                if (Lines[i].charAt(15)=='#'||Lines[i].charAt(15)=='@'||Lines[i].charAt(15)=='='){
                    operend = String.valueOf(Lines[i].charAt(15));
                }
                for (int j=16;j<24;j++){
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
                Operend[k] = operend;
                continue;
            }
            Operend[k] = operend;
            //comments
            try{
                char c = Lines[i].charAt(26);
                if (!String.valueOf(c).equals(" ")){
                    Comments[k] = Lines[i].substring(25,Lines[i].length());
                }
            }catch (Exception e){
                continue;
            }
        }




//        可忽略,查看分解除來的
//        System.out.println("Look Label...");
//        for (int k=0;k<Label.length;k++){
//            if (Label[k]!=null){
//                System.out.println(k+ " " + Label[k]);
//            }
//        }
//////
//        System.out.println("Look Operation...");
//        for (int z=0;z<Operation.length;z++){
//            if (Operation[z]!=null){
//                System.out.println(z+":"+Operation[z]);
//            }
//        }

//        System.out.println("Look Operend...");
//        for (int k=0;k<Operend.length;k++){
//            if (Operend[k]!=null){
//                System.out.println(Operend[k]);
//            }
//        }

//          System.out.println("Look Comments...");
//          for (int k=0;k<Label.length;k++){
//              if (Comments[k]!=null){
//                  System.out.println(Comments[k]);
//              }
//          }

    }
}
