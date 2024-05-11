import java.io.*;
import java.util.*;

public class Main {

	static int N;
	static int M;
	static int[][] arr;
	static int[][] dp;
	static boolean[][] visited;
	static int[] dx = {0, 0, 1, -1};
	static int[] dy = {1, -1, 0, 0};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		arr = new int[N][M];
		dp = new int[N][M];
		visited = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		dfs(0, 0);

		bw.write(String.valueOf(dp[0][0]));
		bw.flush();
	}

	static int dfs(int x, int y) {
		if (x == N - 1 && y == M - 1) {
			return 1;
		}

		if (visited[x][y]) { // 탐색한적이 있다면
			return dp[x][y];
		}
		visited[x][y] = true; // 최초 탐색
		for (int i = 0; i < 4; i++) {
			int X = x + dx[i];
			int Y = y + dy[i];

			if (X < 0 || X > N - 1 || Y < 0 || Y > M - 1) {
				continue;
			}
			if (arr[x][y] > arr[X][Y]) { // 이동가능
				dp[x][y] += dfs(X, Y); // 현재위치에서 분기가능한 경로를 더한다
			}
		}
		return dp[x][y];
	}
}
