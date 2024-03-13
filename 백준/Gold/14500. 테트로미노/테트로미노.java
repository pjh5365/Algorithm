import java.io.*;
import java.util.*;

public class Main {

	static int N;
	static int M;
	static int[][] arr;
	static boolean[][] visited;
	static int[] dx = {0, 0, 1, -1};
	static int[] dy = {1, -1, 0, 0};
	static int result = 0;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		visited = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				visited[i][j] = true;
				dfs(i, j, 1, arr[i][j]);
				visited[i][j] = false;
			}
		}

		bw.write(String.valueOf(result));
		bw.flush();
	}

    // 백트래킹으로 4자리 뽑아 bfs 로 확인(시간초과)하는 대신 dfs 사용하기
	static void dfs(int x, int y, int count, int sum) {
		if (count == 4) {
			result = Math.max(result, sum);
			return;
		}

		for (int i = 0; i < 4; i++) {
			int X = x + dx[i];
			int Y = y + dy[i];

			if (X < 0 || X > N - 1 || Y < 0 || Y > M - 1)
				continue;

			if (!visited[X][Y]) {

				// ㅜ, ㅏ, ㅗ, ㅓ 모양 만들기
				if (count == 2) {
					visited[X][Y] = true;
					dfs(x, y, count + 1, sum + arr[X][Y]);
					visited[X][Y] = false;
				}
				visited[X][Y] = true;
				dfs(X, Y, count + 1, sum + arr[X][Y]);
				visited[X][Y] = false;
			}
		}
	}
}
