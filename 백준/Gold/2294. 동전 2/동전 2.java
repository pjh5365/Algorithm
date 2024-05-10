import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int[] arr = new int[n];
		int[] dp = new int[k + 1];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		Arrays.sort(args);
		for (int i = n - 1; i >= 0; i--) {
			int count = 1;
			for (int j = arr[i]; j <= k; j += arr[i]) {
				dp[j] = dp[j] == 0 ? count : Math.min(dp[j], count);
				count++;
			}
		}

		for (int i = 1; i <= k; i++) {
			int minCount = dp[i];
			for (int j = i - 1; j >= 1; j--) {
				if (dp[j] != 0 && dp[i - j] != 0) {
					minCount = minCount == 0 ? dp[j] + dp[i - j] : Math.min(minCount, dp[j] + dp[i - j]);
				}
			}
			dp[i] = minCount;
		}

		bw.write(String.valueOf(dp[k] == 0 ? -1 : dp[k]));
		bw.flush();
	}
}
