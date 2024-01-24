import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int[][] arr = new int[N][M];
		int[][][] visited = new int[K + 1][N][M];

		for (int i = 0; i < N; i++) {
			String input = br.readLine();
			for (int j = 0; j < M; j++) {
				arr[i][j] = input.charAt(j) - '0';
			}
		}
		Queue<Pair> q = new LinkedList<>();
		q.add(new Pair(0, 0, 0));
		visited[0][0][0] = 1;
		int[] checkX = {0, 0, 1, -1};
		int[] checkY = {1, -1, 0, 0};

		int result = Integer.MAX_VALUE;
		int index = 0;
		while (!q.isEmpty()) {
			Pair poll = q.poll();

			if (poll.x == N - 1 && poll.y == M - 1) {
				index = poll.count;
				break;
			}

			for (int i = 0; i < 4; i++) {
				int x = poll.x + checkX[i];
				int y = poll.y + checkY[i];

				if (x < 0 || x >= N || y < 0 || y >= M)
					continue;

				if (arr[x][y] == 0 && visited[poll.count][x][y] == 0) {
					q.add(new Pair(x, y, poll.count));
					visited[poll.count][x][y] = visited[poll.count][poll.x][poll.y] + 1;
				}
				if (arr[x][y] == 1 && poll.count < K && visited[poll.count][x][y] == 0 && visited[poll.count + 1][x][y] == 0) {
					q.add(new Pair(x, y, poll.count + 1));
					visited[poll.count + 1][x][y] = visited[poll.count][poll.x][poll.y] + 1;
				}
			}
		}
		for (int i = index; i <= K; i++) {
			if (visited[i][N - 1][M - 1] == 0)
				continue;
			result = Math.min(result, visited[i][N - 1][M - 1]);
		}

		if (result == Integer.MAX_VALUE)
			result = -1;

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
