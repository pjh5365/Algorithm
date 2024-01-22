import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


		int K = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int W = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());

		int[][] arr = new int[W][H];
		int[][][] visited = new int[K + 1][W][H];

		for (int i = 0; i < H; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < W; j++) {
				arr[j][i] = Integer.parseInt(st.nextToken());
			}
		}

		int[] checkX = {-1, 1, 0, 0};
		int[] checkY = {0, 0, -1, 1};
		int[] horseX = {-2, -2, -1, -1, 1, 1, 2, 2};
		int[] horseY = {-1, 1, -2, 2, -2, 2, -1, 1};
		Queue<Pair> q = new LinkedList<>();
		q.add(new Pair(0, 0, 0));
		// visited[0][0][0] = 1;
		while (!q.isEmpty()) {
			Pair now = q.poll();

			if (now.x == W - 1 && now.y == H - 1)
				break;

			for (int i = 0; i < 4; i++) {
				int x = now.x + checkX[i];
				int y = now.y + checkY[i];

				if (x < 0 || x >= W || y < 0 || y >= H)
					continue;

				if (arr[x][y] == 0 && visited[now.count][x][y] == 0) {
					q.add(new Pair(x, y, now.count));
					visited[now.count][x][y] = visited[now.count][now.x][now.y] + 1;
				}
			}
			if (now.count < K) { // 말처럼 움직일 수 있다면
				for (int i = 0; i < 8; i++) {
					int x = now.x + horseX[i];
					int y = now.y + horseY[i];

					if (x < 0 || x >= W || y < 0 || y >= H)
						continue;

					if (arr[x][y] == 0 && visited[now.count + 1][x][y] == 0) {
						q.add(new Pair(x, y, now.count + 1));
						visited[now.count + 1][x][y] = visited[now.count][now.x][now.y] + 1;
					}
				}
			}
		}
		int result = Integer.MAX_VALUE;
		for (int i = 0; i <= K; i++) {
			if (visited[i][W - 1][H - 1] == 0)
				continue;
			result = Math.min(result, visited[i][W - 1][H - 1]);
		}
		if (result == Integer.MAX_VALUE)
			result = -1;
		if (W == 1 && H == 1)
			result = 0;
		bw.write(String.valueOf(result));
		bw.flush();
	}

	static class Pair {
		int x;
		int y;
		int count;

		public Pair(int x, int y, int count) {
			this.x = x;
			this.y = y;
			this.count = count;
		}
	}
}
