import java.io.*;
import java.util.*;

public class Main {

	static int N;
	static int M;
	static ArrayList<Integer>[] graph;
	static int[] arr;
	static boolean[] visited;
	static int result = 0;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		graph = new ArrayList[N];
		for (int i = 0; i < N; i++) {
			graph[i] = new ArrayList<>();
		}
		visited = new boolean[N];
		arr = new int[N];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph[a].add(b);
			graph[b].add(a);
		}

		for (int i = 0; i < N; i++) {
			if (result != 1) {
				find(i, 0);
			}
		}

		bw.write(String.valueOf(result));
		bw.flush();
	}

	static void find(int start, int k) {
		if (k == 4) { // 5명의 친구가 완성된다면 종료 (0 ~ 4)
			result = 1;
			return;
		}

		for (int i : graph[start]) {
			if (!visited[i]) {
				visited[start] = true;
				find(i, k + 1);
				visited[start] = false;
			}
		}
	}
}
