import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		long[][] dp = new long[100001][4];

		dp[1][1] = 1; // 1로 시작하는 1
		dp[2][2] = 1; // 2로 시작하는 2
		dp[3][1] = 1; // 1로 시작하는 1+2
		dp[3][2] = 1; // 2로 시작하는 2+1
		dp[3][3] = 1; // 3으로 시작하는 3

		for (int i = 4; i <= 100000; i++) {
			dp[i][1] = (dp[i - 1][3] + dp[i - 1][2]) % 1000000009; // 1+3으로 시작하는 수열, 1+2로 시작하는 수열
			dp[i][2] = (dp[i - 2][1] + dp[i - 2][3]) % 1000000009; // 2+1로 시작하는 수열, 2+3으로 시작하는 수열
			dp[i][3] = (dp[i - 3][1] + dp[i - 3][2]) % 1000000009; // 3+1로 시작하는 수열, 3+2로 시작하는 수열
		}

		while (T > 0) {
			int n = Integer.parseInt(br.readLine());
			sb.append((dp[n][1] + dp[n][2] + dp[n][3]) % 1000000009).append("\n");
			T--;
		}

		bw.write(String.valueOf(sb));
		bw.flush();
	}
}
