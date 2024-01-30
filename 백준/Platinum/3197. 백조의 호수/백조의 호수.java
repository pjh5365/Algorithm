import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());

		char[][] arr = new char[R][C];
		boolean[][] visitedArr = new boolean[R][C];
		boolean[][] visitedSwan = new boolean[R][C];

		Queue<Pair> swanQ = new LinkedList<>();
		Queue<Pair> waterQ = new LinkedList<>();
		for (int i = 0; i < R; i++) {
			String input = br.readLine();
			for (int j = 0; j < C; j++) {
				arr[i][j] = input.charAt(j);
				if (arr[i][j] == 'L') {
					if (swanQ.isEmpty()) {
						arr[i][j] = '.';
						swanQ.add(new Pair(i, j));
					}
					waterQ.add(new Pair(i, j));
				} else if (arr[i][j] == '.')
					waterQ.add(new Pair(i, j));
			}
		}

		int result = 0;

		while (true) {
			swanQ = bfs2(swanQ, R, C, arr, visitedSwan);
			result++;
			if (swanQ == null) { // 두 오리가 만나면 종료
				result--;
				break;
			}
			if (waterQ.isEmpty())
				break;
			waterQ = bfs1(waterQ, R, C, arr, visitedArr);
		}

		bw.write(String.valueOf(result));
		bw.flush();
	}

	// 얼음 가장자리부터 탐색
	static Queue<Pair> bfs1(Queue<Pair> q, int R, int C, char[][] arr, boolean[][] visited) {
		int[] dx = {1, -1, 0, 0};
		int[] dy = {0, 0, 1, -1};

		Queue<Pair> returnQ = new LinkedList<>();

		while (!q.isEmpty()) {
			Pair poll = q.poll();

			for (int i = 0; i < 4; i++) {
				int x = poll.x + dx[i];
				int y = poll.y + dy[i];

				if (x < 0 || x >= R || y < 0 || y >= C)
					continue;

				if (arr[x][y] == 'X' && !visited[x][y]) {
					arr[x][y] = '.'; // 물표시
					visited[x][y] = true;
					returnQ.add(new Pair(x, y));
				}
			}
		}

		return returnQ;
	}

	// 백조가 있는 위치에서 다른 백조를 찾는 탐색
	static Queue<Pair> bfs2(Queue<Pair> q, int R, int C, char[][] arr, boolean[][] visited) {
		int[] dx = {1, -1, 0, 0};
		int[] dy = {0, 0, 1, -1};

		Queue<Pair> returnQ = new LinkedList<>();
		while (!q.isEmpty()) {
			Pair poll = q.poll();

			for (int i = 0; i < 4; i++) {
				int x = poll.x + dx[i];
				int y = poll.y + dy[i];

				if (x < 0 || x >= R || y < 0 || y >= C)
					continue;

				if (arr[x][y] == 'L') {
					return null;
				} else if (arr[x][y] == '.' && !visited[x][y]) {
					visited[x][y] = true;
					q.add(new Pair(x, y));
				} else if (arr[x][y] == 'X' && !visited[x][y]) {
					visited[x][y] = true;
					returnQ.add(new Pair(x, y));
				}
			}
		}
		return returnQ;
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
