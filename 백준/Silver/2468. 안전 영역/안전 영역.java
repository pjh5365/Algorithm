import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[N][N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int max = 1;
		int[] checkX = {0, 0, 1, -1};
		int[] checkY = {1, -1, 0, 0};
		for (int i = 0; i < 101; i++) {
			int[][] copy = new int[N][N];

			for (int j = 0; j < N; j++) 	// 2차원 배열의 깊은복사
				copy[j] = arr[j].clone();

			int result = 0;
			Queue<Pair> q = new LinkedList<>();
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < N; k++) {
					if (copy[j][k] > i) {
						q.add(new Pair(j, k));
						copy[j][k] = 0;
						result++;

						while (!q.isEmpty()) {
							Pair poll = q.poll();

							for (int l = 0; l < 4; l++) {
								int x = poll.x + checkX[l];
								int y = poll.y + checkY[l];

								if (x < 0 || x >= N || y < 0 || y >= N)
									continue;

								if (copy[x][y] > i) {
									q.add(new Pair(x, y));
									copy[x][y] = 0;
								}
							}
						}
					}
				}
			}
			max = Math.max(max, result);
		}

		bw.write(String.valueOf(max));
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
