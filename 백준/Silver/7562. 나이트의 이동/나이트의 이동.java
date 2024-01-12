import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		int[] checkX = {-2, -1, 1, 2, -2, -1, 1, 2};
		int[] checkY = {1, 2, 2, 1, -1, -2, -2, -1};

		for (int i = 0; i <  T; i++) {
			Queue<Pair> q = new LinkedList<>();
			int N = Integer.parseInt(br.readLine());
			int[][] arr = new int[N][N];
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			arr[x][y] = 1;	// 나이트 위치 표시
			q.add(new Pair(x, y));
			st = new StringTokenizer(br.readLine());
			int endX = Integer.parseInt(st.nextToken());
			int endY = Integer.parseInt(st.nextToken());

			int result = 0;
			while (!q.isEmpty()) {
				Pair poll = q.poll();

				for (int j = 0; j < 8; j++) {
					x = poll.x + checkX[j];
					y = poll.y + checkY[j];

					if (x < 0 || x >= N || y < 0 || y >= N)
						continue;

					if (arr[x][y] == 0) {
						arr[x][y] = arr[poll.x][poll.y] + 1;
						q.add(new Pair(x, y));
					}
					if (x == endX && y == endY) {
						result = arr[x][y];
						break;
					}
				}
			}
			sb.append(result - 1).append("\n");
		}


		bw.write(String.valueOf(sb));
		bw.flush();
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
