import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		boolean[][] arr = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < M; j++) {
				arr[i][j] = (s.charAt(j) == 'W');
			}
		}
		int ret = Integer.MAX_VALUE;
		for (int i = 0; i <= N - 8; i++) {
			for (int j = 0; j <= M - 8; j++) {
				boolean check = arr[i][j];
				int cnt = 0;
				for (int k = i; k < i + 8; k++) {
					for (int l = j; l < j + 8; l++) {
						if (arr[k][l] != check) {
							cnt++;
						}
						check = !check;
					}
					check = !check;
				}
				// 첫째칸의 색에 따른 계산 2개 중 최소값으로 갱신
				ret = Math.min(ret, Math.min(cnt, 64 - cnt));
				if (ret == 0) {
					break;
				}
			}
		}

		bw.write(String.valueOf(ret));
		bw.flush();
	}
}
