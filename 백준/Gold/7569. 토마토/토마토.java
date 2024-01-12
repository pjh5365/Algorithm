import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());

		int[][][] arr = new int[H][N][M];    // z y x
		Queue<Pair> q = new LinkedList<>();
		int zeroCount = 0;	// 토마토가 빈 자리 카운트

		for (int i = 0; i < H; i++) {
			for (int j = 0; j < N; j++) {
				st = new StringTokenizer(br.readLine());
				for (int k = 0; k < M; k++) {
					arr[i][j][k] = Integer.parseInt(st.nextToken());
					if (arr[i][j][k] == 1) {
						q.add(new Pair(k, j, i));
					} else if (arr[i][j][k] == 0) {
						zeroCount++;
					}
				}
			}
		}

		int[] xIndex = {0, 0, 1, -1, 0, 0};
		int[] yIndex = {0, 0, 0, 0, 1, -1};
		int[] zIndex = {1, -1, 0, 0, 0, 0};

		int max = 1;
		while (!q.isEmpty()) {
			Pair poll = q.poll();

			for (int i = 0; i < 6; i++) {
				int x = poll.x + xIndex[i];
				int y = poll.y + yIndex[i];
				int z = poll.z + zIndex[i];

				if (x < 0 || x >= M || y < 0 || y >= N || z < 0 || z >= H)
					continue;
				if (arr[z][y][x] == 0) {
					zeroCount--;
					arr[z][y][x] = arr[poll.z][poll.y][poll.x] + 1;
					q.add(new Pair(x, y, z));
					max = Math.max(max, arr[z][y][x]);
				}
			}
		}

		if (zeroCount != 0)	// 토마토가 익지 않은 곳이 있는 경우
			max = 0;
		bw.write(String.valueOf(max - 1));
		bw.flush();
	}

	static class Pair {
		int x;
		int y;
		int z;

		public Pair(int x, int y, int z) {
			this.x = x;
			this.y = y;
			this.z = z;
		}
	}
}
