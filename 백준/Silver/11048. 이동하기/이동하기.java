import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[][] arr = new int[N][M];
		int[][] dp = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int ret = 0;
		dp[0][0] = arr[0][0];

		for (int i = 1; i < N; i++) {
			dp[i][0] += dp[i - 1][0] + arr[i][0];
			ret = Math.max(dp[i][0], ret);
		}

		for (int i = 1; i < M; i++) {
			dp[0][i] += dp[0][i - 1] + arr[0][i];
			ret = Math.max(dp[0][i], ret);
		}

		for (int i = 1; i < N; i++) {
			for (int j = 1; j < M; j++) {
				dp[i][j] = Math.max(dp[i - 1][j - 1], Math.max(dp[i - 1][j], dp[i][j - 1])) + arr[i][j];
				ret = Math.max(ret, dp[i][j]);
			}
		}

		bw.write(String.valueOf(ret));
		bw.newLine();
		bw.flush();
	}
}
