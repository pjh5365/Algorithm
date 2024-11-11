import java.io.*;
import java.util.*;

public class Main {
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		int[][] arr = new int[n][n];
		int[][] visited = new int[n][n];
		for (int i = 0; i < n; i++) {
			String s = br.readLine();
			for (int j = 0; j < n; j++) {
				arr[i][j] = s.charAt(j) - '0';
				visited[i][j] = Integer.MAX_VALUE;
			}
		}
		Queue<Pair> q = new LinkedList<>();
		if (arr[0][0] == 0) {
			visited[0][0] = 1;
			q.add(new Pair(0, 0, 1));
		} else {
			visited[0][0] = 0;
			q.add(new Pair(0, 0, 0));
		}

		while (!q.isEmpty()) {
			Pair now = q.poll();

			for (int i = 0; i < 4; i++) {
				int X = dx[i] + now.x;
				int Y = dy[i] + now.y;

				if (X < 0 || X > n - 1 || Y < 0 || Y > n - 1) {
					continue;
				}
				if (arr[X][Y] == 0 && now.k + 1 >= visited[X][Y]) {
					continue;
				}
				if (arr[X][Y] == 1 && now.k >= visited[X][Y]) {
					continue;
				}

				if (arr[X][Y] == 1) {
					q.add(new Pair(X, Y, now.k));
					visited[X][Y] = now.k;
				} else {
					q.add(new Pair(X, Y, now.k + 1));
					visited[X][Y] = now.k + 1;
				}
			}
		}

		bw.write(String.valueOf(visited[n - 1][n - 1]));
		bw.flush();
	}

	static class Pair {
		int x;
		int y;
		int k;

		public Pair(int x, int y, int k) {
			this.x = x;
			this.y = y;
			this.k = k;
		}
	}
}
