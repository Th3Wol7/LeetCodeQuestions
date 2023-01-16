package PalindromeString;

public class Palindrome {

    public static String longestPalindrome(String s) {
        String longest = "";
        for (int i = 0; i < s.length(); i++) {
            String odd = getPalindrome(s, i, i);
            String even = getPalindrome(s, i, i+1);
            String palindrome = odd.length() > even.length() ? odd : even;
            if (palindrome.length() > longest.length()) {
                longest = palindrome;
            }
        }
        return longest;
    }

    private static String getPalindrome(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return s.substring(left + 1, right);
    }

    public static void main(String[] args){
        System.out.println(longestPalindrome("accc"));//"sdcbbd"));

    }

    /*long version*
    public static String longestPalindrome(String s) {
        String longest = "";
        for (int i = 0; i < s.length(); i++) {
            // check for palindromes with odd length
            int left = i, right = i;
            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
            }
            String oddPalindrome = s.substring(left + 1, right);
            if (oddPalindrome.length() > longest.length()) {
                longest = oddPalindrome;
            }

            // check for palindromes with even length
            left = i;
            right = i + 1;
            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
            }
            String evenPalindrome = s.substring(left + 1, right);
            if (evenPalindrome.length() > longest.length()) {
                longest = evenPalindrome;
            }
        }
        return longest;
    }
    */



}
