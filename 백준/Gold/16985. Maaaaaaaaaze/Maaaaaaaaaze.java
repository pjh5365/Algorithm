import java.io.*;
import java.util.*;

public class Main {

	static int[] dx = {1, -1, 0, 0, 0, 0};
	static int[] dy = {0, 0, 1, -1, 0, 0};
	static int[] dz = {0, 0, 0, 0, 1, -1};
	static int result = Integer.MAX_VALUE;
	static int[] s = new int[5];
	static boolean[] use = new boolean[5];
	static boolean[][][] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int[][][] arr = new int[5][5][5];
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int k = 0; k < 5; k++)
					arr[i][j][k] = Integer.parseInt(st.nextToken());
			}
		}

		stackUp(0, arr);
		// find(0, arr);
		if (result == Integer.MAX_VALUE)
			result = -1;

		bw.write(String.valueOf(result));
		bw.flush();
	}

	static void stackUp(int k, int[][][] arr) {
		if (k == 5) {
			int[][][] map = new int[5][5][5];
			for (int i = 0; i < 5; i++) {
				for (int j = 0; j < 5; j++) {
					map[s[i]][j] = arr[i][j].clone();
				}
			}
			find(0, map);
			return;
		}
		for (int i = 0; i < 5; i++) {
			if (!use[i]) {
				use[i] = true;
				s[k] = i;
				stackUp(k + 1, arr);
				use[i] = false;
			}
		}
	}

	static void find(int k, int[][][] arr) { // 판들을 돌리는 경우
		int[][][] copied = copy(arr);
		if (k == 5) {
			if (copied[0][0][0] == 1) {
				visited = new boolean[5][5][5];
				result = Math.min(bfs(copied, 0, 0, 0, 1), result);
				copied = copy(arr);
			}
			if (copied[0][0][4] == 1) {
				visited = new boolean[5][5][5];
				result = Math.min(bfs(copied, 0, 0, 4, 2), result);
				copied = copy(arr);
			}
			if (copied[0][4][0] == 1) {
				visited = new boolean[5][5][5];
				result = Math.min(bfs(copied, 0, 4, 0, 3), result);
				copied = copy(arr);
			}
			if (copied[0][4][4] == 1) {
				visited = new boolean[5][5][5];
				result = Math.min(bfs(copied, 0, 4, 4, 4), result);
			}
			return;
		}
		for (int i = 0; i < 4; i++) {
			find(k + 1, copied);
			copied[k] = turn(k, copied);
		}
	}

	static int bfs(int[][][] arr, int x, int y, int z, int v) {
		Queue<Pair> q = new LinkedList<>();
		q.add(new Pair(x, y, z));
		visited[x][y][z] = true;
		arr[x][y][z] = 0;
		while (!q.isEmpty()) {
			Pair get = q.poll();

			for (int i = 0; i < 6; i++) {
				int X = get.x + dx[i];
				int Y = get.y + dy[i];
				int Z = get.z + dz[i];

				if (X < 0 || X > 4 || Y < 0 || Y > 4 || Z < 0 || Z > 4)
					continue;

				if (arr[X][Y][Z] == 1 && !visited[X][Y][Z]) {
					visited[X][Y][Z] = true;
					arr[X][Y][Z] = arr[get.x][get.y][get.z] + 1;
					q.add(new Pair(X, Y, Z));
				}
			}
		}
		int min = Integer.MAX_VALUE;
		if (v == 1) {
			if (arr[4][4][4] != 0)
				min = Math.min(min, arr[4][4][4]);
		} else if (v == 2) {
			if (arr[4][4][0] != 0)
				min = Math.min(min, arr[4][4][0]);
		} else if (v == 3) {
			if (arr[4][0][4] != 0)
				min = Math.min(min, arr[4][0][4]);
		} else if (v == 4) {
			if (arr[4][0][0] != 0)
				min = Math.min(min, arr[4][0][0]);
		}
		if (min == 1)
			return Integer.MAX_VALUE;

		return min;
	}

	static int[][] turn(int k, int[][][] arr) {
		int[][] tmp = new int[5][5];

		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				tmp[j][5 - 1 - i] = arr[k][i][j];
			}
		}
		return tmp;
	}

	static int[][][] copy(int[][][] arr) {
		int[][][] tmp = new int[5][5][5];

		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++)
				tmp[i][j] = arr[i][j].clone();
		}

		return tmp;
	}

	static class Pair {
		int x;
		int y;
		int z;

		public Pair(int x, int y, int z) {
			this.x = x;
			this.y = y;
			this.z = z;
		}
	}
}
