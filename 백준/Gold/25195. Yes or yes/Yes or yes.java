import java.io.*;
import java.util.*;

public class Main {
	static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
	static boolean[] visited;
	static boolean[] isRed;
	static boolean isOk = false;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		for (int i = 0; i <= N; i++) {
			graph.add(new ArrayList<>());
		}
		visited = new boolean[N + 1];
		isRed = new boolean[N + 1];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph.get(a).add(b);
		}
		int S = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < S; i++) {
			int a = Integer.parseInt(st.nextToken());
			isRed[a] = true;
		}

		visited[1] = true;
		dfs(1);
		if (isOk) {
			sb.append("yes").append("\n");
		} else {
			sb.append("Yes").append("\n");
		}


		bw.write(String.valueOf(sb));
		bw.flush();
	}

	static void dfs(int start) {
		if (isOk || isRed[start]) {
			return;
		}
		for (int i : graph.get(start)) {
			if (!visited[i]) {
				visited[i] = true;
				dfs(i);
				visited[i] = false;
			}
		}
		if (graph.get(start).isEmpty()) {
			isOk = true;
		}
	}
}
