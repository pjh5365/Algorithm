import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int M;
	static int[][] graph;
	static long[] dist;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		graph = new int[N + 1][N + 1];
		dist = new long[N + 1];

		for (int i = 1; i <= N; i++) {
			Arrays.fill(graph[i], Integer.MAX_VALUE);
		}
		Arrays.fill(dist, (int)1e9);
		dist[1] = 0;

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			graph[a][b] = Math.min(graph[a][b], c);
		}

		if (bellmanFord()) {
			sb.append("-1").append("\n");
		} else {
			for (int i = 2; i <= N; i++) {
				if (dist[i] == 1e9) {
					sb.append("-1").append("\n");
				} else {
					sb.append(dist[i]).append("\n");
				}
			}
		}

		bw.write(String.valueOf(sb));
		bw.newLine();
		bw.flush();
	}

	static boolean bellmanFord() {
		for (int i = 1; i < N; i++) { // 1번 노드 빼고 탐색
			for (int v = 1; v <= N; v++) { // 경유지노드
				for (int u = 1; u <= N; u++) { // 도착지 노드
					if (dist[v] == 1e9) {
						continue;
					}
					if (dist[u] > dist[v] + graph[v][u]) {
						dist[u] = dist[v] + graph[v][u];
					}
				}
			}
		}
		for (int v = 1; v <= N; v++) { // 경유지노드
			for (int u = 1; u <= N; u++) { // 도착지 노드
				if (dist[v] == 1e9) {
					break;
				}
				if (dist[u] > dist[v] + graph[v][u]) {
					return true;
				}
			}
		}
		return false;
	}
}
