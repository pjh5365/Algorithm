import java.io.*;
import java.util.*;

public class Main {

	static int N;
	static int M;
	static char[][] map;
	static boolean[][] visited;
	static boolean result = false;
	static int[] dx = {0, 0, 1, -1};
	static int[] dy = {1, -1, 0, 0};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new char[N][M];
		visited = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			String input = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = input.charAt(j);
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (!result) { // 결과가 나오지 않은경우 탐색
					dfs(i, j, i, j, map[i][j], 1);
				}
			}
		}

		if (result) {
			bw.write(String.valueOf("Yes"));
		} else {
			bw.write(String.valueOf("No"));
		}
		bw.flush();
	}

	static void dfs(int startX, int startY, int nowX, int nowY, char now, int size) {
		visited[nowX][nowY] = true;
		for (int i = 0; i < 4; i++) {
			int x = nowX + dx[i];
			int y = nowY + dy[i];

			if (x < 0 || x > N - 1 || y < 0 || y > M - 1 || map[x][y] != now) {
				continue;
			}

			if (size >= 4 && x == startX && y == startY) {
				result = true;
				return;
			}
			if (!visited[x][y]) {
				dfs(startX, startY, x, y, now, size + 1);
			}
		}
		visited[nowX][nowY] = false;
	}
}
