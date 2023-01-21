package PalindormeInteger;

public class PalindromeInt {

    public static boolean isPalindrome(int x) {
        long reversed = 0;
        int val = x;
        while (val != 0) {
            reversed = reversed * 10 + val % 10;
            val /= 10;
        }

        if(reversed == x && x > -1){
            return true;
        }
        return false;
    }

    public static void main(String[] args){
        System.out.println(isPalindrome(-121));
    }
}
