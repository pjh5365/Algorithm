import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int[][] arr = new int[R][C];

		Queue<Pair> q = new LinkedList<>();
		Pair jihun = null;
		for (int i = 0; i < R; i++) {
			String input = br.readLine();
			for (int j = 0; j < C; j++) {
				if (input.charAt(j) == 'F') {    // 불의 위치라면 큐에 삽입
					q.add(new Pair(i, j));
				} else if (input.charAt(j) == 'J') {    // 지훈이의 위치기억하기
					arr[i][j] = -2;
					jihun = new Pair(i, j);
				} else if (input.charAt(j) == '#') {	// 벽은 -1 로 표시
					arr[i][j] = -1;
				} else {	// 불이 없는 구역은 -2 로 표시
					arr[i][j] = -2;
				}
			}
		}

		int result = Integer.MAX_VALUE;
		int[] xCheck = {0, 0, 1, -1};
		int[] yCheck = {1, -1, 0, 0};
		while (!q.isEmpty()) {	// 불 먼저 탐색
			Pair now = q.poll();
			int xPoll = now.x;
			int yPoll = now.y;

			for (int i = 0; i < 4; i++) {
				int x = xPoll + xCheck[i];
				int y = yPoll + yCheck[i];

				if (x < 0 || x >= R || y < 0 || y >= C)
					continue;

				if (arr[x][y] == -2) {
					arr[x][y] = arr[xPoll][yPoll] + 1;
					q.add(new Pair(x, y));
				}
			}
		}
		q.add(jihun);
		arr[jihun.x][jihun.y] = 0;	// 지훈이의 시작점은 다시 0으로 초기화
		while (!q.isEmpty()) {	// 지훈이 탐색
			Pair now = q.poll();
			int xPoll = now.x;
			int yPoll = now.y;

			for (int i = 0; i < 4; i++) {
				int x = xPoll + xCheck[i];
				int y = yPoll + yCheck[i];

				if (x < 0 || x >= R || y < 0 || y >= C) {	// 지훈이가 탈출 가능하다면
					result = Math.min(result, arr[xPoll][yPoll]);
					break;
				}

				if (arr[x][y] == -2 || (arr[x][y] > 0 && arr[x][y] > arr[xPoll][yPoll] + 1)) {	// 불이 없는 구역이거나 || 불보다 지훈이가 먼저 도착하는 경우 (불의 위치와 벽은 제외하도록 > 0 설정)
					arr[x][y] = arr[xPoll][yPoll] + 1;
					q.add(new Pair(x, y));
				}
			}
		}

		if (result == Integer.MAX_VALUE)	// 탈출 못해 result 를 갱신하지 못하는 경우
			bw.write("IMPOSSIBLE");
		else
			bw.write(String.valueOf(result + 1));
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
