import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int[][] dp = new int[N + 1][M + 1];
		dp[0][0] = 0;
		for (int i = 1; i <= N; i++) {
			dp[i][0] = 1;
		}
		for (int i = 1; i <= M; i++) {
			dp[0][i] = 1;
		}

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
				if (dp[i][j] > 1000000000) { // 오버플로우 방지
					dp[i][j] = 1000000000;
				}
			}
		}

		if (K > dp[N][M]) {
			bw.write(String.valueOf(-1));
		} else {
			while (N != 0 && M != 0) {
				if (K > dp[N - 1][M]) {
					K -= dp[N - 1][M];
					sb.append("z");
					M--;
				} else {
					sb.append("a");
					N--;
				}
			}
			while (N != 0) {
				sb.append("a");
				N--;
			}
			while (M != 0) {
				sb.append("z");
				M--;
			}
		}

		bw.write(String.valueOf(sb));
		bw.flush();
	}
}
