import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[][] arr = new int[n + 1][m + 1];
		int[][] dp = new int[n + 1][m + 1];

		int result = 0;
		for (int i = 1; i <= n; i++) {
			String input = br.readLine();
			for (int j = 1; j <= m; j++) {
				arr[i][j] = input.charAt(j - 1) - '0';
				if (arr[i][j] == 1) {
					if (i == 1 && j == 1) {
						dp[i][j] = 1;
					} else {
						dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
					}
					result = Math.max(dp[i][j], result);
				}
			}
		}

		bw.write(String.valueOf(result * result));
		bw.flush();
	}
}
