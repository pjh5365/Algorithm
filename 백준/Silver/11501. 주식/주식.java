import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		while (T > 0) {
			long result = 0;
			int N = Integer.parseInt(br.readLine());
			long[] arr = new long[N + 1];
			long max = 0;

			StringTokenizer st = new StringTokenizer(br.readLine());
			int maxIndex = 0;
			for (int i = 0; i < N; i++) {
				arr[i] = Long.parseLong(st.nextToken());
				if (arr[i] >= max) {
					max = Math.max(max, arr[i]);
					maxIndex = i;
				}
			}
			int count = 0;
			for (int i = 0; i < maxIndex; i++) {
				if (arr[i] < max) { // 최대값보다 작다면 전부 구매
					result -= arr[i];
					count++;
				}
			}
			result += count * max;
			count = 0;
			while (maxIndex < N - 1) { // 최대값이 마지막값이 될 때 까지
				max = 0;
				int startIndex = maxIndex + 1;
				for (int i = maxIndex + 1; i < N; i++) {
					if (arr[i] >= max) {
						max = Math.max(max, arr[i]);
						maxIndex = i;
					}
				}
				for (int i = startIndex; i < maxIndex; i++) {
					if (arr[i] < max) { // 최대값보다 작다면 전부 구매
						result -= arr[i];
						count++;
					}
				}
				result += count * max;
				count = 0;
			}
			sb.append(result).append("\n");
			T--;
		}

		bw.write(String.valueOf(sb));
		bw.flush();
	}
}
