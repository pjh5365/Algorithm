import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());

		int[] arr = new int[N + 1];
		int[] dp = new int[N + 1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			dp[i] = arr[i];
		}
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= i; j++) {
				dp[i] = Math.min(dp[i - j] + dp[j], dp[i]);
			}
		}

		bw.write(String.valueOf(dp[N]));
		bw.flush();
	}
}
