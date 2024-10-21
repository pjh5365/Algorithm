import java.io.*;
import java.util.*;

public class Main {

	static int ret = 0;
	static int N;
	static int[][] arr;
	static boolean[][] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];

		int max = 0;
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				max = Math.max(max, arr[i][j]);
			}
		}

		for (int i = 0; i < max; i++) {
			int tmp = 0;
			visited = new boolean[N][N];
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < N; k++) {
					if (arr[j][k] > i && !visited[j][k]) {
						visited[j][k] = true;
						dfs(j, k, i);
						tmp++;
					}
				}
			}
			ret = Math.max(ret, tmp);
		}

		bw.write(String.valueOf(ret));
		bw.newLine();
		bw.flush();
	}

	static void dfs(int x, int y, int d) {
		int[] dx = {0, 0, 1, -1};
		int[] dy = {1, -1, 0, 0};

		for (int i = 0; i < 4; i++) {
			int X = dx[i] + x;
			int Y = dy[i] + y;

			if (X < 0 || X > N - 1 || Y < 0 || Y > N - 1 || arr[X][Y] <= d) {
				continue;
			}

			if (!visited[X][Y]) {
				visited[X][Y] = true;
				dfs(X, Y, d);
			}
		}
	}
}
