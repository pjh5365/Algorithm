import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[N][3];
		int[] ret = new int[N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
			arr[i][2] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < 3; j++) {
				boolean check = true;
				for (int k = 0; k < N; k++) {
					if (i == k) {
						continue;
					}
					if (arr[i][j] == arr[k][j]) {
						check = false;
						break;
					}
				}
				if (check) {
					ret[i] += arr[i][j];
				}
			}
			sb.append(ret[i]).append("\n");
		}

		bw.write(String.valueOf(sb));
		bw.flush();
	}
}
