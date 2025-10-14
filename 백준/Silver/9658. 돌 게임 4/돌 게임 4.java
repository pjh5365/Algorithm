import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int[] dp = new int[1001];

        dp[1] = 1;
        dp[2] = 0;
        dp[3] = 1;

        for (int i = 4; i <= N; i++) {
            if (dp[i - 1] + dp[i - 3] + dp[i - 4] > 0) {
                dp[i] = 0;
            } else {
                dp[i] = 1;
            }

        }
        if (dp[N] == 0) {
            bw.write("SK");
        } else {
            bw.write("CY");
        }
        bw.flush();
    }
}
