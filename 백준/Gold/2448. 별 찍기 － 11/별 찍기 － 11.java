import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());

		int[][] arr = new int[N][N * 2];

		star(0, 0, N, arr);

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < 2 * N; j++) {
				if (arr[i][j] == 1)
					sb.append("*");
				else
					sb.append(" ");
			}
			sb.append("\n");
		}

		bw.write(String.valueOf(sb));
		bw.flush();
	}

	static void star(int x, int y, int N, int[][] arr) {
		if (N == 3) {
			arr[x][y + 2] = 1;
			arr[x + 1][y + 1] = arr[x + 1][y + 3] = 1;
			for (int j = 0; j < 5; j++)
				arr[x + 2][y + j] = 1;
			return;
		}
		N /= 2;
		star(x, y + N, N, arr);
		star(x + N, y, N, arr);
		star(x + N, y + N * 2, N, arr);
	}
}
