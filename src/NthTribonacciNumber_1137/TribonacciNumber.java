package NthTribonacciNumber_1137;

public class TribonacciNumber {

    public int tribonacci(int n) {
        int num[] = new int[40];//initialized to 40 due to constraint
        num[0] = 0;
        num[1] = 1;
        num[2] = 1;
        if (n == 0 ){
            return 0;
        }
        if(n == 1 || n == 2){
            return 1;
        }
        //To get the nth value, wwe have to add the previous 3 values
        //therefore, we pull the previously stored 2 values from the table and
        //add them to get the current number.

        for(int i = 3; i<=n; i++){
            num[i] = num[i - 1] + num[i - 2] + num[i - 3];
        }
        return num[n];
    }

}
