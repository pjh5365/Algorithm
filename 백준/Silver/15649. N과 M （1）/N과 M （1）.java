import java.io.*;
import java.util.StringTokenizer;

public class Main {

	static StringBuilder sb = new StringBuilder();
	static int[] arr = new int[9];
	static int[] used = new int[9];

	static int N;
	static int M;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		print(0);

		bw.write(String.valueOf(sb));
		bw.flush();
	}

	static void print(int k) {
		if (k == M) { // 모두 선택한 경우
			for (int i = 0; i < M; i++) {
				sb.append(arr[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		for (int i = 1; i <= N; i++) {
			if (used[i] == 0) { // i 가 사용되지 않은 경우
				arr[k] = i; // 현재 위치에 i 입력
				used[i] = 1; // 사용표시
				print(k + 1); // 현재 위치에서 값을 선택했으므로 다음칸으로 넘어가기
				used[i] = 0; // 현재 위치에 i 를 사용한 경우는 모두 탐색했으므로 다시 사용안한표시
			}
		}
	}
}
