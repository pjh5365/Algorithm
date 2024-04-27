import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] arr = new int[N + 1];

		for (int i = 1; i <= N; i++) {
			arr[i] = i;
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());

			while (start < end) {
				int tmp = arr[start];
				arr[start] = arr[end];
				arr[end] = tmp;
				start++;
				end--;
			}
		}

		for (int i = 1; i <= N; i++) {
			sb.append(arr[i]).append(" ");
		}
		bw.write(String.valueOf(sb));
		bw.flush();
	}
}
