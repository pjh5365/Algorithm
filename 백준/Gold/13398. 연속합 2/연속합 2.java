import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N + 1];
		int[][] dp = new int[N + 1][2];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int result = Integer.MIN_VALUE;
		for (int i = 1; i <= N; i++) {
			dp[i][0] = Math.max(dp[i - 1][0] + arr[i], arr[i]);
			dp[i][1] = Math.max(dp[i - 1][0], dp[i - 1][1] + arr[i]);
			if (i >= 2) {
				result = Math.max(result, Math.max(dp[i][0], dp[i][1]));
			}
		}

		if (N == 1) {
			bw.write(String.valueOf(arr[1]));
		} else {
			bw.write(String.valueOf(result));
		}
		bw.flush();
	}
}
