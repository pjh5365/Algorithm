import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[][] arr = new int[N][N];
		LinkedList<Pair>[][] onSwitch = new LinkedList[N][N];

		int[] checkX = {1, -1, 0, 0};
		int[] checkY = {0, 0, 1, -1};
		Queue<Pair> move = new LinkedList<>(); // 이동을 담당하는 큐

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int nowX = Integer.parseInt(st.nextToken());
			int nowY = Integer.parseInt(st.nextToken());
			int switchX = Integer.parseInt(st.nextToken());
			int switchY = Integer.parseInt(st.nextToken());

			if (onSwitch[nowX - 1][nowY - 1] == null) {
				onSwitch[nowX - 1][nowY - 1] = new LinkedList<>();
				onSwitch[nowX - 1][nowY - 1].add(new Pair(switchX - 1, switchY - 1));
			} else {
				onSwitch[nowX - 1][nowY - 1].add(new Pair(switchX - 1, switchY - 1));
			}
		}

		int result = 1;
		move.add(new Pair(0, 0));
		int[][] visited = new int[N][N]; // 매번 새로운 방문을 하는것처럼
		arr[0][0] = 1;
		while (!move.isEmpty()) {
			Pair poll = move.poll();

			LinkedList<Pair> nowSwitch = onSwitch[poll.x][poll.y];
			while (nowSwitch != null && !nowSwitch.isEmpty()) { // 불을 켤 수 있다면 불켜기
				Pair now = nowSwitch.poll();
				if (arr[now.x][now.y] == 0) {
					result++;
					visited = new int[N][N]; // 새로운 불을 켤때마다 방문횟수를 초기화
					arr[now.x][now.y] = 1;
				}
			}

			for (int i = 0; i < 4; i++) { // 불이 켜져있는지 확인하고 이동
				int x = poll.x + checkX[i];
				int y = poll.y + checkY[i];

				if (x < 0 || x >= N || y < 0 || y >= N)
					continue;

				if (arr[x][y] == 1 && visited[x][y] == 0) { // 방문하지 않은 곳만 방문하기
					move.add(new Pair(x, y));
					visited[x][y] = 1;
				}
			}
		}
		bw.write(String.valueOf(result));
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
