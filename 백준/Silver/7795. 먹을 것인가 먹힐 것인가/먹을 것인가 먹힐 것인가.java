import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		while (T > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());

			int[] A = new int[N];
			int[] B = new int[M];

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				A[i] = Integer.parseInt(st.nextToken());
			}

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < M; i++) {
				B[i] = Integer.parseInt(st.nextToken());
			}

			Arrays.sort(A);
			Arrays.sort(B);

			int count = 0;

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (A[i] <= B[j]) {
						count += j;
						break;
					}
					if (j == M - 1) {
						count += M;
					}
				}
			}
			sb.append(count).append("\n");
			T--;
		}

		bw.write(String.valueOf(sb));
		bw.flush();
	}
}
