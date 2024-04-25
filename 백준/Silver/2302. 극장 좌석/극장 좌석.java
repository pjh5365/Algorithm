import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		int[] dp = new int[N + 1];
		int M = Integer.parseInt(br.readLine());
		int[] arr = new int[M];
		for (int i = 0; i < M; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		dp[0] = 1;
		dp[1] = 1;

		for (int i = 2; i <= N; i++) {
			dp[i] = dp[i - 1] + dp[i - 2];
		}
		int index = 0;
		int result = 1;
		for (int i : arr) {
			result *= dp[i - index - 1]; // 지정좌석을 제외한 경우의 수 곱하기 (지정좌석의 바로 앞까지)
			index = i;
		}
		// 지정좌석 이후 마지막좌석까지의 경우
		result *= dp[N - index];

		bw.write(String.valueOf(result));
		bw.flush();
	}
}
