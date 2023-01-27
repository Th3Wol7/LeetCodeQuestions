package StringtoInteger;

public class StringToInt {

    public static int myAtoi(String s) {
        double num = 0;
        String value = "";
        boolean negative = false;
        s = s.trim();
        for(int i = 0; i< s.length(); i++){
            //This first if statement is to stop the loop when the last character in the string is reached
            //so that strings like "words like 987" outputs 0 because the last character is e and the loop
            // should end as per the instructions. However, a wrong is returned for output -12 for string
            // "+-12", but they expect a -42 output for string "   -42" so i'm a bit confused.
            if(Character.isDigit(s.charAt(s.length()-1)) && Character.isLetter(s.charAt(i))){
                value = "";
                break;
            }
            if(i+1 < s.length() && s.charAt(i) == '.' && Character.isDigit(s.charAt(i+1))){
                value += s.charAt(i);
            }
            if(Character.isDigit(s.charAt(i))){
                value += s.charAt(i);
            }else if(i+1 < s.length() && s.charAt(i) == '-' && Character.isDigit(s.charAt(i+1))){
                negative = true;
            }
        }
        if(!value.equals("")){
            num = Double.parseDouble(value);
            if(negative){
                num = num - (num *2);
            }
        }

        if(num > Integer.MAX_VALUE){
            num = Integer.MAX_VALUE;
        }
        if(num < Integer.MIN_VALUE){
            num = Integer.MIN_VALUE;
        }
        return (int) num;
    }

    public static void main(String[] args){
        System.out.println(myAtoi("-42")); //"+-12"
    }

}
