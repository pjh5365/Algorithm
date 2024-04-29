import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String A = br.readLine();
		String B = br.readLine();
		int[][] dp = new int[A.length() + 1][B.length() + 1];

		for (int i = 1; i <= A.length(); i++) {
			for (int j = 1; j <= B.length(); j++) {
				char now = B.charAt(j - 1);
				if (now == A.charAt(i - 1)) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
				} else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
				}
			}
		}

		bw.write(String.valueOf(dp[A.length()][B.length()]));
		bw.flush();
	}
}
