import java.util.*;

class Solution {
    public int solution(int n, int[] tops) {
        int[][] dp = new int[n + 1][2];
        
        dp[1][0] = 1;
        if (tops[0] == 1) { // 위에 삼각형이 있다면 
            dp[1][1] = 3;
        } else { // 위에 삼각형이 없다면
            dp[1][1] = 2;
        }
        
        for (int i = 2; i <= n; i++) {
            dp[i][0] = (dp[i - 1][0]+ dp[i - 1][1]) % 10007;
            if (tops[i - 1] == 1) { // 삼각형이 존재한다면
                dp[i][1] = (dp[i - 1][0] * 2 + dp[i - 1][1] * 3) % 10007;
            } else {
                dp[i][1] = (dp[i - 1][0] + dp[i - 1][1] * 2) % 10007;
            }
        }
        return (dp[n][0] + dp[n][1]) % 10007;
    }
}