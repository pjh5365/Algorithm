import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[N][2];
		int[] dp = new int[N + 1];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}

		int max = 0;
		for (int i = N - 1; i >= 0; i--) {
			if (i + arr[i][0] <= N) { // 현재 날짜에 상담이 가능하다면
				// 상담을 한 경우와 상담하지 않은 경우 중 최대값
				dp[i] = Math.max(dp[i + arr[i][0]] + arr[i][1], dp[i + 1]);
			} else { // 상담이 불가능하므로 앞선 값 불러오기
				dp[i] = dp[i + 1];
			}
			max = Math.max(max, dp[i]);
		}

		bw.write(String.valueOf(max));
		bw.flush();
	}
}
