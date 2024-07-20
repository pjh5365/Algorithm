import java.io.*;
import java.util.*;

/**
 * N개의 학급에는 각각 M명있음 -> M명은 모두 다른 능력치 가짐
 * 각 반에서 뽑힌 대표들의 (최대 - 최소)가 최소가되어야함
 */
public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[][] arr = new int[N][M];
		int[] sIndex = new int[N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(arr[i]);
		}

		int min = Integer.MAX_VALUE;
		while (true) {
			int maxValue = Integer.MIN_VALUE;
			int minValue = Integer.MAX_VALUE;
			int minIndex = 0;
			for (int i = 0; i < N; i++) {
				if (minValue > arr[i][sIndex[i]]) {
					minValue = arr[i][sIndex[i]];
					minIndex = i;
				}
				if (maxValue < arr[i][sIndex[i]]) {
					maxValue = arr[i][sIndex[i]];
				}
			}
			min = Math.min(min, maxValue - minValue);
			sIndex[minIndex]++; // 최소값인 반의 다음선수로 이동
			if (sIndex[minIndex] >= M) { // 학생수를 넘는다면 종료
				break;
			}
		}

		bw.write(String.valueOf(min));
		bw.flush();
	}
}
