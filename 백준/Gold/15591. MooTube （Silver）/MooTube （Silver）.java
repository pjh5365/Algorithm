import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int Q = Integer.parseInt(st.nextToken());

		ArrayList<Node>[] arr = new ArrayList[N + 1];

		for (int i = 1; i <= N; i++) {
			arr[i] = new ArrayList<Node>();
		}

		for (int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine());

			int p = Integer.parseInt(st.nextToken());
			int q = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());

			arr[p].add(new Node(r, q));
			arr[q].add(new Node(r, p));
		}

		for (int i = 0; i < Q; i++) {
			st = new StringTokenizer(br.readLine());

			int k = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());

			boolean[] visited = new boolean[N + 1];
			visited[v] = true;
			Queue<Integer> q = new LinkedList<>();
			q.add(v);

			int count = 0;
			while (!q.isEmpty()) {
				int now = q.poll();

				for (Node n : arr[now]) {
					if (!visited[n.v] && n.k >= k) {
						q.add(n.v);
						visited[n.v] = true;
						count++;
					}
				}
			}
			sb.append(count).append("\n");
		}
		bw.write(String.valueOf(sb));
		bw.flush();
	}

	static class Node {
		int k;
		int v;

		public Node(int k, int v) {
			this.k = k;
			this.v = v;
		}
	}
}
