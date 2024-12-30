import java.io.*;
import java.util.*;

public class Main {
	/**
	 * BOJ 1999번 / 누가봐도 DP문제
	 * DP를 구할 때 현재 위치가 부분행렬의 마지막이 되도록 BXB크기의 부분행렬에서의 최댓값 - 최소값을 구해놓으면된다.
	 */
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int[][] arr = new int[N + 1][N + 1];
		int[][] dp = new int[N + 1][N + 1];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if (i >= B && j >= B) {
					int min = 251;
					int max = 0;
					for (int k = i - B + 1; k <= i; k++) {
						for (int l = j - B + 1; l <= j; l++) {
							min = Math.min(min, arr[k][l]);
							max = Math.max(max, arr[k][l]);
						}
					}
					dp[i][j] = max - min;
				}
			}
		}

		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			sb.append(dp[B + a - 1][B + b - 1]).append("\n");
		}

		bw.write(String.valueOf(sb));
		bw.flush();
	}
}
