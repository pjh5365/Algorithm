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
			for (int i = 0; i < N; i++) {
				arr[i] = Long.parseLong(st.nextToken());
			}
			max = arr[N - 1];
			int count = 0;
			for (int i = N - 2; i >= 0; i--) { // 뒤에서부터 탐색
				if (arr[i] < max) { // 주식을 구매하는 경우
					result -= arr[i];
					count++;
				} else if (arr[i] > max) { // 최대값에 팔기
					result += max * count;
					count = 0;
					max = arr[i];
				}
			}
			result += max * count; // 탐색을 완료하고 마지막 값 더하기
			sb.append(result).append("\n");
			T--;
		}

		bw.write(String.valueOf(sb));
		bw.flush();
	}
}
