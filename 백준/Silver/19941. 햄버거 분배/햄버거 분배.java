import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		String input = br.readLine();
		int[] arr = new int[N];

		for (int i = 0; i < N; i++) {
			char now = input.charAt(i);
			if (now == 'H') {
				arr[i] = 1;
			} else {
				arr[i] = 0;
			}
		}

		int result = 0;
		for (int i = 0; i < N; i++) {
			if (arr[i] == 0) { // 사람이라면
				int start = Math.max(0, i - K);
				int end = Math.min(N, i + K + 1);
				for (int j = start; j < end; j++) {
					if (arr[j] == 1) { // 햄버거를 먹는 경우
						arr[j] = -1;
						result++;
						break;
					}
				}
			}
		}

		bw.write(String.valueOf(result));
		bw.flush();
	}
}
