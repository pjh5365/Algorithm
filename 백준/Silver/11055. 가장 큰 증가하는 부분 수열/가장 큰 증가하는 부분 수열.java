import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		int[] dp = new int[N]; // 현재 값이 최대값이 되는 수열의 합을 저장한다.
		int[] arr = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine());
		int max = 0;
		for (int i = 0; i < N; i++) {
			int now = Integer.parseInt(st.nextToken());
			arr[i] = now;
			dp[i] = now;
			if (i > 0) { // 두번째항부터 계산한다.
				for (int j = 0; j < i; j++) {
					if (arr[j] < now) { // 작은 경우에만 계산한다. (같은 경우는 제외)
						dp[i] = Math.max(dp[i], dp[j] + now);
					}
				}
			}
			max = Math.max(dp[i], max);
		}

		bw.write(String.valueOf(max));
		bw.flush();
	}
}
