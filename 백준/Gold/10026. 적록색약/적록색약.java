import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		char[][] x1 = new char[N][N];
		char[][] x2 = new char[N][N];
		Queue<Pair> q = new LinkedList<>();

		for (int i = 0; i < N; i++) {
			String input = br.readLine();
			for (int j = 0; j < input.length(); j++) {
				x1[i][j] = input.charAt(j);
				x2[i][j] = input.charAt(j);
				if (input.charAt(j) == 'G') {
					x2[i][j] = 'R';
				}
			}
		}

		int[] checkX = {0, 0, 1, -1};
		int[] checkY = {1, -1, 0, 0};
		int result1 = 0;
		int result2 = 0;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (x1[i][j] != '0') {
					q.add(new Pair(i, j, x1[i][j]));
					result1++;
					while (!q.isEmpty()) {
						Pair poll = q.poll();
						for (int k = 0; k < 4; k++) {
							int x = poll.x + checkX[k];
							int y = poll.y + checkY[k];

							if (x < 0 || x >= N || y < 0 || y >= N) {
								continue;
							}

							if (x1[x][y] == poll.color) {
								x1[x][y] = '0';
								q.add(new Pair(x, y, poll.color));
							}
						}
					}
				}
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (x2[i][j] != '0') {
					q.add(new Pair(i, j, x2[i][j]));
					result2++;
					while (!q.isEmpty()) {
						Pair poll = q.poll();
						for (int k = 0; k < 4; k++) {
							int x = poll.x + checkX[k];
							int y = poll.y + checkY[k];

							if (x < 0 || x >= N || y < 0 || y >= N) {
								continue;
							}

							if (x2[x][y] == poll.color) {
								x2[x][y] = '0';
								q.add(new Pair(x, y, poll.color));
							}
						}
					}
				}
			}
		}

		bw.write(String.valueOf(result1 + " " + result2));
		bw.flush();
	}

	static class Pair {
		int x;
		int y;
		char color;

		public Pair(int x, int y, char color) {
			this.x = x;
			this.y = y;
			this.color = color;
		}
	}
}
