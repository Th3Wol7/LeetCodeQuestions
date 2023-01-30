package FibonacciNumber_509;

public class Fibonacci {
    class Solution {
        public int fib(int n) {
            int num[] = new int[35];//initialized to 35 due to constraint
            num[0] = 0;
            num[1] = 1;
            if (n == 0 ){
                return 0;
            }
            if(n == 1){
                return 1;
            }
            //To get the nth value, we have to add the previous 2 values
            //therefore we pull the previously stored 2 values from the table and
            //add them to get the current number.

            for(int i = 2; i<=n; i++){
                num[i] = num[i - 1] + num[i - 2];
            }
            return num[n];
        }
    }
}
