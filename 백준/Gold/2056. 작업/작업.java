import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());
		int ret = 0;
		// 각 작업별로 끝난 시간을 담는다.
		int[] dp = new int[N + 1];

		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int time = Integer.parseInt(st.nextToken());
			int len = Integer.parseInt(st.nextToken());

			// 기다려야하는 작업이 없다면 time 만큼 소요된다.
			if (len == 0) {
				dp[i] = time;
			}
			// 작업에 소요되는 시간 계산
			for (int j = 0; j < len; j++) {
				int tmp = Integer.parseInt(st.nextToken());
				dp[i] = Math.max(dp[i], dp[tmp] + time);
			}
			// 최대 작업시간을 구해야 알맞은 답이 나온다.
			ret = Math.max(ret, dp[i]);
		}

		bw.write(String.valueOf(ret));
		bw.flush();
	}
}
