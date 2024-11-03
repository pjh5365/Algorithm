import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int M;
	static int[][] graph;
	static boolean[] visited;
	static int ret = 0;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		graph = new int[N + 1][N + 1];
		visited = new boolean[N + 1];

		for (int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			graph[a][b] = c;
			graph[b][a] = c;
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			visited[a] = true;
			dfs(a, b, 0);
			sb.append(ret).append("\n");
			visited[a] = false;
		}

		bw.write(String.valueOf(sb));
		bw.flush();
	}

	static void dfs(int before, int d, int cnt) {
		if (before == d) {
			ret = cnt;
			return;
		}

		for (int i = 1; i <= N; i++) {
			if (!visited[i] && graph[before][i] != 0) {
				visited[i] = true;
				dfs(i, d, cnt + graph[before][i]);
				visited[i] = false;
			}
		}
	}
}
