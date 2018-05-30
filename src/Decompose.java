
import java.util.ArrayList;
import java.util.HashMap;


public class Decompose {

    public static String[] Label;
    public static String[] Operation;
    public static String[] Operend;
    public static String[] Comments;
    public static HashMap<Integer,String> Annotaion = new HashMap<>();
    public static String[] Ltorg = new String[1000];
    public static int k;

    public void decompose(String[] Lines){

        System.out.println("decompose...");
        Label = new String[1000];
        Operation = new String[1000];
        Operend = new String[1000];
        Comments = new String[1000];
        int length = Lines.length;

        k=-1;//save index all save was change

        for (int i=0;i<length;i++){
            k++;
            char dot = ' ';
            try{
                dot = Lines[i].charAt(0);
            }catch (Exception e){
                e.printStackTrace();
            }

            if (dot == '.'){
                Annotaion.put(k,Lines[i]);
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

            //LTORG操作
            if (operend.length()>0&&operend.charAt(0)=='='){
                if (Ltorg[0]==null){
                    Ltorg[0] = operend;

                }else{
                    int z;
                    for (z = 0;Ltorg[z]!=null;z++){
                        if (Ltorg[z].equals(operend)){
                            break;
                        }
                    }
                    Ltorg[z] = operend;
                }
            }
        }

//        System.out.println(k);
        boolean y ;//have *
        for (int i=0;Ltorg[i]!=null;i++){
            y=true;
            for (int j=0;j<k;j++){
                if (Ltorg[i].equals(Operation[j])){
                    y=false;
                    break;
                }
            }
            if (y){
                k++;
                Label[k] = "*";
                Operation[k] = Ltorg[i];
                Operend[k] = "";
                Comments[k] = "";
            }

        }


//        for (int i =0;Ltorg[i]!=null;i++){
//            for (int j=0;Operation[j]!=null;j++){
//                if (!Ltorg[i].equals(Operation[j])) {
//                    Label[k++]="test";
//                }
//            }
//        }


        //LTORG操作
//        for (int j=0;Operend[j]!=null;j++){
//            if (Operend[j].length()>0){
//                if (Operend[j].charAt(0)=='='){
//                    System.out.println("!!!!1");
//                    Label[k]="*";
//                    Operation[k]= Operend[j];
//                    Operend[k] = "";
//                    System.out.println(Operation[k]);
//                    k++;
//                }
//            }
//        }




//        可忽略,查看分解除來的
//        System.out.println("Look Label...");
//        for (int z=0;Label[z]!=null;z++){
//            if (Label[z]!=null){
//                System.out.println(z+ " " + Label[z]);
//            }
//        }

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
