import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		int[] dp = new int[Math.max(Math.abs(n) + 1, 3)];
		dp[1] = 1;
		dp[2] = 1;
		for (int i = 3; i <= Math.abs(n); i++) {
			dp[i] = (dp[i - 1] + dp[i - 2]) % 1000000000;
		}
		if (n > 0 || Math.abs(n) % 2 == 1) {
			bw.write(String.valueOf(1));
		} else if (n == 0) {
			bw.write(String.valueOf(0));
		} else {
			bw.write(String.valueOf(-1));
		}
		bw.newLine();

		bw.write(String.valueOf(dp[Math.abs(n)]));
		bw.flush();
	}
}
