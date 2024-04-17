import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());
		int[] dp = new int[N + 1];
		int[] x = new int[N + 1];

		for (int i = 2; i <= N; i++) {
			dp[i] = dp[i - 1] + 1; // 1 빼기
			x[i] = i - 1;
			if (i % 2 == 0 && dp[i] > dp[i / 2] + 1) { // 2로 나누기
				dp[i] = dp[i / 2] + 1;
				x[i] = i / 2;
			}
			if (i % 3 == 0 && dp[i] > dp[i / 3] + 1) { // 3으로 나누기
				dp[i] = dp[i / 3] + 1;
				x[i] = i / 3;
			}
		}
		sb.append(dp[N]).append("\n");
		int index = N;
		while (true) {
			sb.append(index).append(" ");
			index = x[index];
			if (index == 0) {
				break;
			}
		}

		bw.write(String.valueOf(sb));
		bw.flush();
	}
}
