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
			for (int i = 1; i < maxValue; i++) { // 1에서부터 최대값사이에서 상한액 구하기
				int sum = 0;
				for (int j = 0; j < N; j++) {
					sum += Math.min(arr[j], i); // 상한액보다 작은 값으로 더하기
				}
				if (sum > M) {
					result = i - 1;
					break;
				}
			}
		}

		bw.write(String.valueOf(result));
		bw.flush();
	}
}
