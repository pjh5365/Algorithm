import java.io.*;
import java.util.*;

public class Main {

	static int N;
	static int[][] arr;
	static boolean[] used;
	static int[] team;
	static int result = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());

		arr = new int[N + 1][N + 1];
		team = new int[N];
		used = new boolean[N + 1];

		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 팀에는 최소 1명이 포함되어야 하므로 1명부터 N-1명까지 한팀에 들어가는 경우
		for (int i = 1; i < N; i++) {
			find(0, i);
		}

		bw.write(String.valueOf(result));
		bw.flush();
	}

	static void find(int k, int size) {
		if (k == size) {
			int tmp1 = 0;
			int tmp2 = 0;
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					if (i == j) {
						continue;
					}
					if (used[i] && used[j]) { // 첫번째 팀
						tmp1 += arr[i][j];
					} else if (!used[i] && !used[j]) { // 두번째 팀
						tmp2 += arr[i][j];
					}
				}
			}
			result = Math.min(result, Math.abs(tmp1 - tmp2));
			return;
		}

		int start = 1;
		if (k > 0) {
			start = team[k - 1];
		}

		for (int i = start; i <= N; i++) {
			if (!used[i]) {
				used[i] = true;
				team[k] = i;
				find(k + 1, size);
				used[i] = false;
			}
		}
	}
}
