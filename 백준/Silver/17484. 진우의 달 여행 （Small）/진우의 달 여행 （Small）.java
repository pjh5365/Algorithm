import java.io.*;
import java.util.*;

public class Main {

	static int min = Integer.MAX_VALUE;
	static int N;
	static int M;
	static int[][] arr;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		arr = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < M; i++) {
			dfs(0, i, 0, 1, 0);
		}


		bw.write(String.valueOf(min));
		bw.flush();
	}

	static void dfs(int x, int y, int sum, int count, int way) {
		if (x > N - 1 || y > M - 1 || y < 0) {
			return;
		}
		if (count == N) {
			sum += arr[x][y];
			min = Math.min(min, sum);
			return;
		}
		sum += arr[x][y];
		if (way == 0) { // 시작일때
			dfs(x + 1, y - 1, sum, count + 1, 1);
			dfs(x + 1, y, sum, count + 1, 2);
			dfs(x + 1, y + 1, sum, count + 1, 3);
		} else if (way == 1) {
			dfs(x + 1, y, sum, count + 1, 2);
			dfs(x + 1, y + 1, sum, count + 1, 3);
		} else if (way == 2) {
			dfs(x + 1, y - 1, sum, count + 1, 1);
			dfs(x + 1, y + 1, sum, count + 1, 3);
		} else if (way == 3) {
			dfs(x + 1, y - 1, sum, count + 1, 1);
			dfs(x + 1, y, sum, count + 1, 2);
		}
	}
}
