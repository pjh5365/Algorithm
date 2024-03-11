import java.io.*;
import java.util.*;

public class Main {

	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	static int N;
	static int M;
	static int[][] arr;
	static int result = 0;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		st = new StringTokenizer(br.readLine());
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++)
				arr[i][j] = Integer.parseInt(st.nextToken());
		}
		bfs(new Pair(x, y, d));

		bw.write(String.valueOf(result));
		bw.flush();
	}

	static void bfs(Pair start) {
		Queue<Pair> q = new LinkedList<>();
		q.add(start);
		boolean[][] visited = new boolean[N][M];

		while (!q.isEmpty()) {
			Pair now = q.poll();

			if (arr[now.x][now.y] == 0) {
				visited[now.x][now.y] = true;
				arr[now.x][now.y] = 2; // 현재칸 청소
				result++;
			}
			boolean isClean = true;
			for (int i = 0; i < 4; i++) { // 주변 4칸 탐색
				int x = now.x + dx[i];
				int y = now.y + dy[i];

				if (x < 0 || x > N - 1 || y < 0 || y > M - 1)
					continue;

				if (arr[x][y] == 0) // 주변 4칸중 청소가 되지 않은 곳이 있다면
					isClean = false;
			}
			if (isClean) { // 주면 4칸 중 청소되지 않은 빈 칸이 없는 경우
				int d = now.d + 2; // 뒷쪽 방향
				if (d > 3)
					d -= 4;

				int x = now.x + dx[d];
				int y = now.y + dy[d];

				if (x < 0 || x > N - 1 || y < 0 || y > M - 1 || arr[x][y] == 1) { // 후진할 수 없다면 종료
					break;
				}

				q.add(new Pair(x, y, now.d)); // 방향 유지한채로 큐에 삽입
			} else { // 청소되지 않은 칸이 있는 경우
				int d = now.d - 1; // 90도 회전
				if (d < 0)
					d += 4;

				int x = now.x + dx[d];
				int y = now.y + dy[d];
				if (x < 0 || x > N - 1 || y < 0 || y > M - 1) { // 전진할 수 없다면 넘어가기
					continue;
				}

				if (arr[x][y] == 2 || arr[x][y] == 1) { // 다시 회전시켜야함
					q.add(new Pair(now.x, now.y, d));
				} else if (arr[x][y] == 0) {
					q.add(new Pair(x, y, d));
				}
			}
		}
	}

	static class Pair {
		int x;
		int y;
		int d;

		public Pair(int x, int y, int d) {
			this.x = x;
			this.y = y;
			this.d = d;
		}
	}
}
