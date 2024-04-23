import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		long[] dp = new long[1000001];
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 4;

		for (int i = 4; i <= 1000000; i++) {
			// 1작은수에 1을 더하는 경우 + 2작은수에 2를 더하는 경우 + 3작은수에 3을 더하는 경우
			dp[i] = (dp[i - 1] + dp[i - 2] + dp[i - 3]) % 1000000009;
		}

		while (T > 0) {
			int n = Integer.parseInt(br.readLine());
			sb.append(dp[n]).append("\n");
			T--;
		}

		bw.write(String.valueOf(sb));
		bw.flush();
	}
}
