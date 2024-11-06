import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());

		ArrayList<ArrayList<Integer>> list = new ArrayList<>();
		for (int i = 0; i <= N; i++) {
			list.add(new ArrayList<>());
		}
		int[] visited = new int[N + 1];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list.get(a).add(b);
		}

		Queue<Integer> q = new LinkedList<>();
		q.add(X);
		while (!q.isEmpty()) {
			int now = q.poll();

			for (int i : list.get(now)) {
				if (visited[i] == 0) {
					visited[i] = visited[now] + 1;
					q.add(i);
				}
			}
		}

		for (int i = 1; i <= N; i++) {
			if (visited[i] == K && i != X) {
				sb.append(i).append("\n");
			}
		}

		if (sb.length() == 0) {
			sb.append("-1").append("\n");
		}

		bw.write(String.valueOf(sb));
		bw.flush();
	}
}
