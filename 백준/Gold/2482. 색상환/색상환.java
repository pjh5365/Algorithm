import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		int K = Integer.parseInt(br.readLine());
		int[][] dp = new int[N + 1][K + 1];

		for (int i = 1; i <= N; i++) {
			dp[i][1] = i;
			dp[i][0] = 1;
		}

		for (int i = 2; i <= N; i++) {
			for (int j = 2; j <= K; j++) {
				dp[i][j] = (dp[i - 2][j - 1] + dp[i - 1][j]) % 1000000003;
				// 2칸 앞에서 j - 1개를 칠하는 경우 + 현재 칸을 칠하지 않고 바로앞을 칠하는 경우
			}
		}
		int result = (dp[N - 1][K] + dp[N - 3][K - 1]) % 1000000003;
		// 바로 앞까지 칠하는 경우 + 1을 칠하지 않는 경우 (앞으로 3칸 당겨서 마지막 칸을 칠하는 경우와 같으므로 N - 3)

		bw.write(String.valueOf(result));
		bw.flush();
	}
}
