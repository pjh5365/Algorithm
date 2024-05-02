import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		int k = 1;
		do {
			int[][] arr = new int[N][3];
			int[][] dp = new int[N][3];
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 3; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
					if (i == 0) {
						dp[i][j] = arr[i][j];
						if (j == 2) {
							dp[0][0] = dp[0][1];
							dp[0][2] = dp[0][1] + arr[0][2];
						}
					} else {
						if (j == 0) {
							dp[i][j] = Math.min(dp[i - 1][j], dp[i - 1][j + 1]) + arr[i][j];
						} else if (j == 1) {
							int min = Math.min(Math.min(dp[i - 1][j - 1], dp[i - 1][j]), Math.min(dp[i - 1][j + 1], dp[i][j - 1]));
							dp[i][j] = min + arr[i][j];
						} else {
							int min = Math.min(Math.min(dp[i - 1][j - 1], dp[i - 1][j]), dp[i][j - 1]);
							dp[i][j] = min + arr[i][j];
						}
					}
				}
			}

			sb.append(k).append(". ").append(dp[N - 1][1]).append("\n");
			k++;
			N = Integer.parseInt(br.readLine());
		} while (N != 0);

		bw.write(String.valueOf(sb));
		bw.flush();
	}
}
