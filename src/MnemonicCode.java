import java.util.HashMap;

public class MnemonicCode {
    String[] instruction = {
            "ADD","ADDF","ADDR","AND","CLEAR",//1
            "COMP","COMPF","COMPR","DIV","DIVF",//2
            "DIVR","FIX","FLOAT","HIO","J",//3
            "JEQ","JGT","JLT","JSUB","LDA",//4
            "LDB","LDCH","LDF","LDL","LDS",//5
            "LDT","LDX","LPS","UML","MULF"//6
            ,"MULR","NORM","OR","RD","RMO"//7
            ,"RSUB","SHIFTL","SHIFTR","SIO","SSK"//8
            ,"STA","STB","STCH","STF","STI"//9
            ,"STL","STS","STSW","STT","STX"//10
            ,"SUB","SUBF","SUBR","SVC","TD"//11
            ,"TIO","TIX","TIXR","WD"   //12

             };

    String[] value = {
            "18","58","90","40","B4",//1
            "28","88","A0","24","64",//2
            "9C","C4","C0","F4","3C",//3
            "30","34","38","48","00",//4
            "68","50","70","08","6C",//5
            "74","04","E0","20","60"//6
            ,"98","C8","44","D8","AC"//7
            ,"4C","A4","A8","FO","EC"//8
            ,"0C","78","54","80","D4"//9
            ,"14","7C","E8","84","10"//10
            ,"1C","5C","94","B0","E0"//11
            ,"F8","2C","B8","DC"     //12
    };

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
