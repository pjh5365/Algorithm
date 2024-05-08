import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());

		int[] arr = new int[N + 1];
		int[][] dp = new int[N + 1][N + 1];
		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		for (int i = 1; i <= N; i++) {
			for (int j = i; j <= N; j++) {
				int start = i;
				int end = j;
				boolean isPalindrome = true;

				while (start < end) {
					if (arr[start] != arr[end]) {
						isPalindrome = false;
						break;
					}
					start++;
					end--;
				}
				if (isPalindrome) {
					dp[i][j] = 1;
				}
			}
		}
		int M = Integer.parseInt(br.readLine());
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			sb.append(dp[start][end]).append("\n");
		}
		bw.write(String.valueOf(sb));
		bw.flush();
	}
}
