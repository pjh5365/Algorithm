import java.io.*;
import java.util.*;

public class Main {

	static int N;
	static int M;
	static int G;
	static int R;
	static int[][] arr;
	static int result = 0;
	static ArrayList<Pair> list = new ArrayList<>();
	static int[] gArr;
	static int[] rArr;
	static boolean[] gUse;
	static boolean[] rUse;
	static int[][] gVisited;
	static int[][] rVisited;
	static int[] dx = {0, 0, 1, -1};
	static int[] dy = {1, -1, 0, 0};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		G = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());

		arr = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if (arr[i][j] == 2) { // 배양액을 뿌릴 수 있는 위치라면 저장
					list.add(new Pair(i, j));
				}
			}
		}

		// 초록 배양액을 모두 뿌리고 남는 땅에 빨간 배양액을 모두 뿌리는 경우를 구하기.
		gArr = new int[G];
		gUse = new boolean[list.size()];
		combinationG(0);

		bw.write(String.valueOf(result));
		bw.flush();
	}

	static void combinationG(int k) {
		if (k == G) { // 조합이 완성되면 빨간 배양액을 뿌릴 조합 찾기
			rUse = new boolean[list.size()];
			rArr = new int[R];
			combinationR(0);
			return;
		}
		int start = 0;
		if (k > 0)
			start = gArr[k - 1];
		for (int i = start; i < list.size(); i++) {
			if (!gUse[i]) {
				gUse[i] = true;
				gArr[k] = i;
				combinationG(k + 1);
				gUse[i] = false;
			}
		}
	}

	static void combinationR(int k) {
		if (k == R) { // 조합이 완성되면 bfs 탐색
			gVisited = new int[N][M];
			rVisited = new int[N][M];
			result = Math.max(result, bfs());
			return;
		}
		int start = 0;
		if (k > 0)
			start = rArr[k - 1];
		for (int i = start; i < list.size(); i++) {
			if (!gUse[i] && !rUse[i]) { // 초록 배양액을 뿌린 자리가 아니고 빨간 배양액도 뿌려지지 않았다면
				rUse[i] = true;
				rArr[k] = i;
				combinationR(k + 1);
				rUse[i] = false;
			}
		}
	}

	static int bfs() {
		Queue<Pair> gQ = new LinkedList<>();
		Queue<Pair> rQ = new LinkedList<>();

		for (int i : gArr) {
			Pair now = list.get(i);
			gVisited[now.x][now.y] = 1;
			gQ.add(now);
		}

		for (int i : rArr) {
			Pair now = list.get(i);
			rVisited[now.x][now.y] = 1;
			rQ.add(now);
		}

		int count = 0;
		while (!gQ.isEmpty() || !rQ.isEmpty()) { // 둘 중 하나라도 탐색이 종료되면 종료
			int gLength = gQ.size();
			int rLength = rQ.size();

			for (int i = 0; i < gLength; i++) { // 초록 배양액 탐색
				Pair now = gQ.poll();
				if (rVisited[now.x][now.y] == gVisited[now.x][now.y]) // 꽃이 핀자리라면 넘기기
					continue;
				for (int j = 0; j < 4; j++) {
					int x = now.x + dx[j];
					int y = now.y + dy[j];

					if (x < 0 || x > N - 1 || y < 0 || y > M - 1)
						continue;

					if (arr[x][y] != 0 && gVisited[x][y] == 0) { // 호수가 아니고 방문하지 않았다면
						gVisited[x][y] += gVisited[now.x][now.y] + 1; // 방문
						gQ.add(new Pair(x, y)); // 큐에 새로운 자리 삽입
					}
				}
			}

			for (int i = 0; i < rLength; i++) { // 빨간 배양액 전체 + 1
				Pair now = rQ.poll();
				if (rVisited[now.x][now.y] == gVisited[now.x][now.y]) // 꽃이 핀자리라면 넘기기
					continue;
				for (int j = 0; j < 4; j++) {
					int x = now.x + dx[j];
					int y = now.y + dy[j];

					if (x < 0 || x > N - 1 || y < 0 || y > M - 1)
						continue;

					if (arr[x][y] != 0 && rVisited[x][y] == 0) { // 호수가 아니고 방문하지 않았다면
						rVisited[x][y] = rVisited[now.x][now.y] + 1; // 방문
						if (gVisited[x][y] == rVisited[x][y]) // 동시에 방문했다면
							count++; // 꽃을 피우고
						rQ.add(new Pair(x, y)); // 큐에 새로운 자리 삽입
					}
				}
			}
		}
		return count;
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
