import java.io.*;
import java.util.*;

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

		arr = new int[M];

		find(0);

		bw.write(String.valueOf(sb));
		bw.flush();
	}

	static void find(int k) {
		if (k == M) {
			for (int i = 0; i < M; i++)
				sb.append(arr[i]).append(" ");
			sb.append("\n");
			return;
		}
		int start = 1; // 1부터 시작
		if (k != 0) // 현재 자리가 첫번째 자리가 아니라면
			start = arr[k - 1]; // 앞 자리의 숫자부터 올라가도록 설정
		for (int i = start; i <= N; i++) {
			arr[k] = i;
			find(k + 1);
		}
	}
}
