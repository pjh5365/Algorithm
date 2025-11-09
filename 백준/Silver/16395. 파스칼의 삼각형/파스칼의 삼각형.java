import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[][] dp = new int[31][31];
        dp[1][1] = 1;
        dp[2][1] = 1;
        dp[2][2] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i][1] = 1;
            for (int j = 2; j < n; j++) {
                dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
            }
            dp[i][i] = 1;
        }


        bw.write(dp[n][k] + "\n");
        bw.flush();
    }
}
