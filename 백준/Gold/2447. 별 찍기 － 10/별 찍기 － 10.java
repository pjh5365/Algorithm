import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());

		int[][] arr = new int[N][N];

		star(0, 0, N, arr);

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
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
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					if (i == 1 && j == 1)
						continue;
					arr[x + i][y + j] = 1;
				}
			}
			return;
		}
		N /= 3;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (i == 1 && j == 1)
					continue;
				star(x + (N * i), y + (N * j), N, arr);
			}
		}
	}
}
