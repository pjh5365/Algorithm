import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[N][3];
		int[][] dp = new int[N][3];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int result = Integer.MAX_VALUE;
		for (int i = 0; i < 3; i++) {
			// 첫번째 집을 고정시키고 진행
			for (int j = 0; j < 3; j++) {
				if (i == j) { // 색과 맞는 집에만 최소값을 주고 나머지는 최대값을 넣어 첫번째 집을 고정함
					dp[0][j] = arr[0][j];
				} else {
					dp[0][j] = 10000;
				}
			}
			for (int j = 1; j < N; j++) {
				dp[j][0] = Math.min(dp[j - 1][1], dp[j - 1][2]) + arr[j][0];
				dp[j][1] = Math.min(dp[j - 1][0], dp[j - 1][2]) + arr[j][1];
				dp[j][2] = Math.min(dp[j - 1][0], dp[j - 1][1]) + arr[j][2];
			}
			if (i == 0) { // 첫집이 빨간집인 경우
				result = Math.min(result, Math.min(dp[N - 1][1], dp[N - 1][2]));
			} else if (i == 1) { // 첫집이 초록집인 경우
				result = Math.min(result, Math.min(dp[N - 1][0], dp[N - 1][2]));
			} else { // 첫집이 파란집인 경우
				result = Math.min(result, Math.min(dp[N - 1][0], dp[N - 1][1]));
			}
		}
		bw.write(String.valueOf(result));
		bw.flush();
	}
}
