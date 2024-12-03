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

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		dfs(0, 0);
		bw.write("Hing");
		bw.flush();
	}

	static void dfs(int x, int y) {
		boolean ret = false;
		visited[x][y] = true;
		if (arr[x][y] == -1) {
			System.out.println("HaruHaru");
			System.exit(0);
		}
		for (int i = 0; i < 2; i++) {
			int X = x + dx[i] * arr[x][y];
			int Y = y + dy[i] * arr[x][y];

			if (X < 0 || Y < 0 || X >= N || Y >= N || visited[X][Y]) {
				continue;
			}
			dfs(X, Y);
		}
	}
}
