import java.io.*;
import java.util.*;

public class Main {

	static int N;
	static int[][] arr;
	static int min = Integer.MAX_VALUE;
	static int[] backtrack;
	static boolean[] use;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		backtrack = new int[N / 2];
		use = new boolean[N];
		find(0);

		bw.write(String.valueOf(min));
		bw.flush();
	}

	static void find(int k) {
		if (k == N / 2) {
			int diff = 0;
			int[] team = new int[N];
			for (int i = 0; i < N; i++) {
				team[i] = 0;
			}
			for (int i = 0; i < N / 2; i++) {
				team[backtrack[i]] = 1;
			}
			for (int i = 0; i < N; i++) {
				for (int j = i + 1; j < N; j++) {
					if (team[i] != team[j]) // 서로 다른팀이면
						continue;
					// 같은 팀일때
					if (team[i] == 0) // 0번팀일때
						diff += arr[i][j] + arr[j][i];
					else // 1번팀일때
						diff -= arr[i][j] + arr[j][i];
				}
			}

			min = Math.min(min, Math.abs(diff));
			return;
		}

		int start = 0;
		if (k != 0)
			start = backtrack[k - 1];
		for (int i = start; i < N; i++) {
			if (!use[i]) {
				use[i] = true;
				backtrack[k] = i;
				find(k + 1);
				use[i] = false;
			}
		}
	}
}
