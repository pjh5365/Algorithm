import java.io.*;
import java.util.*;

public class Main {
	// 참고: https://steady-coding.tistory.com/339
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());

		int[][] dp = new int[3][1516];
		dp[0][2] = dp[1][2] = 1;

		for (int i = 3; i <= N; i++) {
			dp[0][i] = (dp[1][i - 1] + dp[2][i - 1]) % 1000000007;
			dp[1][i] = (dp[0][i - 1] + dp[2][i - 1]) % 1000000007;
			dp[2][i] = (dp[0][i - 1] + dp[1][i - 1]) % 1000000007;
		}

		bw.write(String.valueOf(dp[0][N]));
		bw.flush();
	}
}
