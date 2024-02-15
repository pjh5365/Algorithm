import java.io.*;
import java.util.*;

public class Main {

	static StringBuilder sb = new StringBuilder();
	static int[] input;
	static int[] arr;
	static boolean[] check;
	static int N;
	static int M;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		input = new int[N];
		arr = new int[N];
		check = new boolean[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++)
			input[i] = Integer.parseInt(st.nextToken());

		Arrays.sort(input);

		find(0);

		bw.write(String.valueOf(sb));
		bw.flush();
	}

	static void find(int k) {
		if (k == M) {
			for (int i = 0; i < M; i++)
				sb.append(input[arr[i]]).append(" ");
			sb.append("\n");
			return;
		}
		int before = 0;
		int start = 0;
		if (k > 0)
			start = arr[k - 1];
		for (int i = start; i < N; i++) {
			if (!check[i] && before != input[i]) { // 현재 위치에서 이전 수열의 마지막 항과 현재 수열의 마지막 항이 같다면 중복
				check[i] = true;
				arr[k] = i;
				before = input[i];
				find(k + 1);
				check[i] = false;
			}
		}
	}
}
