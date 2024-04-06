import java.io.*;
import java.util.*;

public class Main {

	static int N;
	static int[][] arr;
	static int[][] sum;
	static int[] dx = {0, 0, 1, -1};
	static int[] dy = {1, -1, 0, 0};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int problem = 1;
		int result = 0;
		while (true) {
			N = Integer.parseInt(br.readLine());

			if (N == 0) {
				break;
			}

			arr = new int[N][N];
			sum = new int[N][N];
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
					sum[i][j] = Integer.MAX_VALUE;
				}
			}

			result = bfs();
			sb.append("Problem ").append(problem).append(": ").append(result).append("\n");
			problem++;
		}

		bw.write(String.valueOf(sb));
		bw.flush();
	}

	static int bfs() {
		Queue<Pair> q = new PriorityQueue<>();

		q.add(new Pair(0, 0, arr[0][0]));
		boolean[][] visited = new boolean[N][N];

		while (!q.isEmpty()) {
			Pair now = q.poll();

			for (int i = 0; i < 4; i++) {
				int x = now.x + dx[i];
				int y = now.y + dy[i];

				if (x < 0 || x > N - 1 || y < 0 || y > N - 1) {
					continue;
				}

				int tmp = now.sum + arr[x][y];

				if (!visited[x][y] && sum[x][y] > tmp) {    // 최소값이 바뀐다면
					visited[x][y] = true;
					sum[x][y] = tmp;
					q.add(new Pair(x, y, tmp));
				}
			}
		}
		return sum[N - 1][N - 1];
	}

	static class Pair implements Comparable<Pair> {
		int x;
		int y;
		int sum;

		public Pair(int x, int y, int sum) {
			this.x = x;
			this.y = y;
			this.sum = sum;
		}

		@Override
		public int compareTo(Pair o) {
			return this.sum - o.sum;
		}
	}
}
