import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int[][][] graph;
	static boolean[] visited;
	static int ret = 0;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		graph = new int[2][N + 1][N + 1];
		visited = new boolean[N + 1];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a= Integer.parseInt(st.nextToken());
			int b= Integer.parseInt(st.nextToken());
			graph[0][a][b] = 1;
			graph[1][b][a] = 1;
		}
		for (int i = 1; i <= N; i++) {
			dfs(i, 0);
			dfs(i, 1);
			boolean check = true;
			for (int j = 1; j <= N; j++) {
				if (!visited[j]) {
					check = false;
					break;
				}
			}
			if (check) {
				ret++;
			}
			visited = new boolean[N + 1];
		}

		bw.write(String.valueOf(ret));
		bw.flush();
	}

	static void dfs(int before, int reverse) {
		visited[before] = true;
		for (int i = 1; i <= N; i++) {
			if (!visited[i] && graph[reverse][before][i] == 1) {
				dfs(i, reverse);
			}
		}
	}
}
