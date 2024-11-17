import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int K;
	static int[][] arr;
	static boolean[] visited;
	static int ret = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		arr = new int[N][N];
		visited = new boolean[N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int k = 0; k < N; k++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					arr[i][j] = Math.min(arr[i][j], arr[i][k] + arr[k][j]);
				}
			}
		}
		visited[K] = true;
		dfs(1, K, 0);

		bw.write(String.valueOf(ret));
		bw.flush();
	}

	static void dfs(int cnt, int start, int sum) {
		if (cnt == N) {
			ret = Math.min(ret, sum);
		}

		for (int i = 0; i < N; i++) {
			if (!visited[i]) {
				visited[i] = true;
				dfs(cnt + 1, i, sum + arr[start][i]);
				visited[i] = false;
			}
		}
	}
}
