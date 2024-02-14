import java.io.*;
import java.util.*;

public class Main {

	static StringBuilder sb = new StringBuilder();
	static int N;
	static int M;
	static int[] input;
	static int[] arr;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		arr = new int[M];
		input = new int[N];

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
		int start = 0;
		if (k > 0)
			start = arr[k - 1];
		for (int i = start; i < N; i++) {
			arr[k] = i;
			find(k + 1);
		}
	}
}
