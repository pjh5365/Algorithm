import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		int[][] dp = new int[N][2];
		int[] x = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine());
		int max = 0;
		int maxIndex = 0;
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			int count = 1;
			for (int j = 0; j < i; j++) {
				if (arr[j] < arr[i] && dp[j][1] + 1 > count) {
					count = dp[j][1] + 1;
					dp[i][0] = j;
				}
			}
			dp[i][1] = count;
			if (max < count) {
				max = count;
				maxIndex = i;
			}
		}
		int xIndex = 0;
		while (true) {
			if (maxIndex == 0) {
				if (xIndex == 0 || x[xIndex - 1] > arr[0]) {
					x[xIndex] = arr[maxIndex];
				} else {
					xIndex--;
				}

				sb.append(max).append("\n");
				for (int i = xIndex; i >= 0; i--) {
					sb.append(x[i]).append(" ");
				}
				break;
			}
			x[xIndex++] = arr[maxIndex];
			maxIndex = dp[maxIndex][0];
		}

		bw.write(String.valueOf(sb));
		bw.flush();
	}
}
