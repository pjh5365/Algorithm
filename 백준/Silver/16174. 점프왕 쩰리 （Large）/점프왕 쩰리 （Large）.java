import java.io.*;
import java.util.*;

public class Main {
	/**
	 * DFS 탐색으로 오른쪽 맨 아래에 도착할 수 있는지 검사한다.
	 */
	static int[] dx = {0, 1};
	static int[] dy = {1, 0};
	static int N;
	static int[][] arr;
	static boolean[][] visited;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		visited = new boolean[N][N];
		
		String ret;

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		if (dfs(0, 0)) {
			ret = "HaruHaru";
		} else {
			ret = "Hing";
		}
		bw.write(ret);
		bw.flush();
	}

	static boolean dfs(int x, int y) {
		visited[x][y] = true;
		if (arr[x][y] == -1) {
			return true;
		}
		for (int i = 0; i < 2; i++) {
			int X = x + dx[i] * arr[x][y];
			int Y = y + dy[i] * arr[x][y];

			if (X < 0 || Y < 0 || X >= N || Y >= N || visited[X][Y]) {
				continue;
			}
			if (dfs(X, Y)) {
				return true;
			}
		}
		return false;
	}
}
