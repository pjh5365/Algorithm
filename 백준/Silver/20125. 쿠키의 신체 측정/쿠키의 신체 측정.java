import java.io.*;
import java.util.*;

public class Main {

	static int N;
	static int[][] arr;
	static int[] dx = {0, 0, 1, -1};
	static int[] dy = {1, -1, 0, 0};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		Pair head = null;
		int count = 0;
		for (int i = 0; i < N; i++) {
			String input = br.readLine();
			for (int j = 0; j < N; j++) {
				char now = input.charAt(j);

				if (now == '*') {
					arr[i][j] = 1;
					count++;
					if (count == 1) {
						arr[i][j] = 0;
						head = new Pair(i, j);
					}
				}
			}
		}

		arr[head.x + 1][head.y] = 0;
		sb.append(head.x + 2).append(" ").append(head.y + 1).append("\n");

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (arr[i][j] == 1) {
					int result = bfs(i, j);
					sb.append(result).append(" ");
				}
			}
		}

		bw.write(String.valueOf(sb));
		bw.flush();
	}

	static int bfs(int x, int y) {
		Queue<Pair> q = new LinkedList<>();
		q.add(new Pair(x, y));
		arr[x][y] = 0;
		int count = 1;

		while (!q.isEmpty()) {
			Pair get = q.poll();

			for (int i = 0; i < 4; i++) {
				int X = get.x + dx[i];
				int Y = get.y + dy[i];

				if (X < 0 || X >= N || Y < 0 || Y >= N) {
					continue;
				}

				if (arr[X][Y] == 1) {
					count++;
					arr[X][Y] = 0;
					q.add(new Pair(X, Y));
				}
			}
		}

		return count;
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