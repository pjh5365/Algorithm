import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());

		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);

		int start = 1; // 과자의 최소길이
		int end = arr[N - 1]; // 과자의 최대길이
		int result = 0;
		while (start <= end) {
			int count = 0;
			int mid = (start + end) / 2;

			for (int i = 0; i < N; i++) {
				count += arr[i] / mid; // 구한 과자길이로 몇명을 먹일 수 있는지 찾기
			}

			if (count >= M) {
				result = Math.max(result, mid);
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}

		bw.write(String.valueOf(result));
		bw.flush();
	}
}
