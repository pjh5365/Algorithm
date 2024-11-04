import java.io.*;
import java.util.*;

public class Main {
	static int[][] graph;
	static int n;
	static boolean[] visited;
	static int ret = -1;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(br.readLine());
		graph = new int[n + 1][n + 1];
		visited = new boolean[n + 1];

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph[a][b] = 1;
			graph[b][a] = 1;
		}

		dfs(start, end, 0);

		bw.write(String.valueOf(ret));
		bw.flush();
	}

	static void dfs(int start, int end, int cnt) {
		visited[start] = true;

		if (start == end) {
			ret = cnt;
			return;
		}

		for (int i = 1; i <= n; i++) {
			if (!visited[i] && graph[start][i] == 1) {
				dfs(i, end, cnt + 1);
			}
		}
	}
}
