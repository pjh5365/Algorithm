import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int[][] arr = new int[M][N];
		int[] checkX = {0, 0, 1, -1};
		int[] checkY = {1, -1, 0, 0};
		int index = -1;
		int[] size = new int[100];
		Queue<Pair> q = new LinkedList<>();

		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());

			for (int j = y1; j < y2; j++) {
				for (int k = x1; k < x2; k++) {
					arr[j][k] = 1;
				}
			}
		}

		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if (arr[i][j] == 0) {
					index++;
					arr[i][j] = 1;
					q.add(new Pair(j, i));
					size[index]++;
					while (!q.isEmpty()) {
						Pair now = q.poll();
						for (int k = 0; k < 4; k++) {
							int x = now.x + checkX[k];
							int y = now.y + checkY[k];

							if (x < 0 || x >= N || y < 0 || y >= M)
								continue;

							if (arr[y][x] == 0) {
								arr[y][x] = 1;
								size[index]++;
								q.add(new Pair(x, y));
							}
						}
					}
				}
			}
		}

		Arrays.sort(size, 0, index + 1);
		sb.append(index + 1).append("\n");
		for (int i = 0; i < index + 1; i++)
			sb.append(size[i]).append(" ");

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
