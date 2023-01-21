package StrictlyPalindromeInt;

public class StrictPalindorme {

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
    public static boolean isStrictlyPalindromic(int n) {
      String number = String.valueOf(n);
      int check;
      for (int i = 2; i < n-1; i++){
          check = (int) Long.parseLong(Long.toString(Long.parseLong(number, 10), i));

          if(isPalindrome(check) == false){
              return false;
          }
      }
      return true;
    }

    public static void main(String[] args){
        System.out.println(isStrictlyPalindromic(1054));
    }
}
