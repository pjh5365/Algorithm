import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int[] dp = new int[1000001];
		long[] result = new long[1000001];
		Arrays.fill(dp, 1);

		for (int i = 2; i <= 1000000; i++) {
			for (int j = 1; j * i <= 1000000; j++) {
				dp[i * j] += i;
			}
		}

		for (int i = 1; i <= 1000000; i++) {
			result[i] = result[i - 1] + dp[i];
		}

		int T = Integer.parseInt(br.readLine());

		while (T > 0) {
			int N = Integer.parseInt(br.readLine());
			sb.append(result[N]).append("\n");
			T--;
		}

		bw.write(String.valueOf(sb));
		bw.flush();
	}
}
