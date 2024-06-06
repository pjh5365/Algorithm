import java.io.*;
import java.util.*;

public class Main {

	static int N;
	static int[] arr;
	static boolean[] used;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());

		arr = new int[N + 1];
		used = new boolean[N + 1];

		find(0);

		bw.write(String.valueOf(sb));
		bw.flush();
	}

	static void find(int k) {
		if (k == N) {
			for (int i = 0; i < N; i++) {
				sb.append(arr[i]).append(" ");
			}
			sb.append("\n");
			return;
		}

		for (int i = 1; i <= N; i++) {
			if (!used[i]) {
				used[i] = true;
				arr[k] = i;
				find(k + 1);
				used[i] = false;
			}
		}
	}
}
