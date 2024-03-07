import java.io.*;
import java.util.*;

public class Main {

	static int[][] map;
	static int N;
	static int M;
	static boolean[][] use;
	static Pair[] arr;
	static boolean[][] visited;
	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, 1, -1};
	static int max;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		arr = new Pair[3];
		use = new boolean[N][M];
		find(0);
		bw.write(String.valueOf(max));
		bw.flush();
	}

	static void find(int k) {
		if (k == 3) {
			visited = new boolean[N][M];
			int[][] tmp = copyMap(map);
			for (int i = 0; i < 3; i++) {
				Pair get = arr[i];
				tmp[get.x][get.y] = 1;
			}
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (tmp[i][j] == 2)
						tmp = bfs(tmp, i, j);
				}
			}
			max = Math.max(count(tmp), max);
			return;
		}
		/*int startI = 0;
		int startJ = 0;
		if (k > 0) {
			Pair get = arr[k - 1];
			startI = get.x;
			startJ = get.y;
		}*/

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 0 && !use[i][j]) {
					use[i][j] = true;
					arr[k] = new Pair(i, j);
					find(k + 1);
					use[i][j] = false;
				}
			}
		}
	}

	static int[][] bfs(int[][] map, int startX, int startY) {
		Queue<Pair> q = new LinkedList<>();
		q.add(new Pair(startX, startY));

		while (!q.isEmpty()) {
			Pair get = q.poll();

			for (int i = 0; i < 4; i++) {
				int x = get.x + dx[i];
				int y = get.y + dy[i];

				if (x < 0 || x > N - 1 || y < 0 || y > M - 1)
					continue;

				if (map[x][y] == 0 && !visited[x][y]) {
					map[x][y] = 2;
					visited[x][y] = true;
					q.add(new Pair(x, y));
				}
			}
		}

		return map;
	}

	static int count(int[][] map) {
		int count = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 0)
					count++;
			}
		}

		return count;
	}

	static int[][] copyMap(int[][] map) {
		int[][] tmp = new int[N][M];

		for (int i = 0; i < N; i++)
			tmp[i] = map[i].clone();

		return tmp;
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

