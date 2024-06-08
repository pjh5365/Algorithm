import java.io.*;
import java.util.*;

public class Main {

	static int N;
	static int W[][];
	static int arr[];
	static boolean used[];
	static int result = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());

		W = new int[N][N];
		arr = new int[N];
		used = new boolean[N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				W[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		find(0);

		bw.write(String.valueOf(result));
		bw.flush();
	}

	static void find(int k) {
		if (k == N) {
			int tmp = 0;
			// 마지막은 무조건 첫번째 장소에 들려야함 마지막에 더해주기
			for (int i = 0; i < N - 1; i++) {
				if (W[arr[i]][arr[i + 1]] == 0) { // 경로가 없는 경우에는 구할수 없음
					return;
				}
				tmp += W[arr[i]][arr[i + 1]];
			}
			if (W[arr[N - 1]][arr[0]] == 0) { // 마지막에 처음으로 돌아가는 경로가 없는 경우에도 구할 수 없음
				return;
			}
			tmp += W[arr[N - 1]][arr[0]]; // 마지막엔 첫번째 장소 들리기
			result = Math.min(tmp, result);
			return;
		}


		for (int i = 0; i < N; i++) {
			if (!used[i]) {
				used[i] = true;
				arr[k] = i;
				find(k + 1);
				used[i] = false;
			}
		}
	}
}
