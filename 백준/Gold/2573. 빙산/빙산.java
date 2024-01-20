import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int[] checkX = {1, -1, 0, 0};
		int[] checkY = {0, 0, 1, -1};

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] arr = new int[N][M];

		int max = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				max = Math.max(max, arr[i][j]);
			}
		}

		boolean no = true;
		int result = 0;
		for (int i = 0; ; i++) {
			Queue<Pair> q = new LinkedList<>();
			int[][] visited = new int[N][M];
			int count = 0;
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < M; k++) {
					if (arr[j][k] != 0 && visited[j][k] == 0) {	// 0 이 아니고 방문하지 않았다면
						q.add(new Pair(j, k));
						visited[j][k] = 1;
						count++;
						while (!q.isEmpty()) {
							Pair now = q.poll();

							for (int l = 0; l < 4; l++) {
								int x = now.x + checkX[l];
								int y = now.y + checkY[l];

								if (x < 0 || x >= N || y < 0 || y >= M)
									continue;
								if (arr[x][y] == 0 && visited[x][y] == 0) { // 주변이 방문되지 않았고 바다라면 바다만큼 카운트
									arr[now.x][now.y] -= 1;
									if (arr[now.x][now.y] < 0)    // 0 보다 더 작아지면 0으로 변경
										arr[now.x][now.y] = 0;
								}
								if (arr[x][y] != 0 && visited[x][y] == 0) {	// 방문되지 않은 빙산이라면
									q.add(new Pair(x, y));
									visited[x][y] = 1;
								}
							}
						}
					}
				}
			}
			if (count > 1) {	// 2 개 이상으로 분리된다면 탈출
				result = i;
				no = false;
				break;
			}
			if (count == 0)	// 다 녹았다면 탈출
				break;
		}
		if (no)
			bw.write("0");
		else
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
