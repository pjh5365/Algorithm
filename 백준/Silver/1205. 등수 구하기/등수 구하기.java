import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int score = Integer.parseInt(st.nextToken());
		int p = Integer.parseInt(st.nextToken());

		Integer[] arr = new Integer[N + 1];

		int result = -1;
		if (N > 0) {
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			if (N < p) { // 태수의 점수를 무조건 넣을 수 있을 때
				arr[N] = score;
				Arrays.sort(arr, Collections.reverseOrder());
				for (int i = 0; i < N + 1; i++) {
					if (arr[i] == score) {
						result = i + 1;
						break;
					}
				}
			} else { // 태수의 점수를 넣지 못할 수도 있을 경우
				arr[N] = -1;
				Arrays.sort(arr, Collections.reverseOrder());

				if (arr[N - 1] < score) { // 태수의 점수를 넣을 수 있다면
					arr[N] = score;
					Arrays.sort(arr, Collections.reverseOrder());
					for (int i = 0; i < N; i++) {
						if (arr[i] == score) {
							result = i + 1;
							break;
						}
					}
				}
			}
		} else { // 0일때
			result = 1;
		}

		bw.write(String.valueOf(result));
		bw.flush();
	}
}
