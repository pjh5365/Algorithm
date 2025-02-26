import java.io.*;
import java.util.*;

public class Main {
	// 일반적인 풀이로는 시간 초과 발생 -> 참고: https://drasgon.tistory.com/323
	static int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1}; // 치삼이가 이동 가능한 위치
	static int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1}; // 치삼이가 이동 가능한 위치
	static int[] waterDx = {-1, 1, 0, 0}; // 물이 번지는 위치
	static int[] waterDy = {0, 0, -1, 1}; // 물이 번지는 위치
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());

		Queue<Pair> waterQ = new ArrayDeque<>(); // 물이 존재하는 곳을 담은 큐

		int[][] arr = new int[N + 1][N + 1];
		int[][] water = new int[N + 1][N + 1];

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				water[i][j] = -1;
			}
		}
		for (int i = 0; i < W; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			water[x][y] = 0;
			waterQ.add(new Pair(x, y));
		}

		for (int i = 1; i <= N; i++) {
			String s = br.readLine();
			for (int j = 1; j <= N; j++) {
				int now = s.charAt(j - 1) - '0';
				arr[i][j] = now;
			}
		}

		while (!waterQ.isEmpty()) { // 물부터 퍼트리기
			Pair now = waterQ.poll();
			for (int j = 0; j < 4; j++) {
				int x = waterDx[j] + now.x;
				int y = waterDy[j] + now.y;

				if (x < 0 || x > N || y < 0 || y > N) {
					continue;
				}

				if (water[x][y] == -1) { // 물이 없던 곳이라면
					water[x][y] = water[now.x][now.y] + 1; // 물 퍼트리기
					waterQ.add(new Pair(x, y)); // 큐에 추가
				}
			}
		}
		water[N][N] = 0; // 종료 지점은 0으로 설정
		int[][] visited = new int[N + 1][N + 1]; // 치삼이가 방문한 곳을 저장
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				visited[i][j] = -1;
			}
		}
		PriorityQueue<Pair> q = new PriorityQueue<>(Comparator.comparingInt(o -> o.day)); // 치삼이가 탐색에 사용할 큐
		q.add(new Pair(1, 1, 0));
		visited[1][1] = 0;

		int ret = -1;
		while (!q.isEmpty()) {
			Pair now = q.poll();
			if (now.x == N && now.y == N) {
				ret = now.day;
				break;
			}
			for (int i = 0; i < 8; i++) {
				int x = dx[i] + now.x;
				int y = dy[i] + now.y;

				if (x < 0 || x > N || y < 0 || y > N || arr[x][y] == 0) {
					continue;
				}

				int day = Math.max(now.day, water[x][y]);

				if (visited[x][y] == -1 || visited[x][y] > day) {
					visited[x][y] = day;
					q.add(new Pair(x, y,day));
				}
			}
		}

		bw.write(String.valueOf(ret));
		bw.flush();
	}

	static class Pair {
		int x;
		int y;
		int day;

		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}

		public Pair(int x, int y, int day) {
			this.x = x;
			this.y = y;
			this.day = day;
		}
	}
}
