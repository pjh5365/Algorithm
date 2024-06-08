import java.io.*;
import java.util.*;

public class Main {

	static int N;
	static int input[];
	static int arr[];
	static boolean used[];
	static int result = 0;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());

		input = new int[N];
		arr = new int[N];
		used = new boolean[N];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}

		find(0);

		bw.write(String.valueOf(result));
		bw.flush();
	}

	static void find(int k) {
		if (k == N) {
			int tmp = 0;
			for (int i = 0; i < N - 1; i++) {
				int sum = Math.abs(arr[i] - arr[i + 1]);
				tmp += sum;
			}
			result = Math.max(tmp, result);
			return;
		}


		for (int i = 0; i < N; i++) {
			if (!used[i]) {
				used[i] = true;
				arr[k] = input[i];
				find(k + 1);
				used[i] = false;
			}
		}
	}
}
