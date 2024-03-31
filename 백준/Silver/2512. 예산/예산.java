import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[N];

		int total = 0;
		int maxValue = 0;
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			total += arr[i];
			maxValue = Math.max(maxValue, arr[i]);
		}
		int M = Integer.parseInt(br.readLine());

		int result = 0;

		if (total <= M) { // 모두 배정할 수 있다면
			result = maxValue; // 상한액은 최대값
		} else {
			int start = 1;
			int end = maxValue;

			// 이진탐색
			while (start <= end) {
				int mid = (start + end) / 2; // 상한액
				int sum = 0;

				for (int i = 0; i < N; i++) {
					sum += Math.min(mid, arr[i]);
				}
				if (sum <= M) { // 상한액을 더 올릴 수 있다면
					start = mid + 1;
				} else { // 상한액을 내려야한다면
					end = mid - 1;
				}
			}
			result = end;
		}

		bw.write(String.valueOf(result));
		bw.flush();
	}
}
