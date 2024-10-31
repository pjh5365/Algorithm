import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int M;
	static int W;
	static int[][] graph;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int TC = Integer.parseInt(br.readLine());
		while (TC > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			graph = new int[N + 1][N + 1];
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					graph[i][j] = (int)1e9;
				}
			}

			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());

				graph[a][b] = Math.min(graph[a][b], c);
				graph[b][a] = Math.min(graph[b][a], c);
			}

			for (int i = 0; i < W; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());

				graph[a][b] = Math.min(graph[a][b], -c);
			}

			if (bellmanFord()) {
				sb.append("YES").append("\n");
			} else {
				sb.append("NO").append("\n");
			}
			TC--;
		}

		bw.write(String.valueOf(sb));
		bw.newLine();
		bw.flush();
	}

	static boolean bellmanFord() {
		int[] dist = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			dist[i] = (int) 1e9;
		}
		dist[1] = 0;
		boolean updated = false;
		for (int n = 0; n < N - 1; n++) {
			updated = false;
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					if (dist[i] + graph[i][j] < dist[j]) {
						dist[j] = dist[i] + graph[i][j];
						updated = true;
					}
				}
			}
			if (!updated) break;
		}

		if (updated) {
			for (int i = 1; i <= N; i++)
				for (int j = 1; j <= N; j++)
					if (dist[i] + graph[i][j] < dist[j]) return true;
		}

		return false;

	}
}
