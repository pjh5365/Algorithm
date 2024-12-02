import java.io.*;
import java.util.*;

public class Main {
	/**
	 *
	 */
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int D = Integer.parseInt(st.nextToken());

		int[][] arr = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken()) + (D * (i + 1));
			}
			Arrays.sort(arr[i]);
		}
		for (int i = 0; i < N - 1; i++) {
			boolean[] check = new boolean[M];
			for (int j = 0; j < M; j++) {
				for (int k = 0; k < M; k++) {
					if (!check[k] && arr[i][j] < arr[i + 1][k]) {
						check[k] = true;
						break;
					}
				}
			}
			for (int j = 0; j < M; j++) {
				if (!check[j]) {
					bw.write("NO");
					bw.flush();
					return;
				}
			}
		}

		bw.write("YES");
		bw.flush();
	}
}
