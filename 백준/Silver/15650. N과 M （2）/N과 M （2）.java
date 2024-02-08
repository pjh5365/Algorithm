import java.io.*;
import java.util.StringTokenizer;

public class Main {

	static StringBuilder sb = new StringBuilder();
	static int N;
	static int M;
	static boolean[] use;
	static int[] arr;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		arr = new int[N];
		use = new boolean[N + 1];

		find(0);

		bw.write(String.valueOf(sb));
		bw.flush();
	}

	static void find(int k) {
		if (k == M) { // 종료 조건
			boolean check = false;

			for (int i = 0; i < M - 1; i++) {
				if (M >= 2 && arr[i] > arr[i + 1]) // 오름차순이 깨진다면
					check = true;
			}
			if (check)
				return;

			for (int i = 0; i < M; i++)
				sb.append(arr[i]).append(" ");
			sb.append("\n");
			return;
		}
		for (int i = 1; i <= N; i++) {
			if (!use[i]) {
				arr[k] = i;
				use[i] = true;
				find(k + 1);
				use[i] = false;
			}
		}
	}
}
