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
		int[][][][] visited = new int[K + 1][N][M][2];

		for (int i = 0; i < N; i++) {
			String input = br.readLine();
			for (int j = 0; j < M; j++) {
				arr[i][j] = input.charAt(j) - '0';
			}
		}
		Queue<Pair> q = new LinkedList<>();
		q.add(new Pair(0, 0, 0, 0));
		visited[0][0][0][0] = 1;
		int[] checkX = {0, 0, 1, -1};
		int[] checkY = {1, -1, 0, 0};

		int result = -1;
		while (!q.isEmpty()) {
			Pair poll = q.poll();

			if (poll.x == N - 1 && poll.y == M - 1) {
				result = visited[poll.count][poll.x][poll.y][poll.isDay];
				break;
			}

			for (int i = 0; i < 4; i++) {
				int x = poll.x + checkX[i];
				int y = poll.y + checkY[i];

				if (x < 0 || x >= N || y < 0 || y >= M)
					continue;

				if (arr[x][y] == 0) { // 낮, 밤과 상관없이 이동 가능하다면
					if (visited[poll.count][x][y][1 - poll.isDay] > 0)    // 방문했었다면 넘어간다.
						continue;
					visited[poll.count][x][y][1 - poll.isDay] = visited[poll.count][poll.x][poll.y][poll.isDay] + 1;
					q.add(new Pair(x, y, poll.count, 1 - poll.isDay));
				} else { // 벽이 있다면
					if (poll.count == K) // 벽을 더 부술수 없다면
						continue;
					if (poll.isDay == 0) {    // 낮이면 바로 깨기
						if (visited[poll.count + 1][x][y][1] > 0)	// 방문했었다면 넘어간다.
							continue;
						visited[poll.count + 1][x][y][1] = visited[poll.count][poll.x][poll.y][0] + 1;
						q.add(new Pair(x, y, poll.count + 1, 1));
					} else if (poll.isDay == 1) { // 밤이면
						if (visited[poll.count][poll.x][poll.y][0] > 0) // 방문했었다면 넘어간다.
							continue;
						visited[poll.count][poll.x][poll.y][0] = visited[poll.count][poll.x][poll.y][1] + 1;
						q.add(new Pair(poll.x, poll.y, poll.count, 0));
					}
				}
			}
		}

		bw.write(String.valueOf(result));
		bw.flush();
	}

	static class Pair {
		int x;
		int y;
		int count;
		int isDay;

		public Pair(int x, int y, int count, int isDay) {
			this.x = x;
			this.y = y;
			this.count = count;
			this.isDay = isDay;
		}
	}
}
