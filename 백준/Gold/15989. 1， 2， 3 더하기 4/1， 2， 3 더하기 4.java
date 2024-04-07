import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		// n은 10000 보다 작고 정수합의 마지막 수는 3이다.
		int[][] dp = new int[10001][4];

		dp[1][1] = 1;
		dp[2][1] = 1;
		dp[2][2] = 1;
		dp[3][1] = 1;
		dp[3][2] = 1;
		dp[3][3] = 1;

		for (int i = 4; i < 10001; i++) {
			dp[i][1] = dp[i - 1][1]; // 1 작은 수에 1 더하는 경우
			dp[i][2] = dp[i - 2][1] + dp[i - 2][2]; // 2 작은 수에 각각 2 더하는 경우
			dp[i][3] = dp[i - 3][1] + dp[i - 3][2] + dp[i - 3][3]; // 3 작은 수에 각각 3 더하는 경우
		}

		while (T > 0) {
			int n = Integer.parseInt(br.readLine());

			int result = dp[n][1] + dp[n][2] + dp[n][3];
			sb.append(result).append("\n");
			T--;
		}

		bw.write(String.valueOf(sb));
		bw.flush();
	}
}
