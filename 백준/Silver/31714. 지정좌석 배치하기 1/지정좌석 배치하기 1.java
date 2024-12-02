import java.io.*;
import java.util.*;

public class Main {
	/**
	 * 1. 모든 자리를 좌석 높이를 더해서 입력을 받는다.
	 * 2. 한 행을 입력받았다면 정렬한다.
	 * 3. 첫번째 열부터 N - 1 번째 열까지 탐색을 하면서 나보다 크지만 그 중 가장 작은 자리가 있는지 확인한다.
	 * 4. 모든 자리가 적절히 배치되었다면 다음 라인으로 넘어간다. 만약 적절히 배치되지 않았다면 바로 종료한다.
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
