import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());

		int[] arr = new int[T];
		int[][][] dp = new int[T][W + 1][3]; // 시간/이동/나무

		for (int i = 0; i < T; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		if (arr[0] == 1) {
			dp[0][0][1] = 1;
			dp[0][1][2] = 0;
		} else {
			dp[0][0][1] = 0;
			dp[0][1][2] = 1;
		}

		for (int i = 1; i < T; i++) {
			if (arr[i] == 1) { // 1번에서 떨어짐
				// 이동이 없는 경우
				dp[i][0][1] = dp[i - 1][0][1] + 1;
				dp[i][0][2] = dp[i - 1][0][2];
				for (int j = 1; j <= W; j++) {
					// 이동하는 경우와 가만히 있는 경우에 대한 계산
					dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j - 1][2]) + 1;
					dp[i][j][2] = Math.max(dp[i - 1][j - 1][1], dp[i - 1][j][2]);
				}
			} else { // 2번에서 떨어짐
				// 이동이 없는 경우
				dp[i][0][1] = dp[i - 1][0][1];
				dp[i][0][2] = dp[i - 1][0][2] + 1;
				for (int j = 1; j <= W; j++) {
					dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j - 1][2]);
					dp[i][j][2] = Math.max(dp[i - 1][j - 1][1], dp[i - 1][j][2]) + 1;
				}
			}
		}

		int max = 0;
		for (int i = 0; i <= W; i++) {
			max = Math.max(max, Math.max(dp[T - 1][i][1], dp[T - 1][i][2]));
		}

		bw.write(String.valueOf(max));
		bw.flush();
	}
}
