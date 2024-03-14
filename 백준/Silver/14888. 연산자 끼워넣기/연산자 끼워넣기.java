import java.io.*;
import java.util.*;

public class Main {

	static int N;
	static int[] input;
	static int[] operation = new int[4];
	static int min = Integer.MAX_VALUE;
	static int max = Integer.MIN_VALUE;
	static int[] arr;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());
		input = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 4; i++) {
			operation[i] = Integer.parseInt(st.nextToken());
		}
		arr = new int[N - 1];
		find(0, operation.clone());

		bw.write(String.valueOf(max));
		bw.newLine();
		bw.write(String.valueOf(min));
		bw.flush();
	}

	static void find(int k, int[] use) {
		if (k == N - 1) {
			int sum = 0;
			if (arr[0] == 0) {
				sum = input[0] + input[1];
			} else if (arr[0] == 1) {
				sum = input[0] - input[1];
			} else if (arr[0] == 2) {
				sum = input[0] * input[1];
			} else if (arr[0] == 3) {
				sum = input[0] / input[1];
			}
			for (int i = 1; i < k; i++) {
				if (arr[i] == 0) {
					sum += input[i + 1];
				} else if (arr[i] == 1) {
					sum -= input[i + 1];
				} else if (arr[i] == 2) {
					sum *= input[i + 1];
				} else if (arr[i] == 3) {
					sum /= input[i + 1];
				}
			}
			max = Math.max(max, sum);
			min = Math.min(min, sum);
			return;
		}

		for (int i = 0; i < 4; i++) {
			if (use[i] != 0) {
				use[i]--;
				arr[k] = i;
				find(k + 1, use);
				use[i]++;
			}
		}
	}
}
