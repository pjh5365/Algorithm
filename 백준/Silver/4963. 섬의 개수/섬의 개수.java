import java.io.*;
import java.util.*;

public class Main {
	/**
	 * 단순한 BFS 구현 문제
	 */
	static int w;
	static int h;
	static int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
	static int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};
	static int[][] arr;
	static boolean[][] visited;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());

			if (w == 0 && h == 0) {
				break;
			}

			arr = new int[h][w];
			visited = new boolean[h][w];
			int ret = 0;
			for (int i = 0; i < h; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < w; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					if (!visited[i][j] && arr[i][j] == 1) {
						bfs(i, j);
						ret++;
					}
				}
			}

			sb.append(ret).append("\n");
		}

		bw.write(String.valueOf(sb));
		bw.flush();
	}

	static void bfs(int x, int y) {
		Queue<Pair> q = new LinkedList<>();

		q.add(new Pair(x, y));
		visited[x][y] = true;

		while (!q.isEmpty()) {
			Pair now = q.poll();
			for (int i = 0; i < 8; i++) {
				int X = now.x + dx[i];
				int Y = now.y + dy[i];

				if (X < 0 || X > h - 1 || Y < 0 || Y > w - 1) {
					continue;
				}

				if (!visited[X][Y] && arr[X][Y] == 1) {
					visited[X][Y] = true;
					q.add(new Pair(X, Y));
				}
			}
		}
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
