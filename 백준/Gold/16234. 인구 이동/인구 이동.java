import java.io.*;
import java.util.*;

public class Main {

	static int N;
	static int L;
	static int R;
	static int[][] arr;
	static boolean[][] visited;
	static int result = 0;
	static int[] dx = {0, 0, 1, -1};
	static int[] dy = {1, -1, 0, 0};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());

		arr = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		Loop:
		while (true) { // 한번에 가능한 모든 국경 개방
			boolean isChanged = false;
			visited = new boolean[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (!visited[i][j]) {
						if (bfs(i, j)) {
							isChanged = true;
						}
					}
				}
			}
			if (isChanged) {
				result++;
			} else {
				break Loop;
			}
		}

		bw.write(String.valueOf(result));
		bw.flush();
	}

	static boolean bfs(int x, int y) {
		Queue<Pair> q = new LinkedList<>();
		Queue<Pair> union = new LinkedList<>();


		int sum = arr[x][y];
		visited[x][y] = true;
		int count = 1;

		q.add(new Pair(x, y));

		while (!q.isEmpty()) {
			Pair now = q.poll();
			union.add(now);

			for (int i = 0; i < 4; i++) {
				int X = dx[i] + now.x;
				int Y = dy[i] + now.y;

				if (X < 0 || X > N - 1 || Y < 0 || Y > N - 1) {
					continue;
				}

				int sub = Math.abs(arr[X][Y] - arr[now.x][now.y]);

				if (sub >= L && sub <= R && !visited[X][Y]) {
					visited[X][Y] = true;
					sum += arr[X][Y];
					count++;
					q.add(new Pair(X, Y));
				}
			}
		}
		int avg = sum / count;

		if (count > 1) {
			while (!union.isEmpty()) {
				Pair now = union.poll();
				arr[now.x][now.y] = avg;
			}
			return true;
		}
		return false;
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
