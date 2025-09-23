import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int[] dp = new int[11];
        dp[1] = 0;
        dp[2] = 1;

        for (int i = 3; i <= N; i++) {
            dp[i] = i - 1 + dp[i - 1];
        }

        bw.write(String.valueOf(dp[N]));
        bw.flush();
    }
}
