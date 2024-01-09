import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int[][] arr = new int[n][m];
		Queue<Integer> X = new LinkedList<>();
		Queue<Integer> Y = new LinkedList<>();
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int max = 0;
		int count = 0;
		int[] checkX = {0, 0, 1, -1};
		int[] checkY = {1, -1, 0, 0};
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (arr[i][j] == 1) {
					X.add(i);
					Y.add(j);
					arr[i][j] = 0;
					count++;
					int nowSize = 0;
					while (!X.isEmpty()) {
						nowSize++;
						int xPoll = X.poll();
						int yPoll = Y.poll();
						for (int k = 0; k < 4; k++) {
							int x = xPoll + checkX[k];
							int y = yPoll + checkY[k];

							if (x < 0 || x >= n || y < 0 || y >= m)
								continue;

							if (arr[x][y] == 1) {
								arr[x][y] = 0;
								X.add(x);
								Y.add(y);
							}
						}
					}
					max = Math.max(max, nowSize);
				}
			}
		}

		bw.write(String.valueOf(count));
		bw.newLine();
		bw.write(String.valueOf(max));
		bw.flush();
	}
}
