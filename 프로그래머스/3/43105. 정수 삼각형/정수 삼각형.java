import java.util.*;

class Solution {
    
    public int solution(int[][] arr) {
        int[][] dp = new int[arr.length][arr.length];
        dp[0][0] = arr[0][0];
        dp[1][0] = dp[0][0] + arr[1][0];
        dp[1][1] = dp[0][0] + arr[1][1];
        
        int max = 0;
        for (int i = 2; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (j == 0) {
                    dp[i][j] = dp[i - 1][j] + arr[i][j];
                } else if (j == arr[i].length) {
                    dp[i][j] = dp[i - 1][j - 1] + arr[i][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j - 1] + arr[i][j], dp[i - 1][j] + arr[i][j]);
                }
                max = Math.max(max, dp[i][j]);
            }
        }
        
        return max;
    }
}