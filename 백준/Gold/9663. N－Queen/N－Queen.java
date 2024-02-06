import java.io.*;

public class Main {

	static int N;
	static int count = 0;
	static int[] used1 = new int[30];
	static int[] used2 = new int[30];
	static int[] used3 = new int[30];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());

		queen(0);

		bw.write(String.valueOf(count));
		bw.flush();
	}

	static void queen(int k) {
		if (k == N) {
			count++;
			return;
		}
		for (int i = 0; i < N; i++) {
			// 같은 열, 대각선이라 놓을 수 없다면 넘어가기
			if (used1[i] == 1 || used2[i + k] == 1 || used3[k - i + N - 1] == 1)
				continue;
			used1[i] = 1;
			used2[i + k] = 1;
			used3[k - i + N - 1] = 1;
			queen(k + 1);
			used1[i] = 0;
			used2[i + k] = 0;
			used3[k - i + N - 1] = 0;
		}
	}
}
