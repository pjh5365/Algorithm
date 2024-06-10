import java.io.*;
import java.util.*;

public class Main {

	static int N;
	static char[] input;
	static boolean[] used;
	static int[] arr;
	static long minValue = Long.MAX_VALUE;
	static long maxValue = 0;
	static StringBuilder min;
	static StringBuilder max;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());

		input = new char[N];
		arr = new int[N + 1];
		used = new boolean[10];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			input[i] = st.nextToken().charAt(0);
		}

		find(0);

		bw.write(String.valueOf(max));
		bw.newLine();
		bw.write(String.valueOf(min));
		bw.flush();
	}

	static void find(int k) {
		if (k == N + 1) {
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i <= N; i++) {
				sb.append(arr[i]);
			}
			long tmp = Long.parseLong(sb.toString());
			if (tmp < minValue) {
				minValue = tmp;
				min = sb;
			}
			if (tmp > maxValue) {
				maxValue = tmp;
				max = sb;
			}
			return;
		}

		for (int i = 0; i <= 9; i++) {
			if (!used[i]) {
				used[i] = true;
				arr[k] = i;
				boolean check = true;
				if (k > 0) { // 부등호 확인
					if (input[k - 1] == '<' && (arr[k - 1] >= arr[k])) {
						check = false;
					} else if (input[k - 1] == '>' && (arr[k - 1] <= arr[k])) {
						check = false;
					}
				}
				if (check) {
					find(k + 1);
				}
				used[i] = false;
			}
		}
	}
}
