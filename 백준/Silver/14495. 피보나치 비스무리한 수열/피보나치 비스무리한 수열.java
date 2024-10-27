import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		long[] dp = new long[120];
		dp[1] = dp[2] = dp[3] = 1;
		for (int i = 4; i <= n; i++) {
			dp[i] = dp[i - 1] + dp[i - 3];
		}

		bw.write(String.valueOf(dp[n]));
		bw.newLine();
		bw.flush();
	}
}
