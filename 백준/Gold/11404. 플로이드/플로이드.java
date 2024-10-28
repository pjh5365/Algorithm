import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());

		int[][] graph = new int[n + 1][n + 1];
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				graph[i][j] = (int)1e9;
			}
		}
		for (int i = 0; i < m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			if (graph[a][b] != 0) {
				graph[a][b] = Math.min(graph[a][b], c);
			} else {
				graph[a][b] = c;
			}
		}

		for (int k = 1; k <= n; k++) {
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= n; j++) {
					graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
				}
			}
		}


		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (i == j || graph[i][j] == 1e9) {
					graph[i][j] = 0;
				}
				sb.append(graph[i][j]).append(" ");
			}
			sb.append("\n");
		}

		bw.write(String.valueOf(sb));
		bw.newLine();
		bw.flush();
	}
}
