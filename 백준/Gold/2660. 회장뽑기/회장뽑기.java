import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());
		int[][] graph = new int[N + 1][N + 1];

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				graph[i][j] = (int)1e9;
			}
		}

		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			if (a == -1 && b == -1) {
				break;
			}

			graph[a][b] = 1;
			graph[b][a] = 1;
		}

		for (int k = 1; k <= N; k++) {
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
				}
			}
		}

		int ret = Integer.MAX_VALUE;
		ArrayList<Integer> list = new ArrayList<>();
		int[] arr = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			int max = 0;
			for (int j = 1; j <= N; j++) {
				if (i == j) {
					continue;
				}
				max = Math.max(max, graph[i][j]);
			}
			arr[i] = max;
			ret = Math.min(ret, max);
		}

		for (int i = 1; i <= N; i++) {
			if (arr[i] == ret) {
				list.add(i);
			}
		}

		sb.append(ret).append(" ").append(list.size()).append("\n");
		for (int i : list) {
			sb.append(i).append(" ");
		}
		sb.append("\n");

		bw.write(String.valueOf(sb));
		bw.newLine();
		bw.flush();
	}
}
