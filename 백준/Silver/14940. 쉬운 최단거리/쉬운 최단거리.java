import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		Queue<Pair> q = new LinkedList<>();
		int[][] arr = new int[n][m];
		int[][] ret = new int[n][m];
		boolean[][] visited = new boolean[n][m];
		int[] dx = {0, 0, 1, -1};
		int[] dy = {1, -1, 0, 0};

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				ret[i][j] = -1;

				if (arr[i][j] == 2) {
					q.add(new Pair(i, j));
					arr[i][j] = 0;
					visited[i][j] = true;
					ret[i][j] = 0;
				} else if (arr[i][j] == 0) {
					ret[i][j] = 0;
				}
			}
		}

		while (!q.isEmpty()) {
			Pair get = q.poll();

			for (int i = 0; i < 4; i++) {
				int X = get.x + dx[i];
				int Y = get.y + dy[i];

				if (X < 0 || X > n - 1 || Y < 0 || Y > m - 1) {
					continue;
				}

				if (!visited[X][Y] && arr[X][Y] != 0) {
					ret[X][Y] = ret[get.x][get.y] + 1;
					visited[X][Y] = true;
					q.add(new Pair(X, Y));
				}
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				sb.append(ret[i][j]).append(" ");
			}
			sb.append("\n");
		}

		bw.write(String.valueOf(sb));
		bw.newLine();
		bw.flush();
	}

	static class Pair {
		int x;
		int y;

		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
