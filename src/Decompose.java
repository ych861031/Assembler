
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



        for (int i=0;i<Lines.length;i++){
            char dot = Lines[i].charAt(0);
            if (dot == '.'){
                Annotaion.put(i,Lines[i]);
                Label[i] = "";
                Operation[i] = "";
                Operend[i] = "";
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
            Label[i] = label;

            //opeation
            String operation="";

            try{
                if (Lines[i].charAt(7)=='+'||Lines[i].charAt(7)=='='){
                    operation = String.valueOf(Lines[i].charAt(7));
                }
                for (int j=8;j<15;j++){
                    char c = Lines[i].charAt(j);
                    if (!String.valueOf(c).equals(" ")){
                        operation = operation+c;
                    }
                }
            }catch (Exception e){ Operation[i] = operation;
                continue;
            }
//            System.out.println(operation);
            Operation[i] = operation;

            if (operation.equals("LTORG")){
                Label[i] = "";
                Operend[i] = "";
                Comments[i] = "";
                int j;
                for (j=0;j<i;j++){
                    if (Decompose.Operend[i].charAt(0)=='='){
                        break;
                    }
                }
                i+=1;
                Label[i] = "*";
                Operation[i] = Operation[j];
                Operend[i] = "";
                Comments[i] = "";

            }
          //operend
            String operend = "";
            try{
                if (Lines[i].charAt(15)=='#'||Lines[i].charAt(15)=='@'){
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
                Operend[i] = operend;
                continue;
            }
            Operend[i] = operend;
            //comments
            try{
                char c = Lines[i].charAt(26);
                if (!String.valueOf(c).equals(" ")){
                    Comments[i] = Lines[i].substring(25,Lines[i].length());
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
        System.out.println("Look Operation...");
        for (int k=0;k<Operation.length;k++){
            if (Operation[k]!=null){
                System.out.println(k+":"+Operation[k]);
            }
        }

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
