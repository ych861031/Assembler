import sun.misc.FloatingDecimal;

public class Loc {
    public String location;
    public void setLoc(){

        System.out.println(hexToBinary("AD12"));
        System.out.println(binaryToHex(hexToBinary("AD12")));
    }

    public String hexToBinary(String s){
        String binary="";
        for (int i=0;i<s.length();i++){
            switch (s.charAt(i)){
                case '0':
                    binary = binary + "0000";
                    break;
                case '1':
                    binary = binary + "0001";
                    break;
                case '2':
                    binary = binary + "0010";
                    break;
                case '3':
                    binary = binary + "0011";
                    break;
                case '4':
                    binary = binary + "0100";
                    break;
                case'5':
                    binary = binary + "0101";
                    break;
                case '6':
                    binary = binary + "0110";
                    break;
                case '7':
                    binary = binary + "0111";
                    break;
                case '8':
                    binary = binary + "1000";
                    break;
                case '9':
                    binary = binary + "1001";
                    break;
                case 'A':
                    binary = binary + "1010";
                    break;
                case 'B':
                    binary = binary + "1011";
                    break;
                case 'C':
                    binary = binary + "1100";
                    break;
                case 'D':
                    binary = binary + "1101";
                    break;
                case 'E':
                    binary = binary + "1110";
                    break;
                case 'F':
                    binary = binary + "1111";
                    break;
                default:
                    break;
            }
        }
        return binary;
    }

    public String binaryToHex(String s){
        String hex = "";
        int n=s.length()/4;

        String[] binary = new String[8];
        for (int i=0,j =0;j<n;i=i+4,j++){
            hex = s.substring(i,i+4);
            binary[j] = hex;
        }

        hex = "";
        for(int i=0;i<binary.length && binary[i]!=null;i++){
            int sum=0;
            for(int j=0;j<4;j++){
                if (String.valueOf(binary[i].charAt(j)).equals("1")){

                    switch (j){
                        case 0:
                            sum+=8;
                            break;
                        case 1:
                            sum+=4;
                            break;
                        case 2:
                            sum+=2;
                            break;
                        case 3:
                            sum+=1;
                            break;
                    }
                }
            }
            hex = hex + Integer.toHexString(sum);
            hex = hex.toUpperCase();
        }

        return hex;
    }
}
