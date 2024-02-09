import java.io.*;
import java.util.StringTokenizer;

public class Main {

	static StringBuilder sb = new StringBuilder();
	static int N;
	static int M;
	static int[] arr;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		arr = new int[N];

		find(0);

		bw.write(String.valueOf(sb));
		bw.flush();
	}

	static void find(int k) {
		if (k == M) { // 종료 조건
			for (int i = 0; i < M; i++)
				sb.append(arr[i]).append(" ");
			sb.append("\n");
			return;
		}
		for (int i = 1; i <= N; i++) {
			arr[k] = i;
			find(k + 1);
		}
	}
}
