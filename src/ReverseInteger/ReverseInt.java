package ReverseInteger;

public class ReverseInt {
    /*Optimized version
        public static int reverse(int x) {
            long reversed = 0;
            while (x != 0) {
                reversed = reversed * 10 + x % 10;
                x /= 10;
            }
            if (reversed < Integer.MIN_VALUE || reversed > Integer.MAX_VALUE) {
                return 0;
            }
            return (int) reversed;
        }
     */
    public static int reverse(int x) {
        String num = String.valueOf(x);
        String invert = "";
        int end = 0;
        long val;
        if (x < 0) {
            invert = "-";
            end = 1;
        }
        for (int i = num.length() - 1; i >= end; i--) {
            invert += num.charAt(i);
        }

        val = Long.parseLong(invert);

        if (val < Integer.MIN_VALUE || val > Integer.MAX_VALUE) {
            return 0;
        } else {
            return (int) val;
        }
    }


    public static void main(String[] args) {
        System.out.println(reverse(1534236469));
    }
}
