import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		while (T > 0) {
			int N = Integer.parseInt(br.readLine());
			int[] arr = new int[N];
			int[] dp = new int[N];

			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			dp[0] = arr[0];
			int ret = arr[0];
			for (int i = 1; i < N; i++) {
				if (dp[i - 1] < 0) {
					dp[i - 1] = 0;
				}
				dp[i] = dp[i - 1] + arr[i];
				ret = Math.max(ret, dp[i]);
			}
			sb.append(ret).append("\n");
			T--;
		}

		bw.write(String.valueOf(sb));
		bw.newLine();
		bw.flush();
	}
}
