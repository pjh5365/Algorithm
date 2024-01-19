import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int[] checkX = {1, -1, 0, 0};
		int[] checkY = {0, 0, 1, -1};

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[][] arr = new int[N][M];
		int[][][] visited = new int[2][N][M];

		for (int i = 0; i < N; i++) {
			String input = br.readLine();
			for (int j = 0; j < M; j++) {
				arr[i][j] = input.charAt(j) - '0';
			}
		}
		Queue<Pair> q = new LinkedList<>();
		q.add(new Pair(0, 0, false));
		arr[0][0] = 0;
		visited[0][0][0] = 1;
		visited[1][0][0] = 1;

		while (!q.isEmpty()) {
			Pair now = q.poll();

			for (int i = 0; i < 4; i++) {
				int x = now.x + checkX[i];
				int y = now.y + checkY[i];

				if (x < 0 || x >= N || y < 0 || y >= M)
					continue;

				if (arr[N - 1][M - 1] != 0)
					break;

				if (arr[x][y] == 0) {	// 벽이 아닌 경우
					if (!now.destroy && visited[0][x][y] == 0) {    // 벽을 한번도 부시지 않고 방문
						q.add(new Pair(x, y, false));
						visited[0][x][y] = visited[0][now.x][now.y] + 1;
					} else if (now.destroy && visited[1][x][y] == 0) {	// 벽을 한 번 부수고 방문
						q.add(new Pair(x, y, true));
						visited[1][x][y] = visited[1][now.x][now.y] + 1;
					}
				} else if (arr[x][y] == 1 && !now.destroy) {    // 벽을 한번도 파괴하지 않았다면
					q.add(new Pair(x, y, true));
					visited[1][x][y] = visited[0][now.x][now.y] + 1;
				}
			}
		}
		if (visited[0][N - 1][M - 1] == 0 && visited[1][N - 1][M - 1] == 0)
			bw.write("-1");
		else if (visited[0][N - 1][M - 1] != 0 || visited[1][N - 1][M - 1] != 0) {
			int result = Math.min(visited[0][N - 1][M - 1], visited[1][N - 1][M - 1]);
			if (result == 0)
				result = Math.max(visited[0][N - 1][M - 1], visited[1][N - 1][M - 1]);
			bw.write(String.valueOf(result));
		}
		bw.flush();
	}

	static class Pair {
		int x;
		int y;
		boolean destroy;

		public Pair(int x, int y, boolean destroy) {
			this.x = x;
			this.y = y;
			this.destroy = destroy;
		}
	}
}

