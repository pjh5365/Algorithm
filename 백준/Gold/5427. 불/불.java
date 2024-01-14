import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		int[] checkX = {0, 0, 1, -1};
		int[] checkY = {1, -1, 0, 0};
		for (int i = 0; i < T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			Queue<Pair> q = new LinkedList<>();
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int[][] arr = new int[M][N];
			Pair s = null;
			for (int j = 0; j < M; j++) {
				String input = br.readLine();
				for (int k = 0; k < N; k++) {
					char now = input.charAt(k);
					if (now == '#')
						arr[j][k] = -1;
					else if (now == '*') {
						q.add(new Pair(k, j));
						arr[j][k] = -2;    // 불 표시
					} else if (now == '@')
						s = new Pair(k, j);
				}
			}

			while (!q.isEmpty()) {
				Pair poll = q.poll();

				for (int j = 0; j < 4; j++) {
					int x = poll.x + checkX[j];
					int y = poll.y + checkY[j];

					if (x < 0 || x >= N || y < 0 || y >= M)
						continue;
					if (arr[y][x] == 0) {
						q.add(new Pair(x, y));
						if (arr[poll.y][poll.x] == -2)    // 불의 시작점에서 첫번째로 퍼저나갔다면
							arr[y][x] = 1;
						else
							arr[y][x] = arr[poll.y][poll.x] + 1;
					}
				}
			}
			q.add(s);
			arr[s.y][s.x] = 0;
			boolean no = true;
			while (!q.isEmpty()) {
				Pair poll = q.poll();
				if (!no)    // 탈출했다면
					break;

				for (int j = 0; j < 4; j++) {
					int x = poll.x + checkX[j];
					int y = poll.y + checkY[j];

					if (x < 0 || x >= N || y < 0 || y >= M) {    // 탈출가능하다면
						sb.append(arr[poll.y][poll.x] + 1).append("\n");
						no = false;
						break;
					}
					if (arr[y][x] == 0 || (arr[y][x] != -1 && arr[y][x] > arr[poll.y][poll.x] + 1)) {
						q.add(new Pair(x, y));
						arr[y][x] = arr[poll.y][poll.x] + 1;
					}
				}
			}
			if (no)	// 탈출 불가능하다면
				sb.append("IMPOSSIBLE").append("\n");
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
