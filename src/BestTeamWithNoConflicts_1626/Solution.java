package BestTeamWithNoConflicts_1626;

import java.util.Arrays;

public class Solution {
    public static int bestTeamScore(int[] scores, int[] ages) {
        int n = scores.length;
        int[][] players = new int[n][2];
        // Storing store the scores and ages of each player in a 2D array players,
        for (int i = 0; i < n; i++) {
            players[i][0] = scores[i];
            players[i][1] = ages[i];
        }
        // sorting array based on scores and ages in ascending order for tie-breaking.
        Arrays.sort(players, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        int[] dp = new int[n];
        int max = 0;

        for (int i = 0; i < n; i++) {
            //storing the maximum possible score for each player in dp
            dp[i] = players[i][0];
            //Comparing sores of previous players
            for (int j = 0; j < i; j++) {
                // if the age of player j is less than or equal to player i,
                // then we update dp[i] to be the maximum of dp[i] and dp[j] + score[i].
                if (players[j][1] <= players[i][1]) {
                    dp[i] = Math.max(dp[i], dp[j] + players[i][0]);
                }
            }
            max = Math.max(max, dp[i]);
        }
        //return the maximum value in dp array as the result since it's the highest overall score
        //of all possible combinations
        return max;
    }

    public static void main(String[] args){
        int []  scores = {1,2,3,5};
        int [] ages = {8,9,10,1};
        //Expected output is 6
        System.out.println(bestTeamScore(scores, ages));
    }
}
