import java.io.*;
import java.util.*;

public class Main {
	static int[][] map;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		int[] dp = new int[n];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		dp[0] = 1;
		for (int i = 1; i < n; i++) {
			for (int j = i; j >= 0; j--) {
				if (arr[i] > arr[j]) {
					dp[i] = Math.max(dp[j] + 1, dp[i]);
				}
			}
			if (dp[i] == 0) {
				dp[i] = 1;
			}
		}

		int max = 0;
		for (int i = 0; i < n; i++) {
			max = Math.max(max, dp[i]);
		}

		bw.write(String.valueOf(max));
		bw.newLine();
		bw.flush();
	}
}
