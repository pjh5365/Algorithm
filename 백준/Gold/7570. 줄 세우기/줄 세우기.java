import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N + 1];
		int[] dp = new int[N + 1];
		StringTokenizer st = new StringTokenizer(br.readLine());

		// +1로 증가하는 최장수열을 고정하고 나머지 숫자들을 앞,뒤로 움직이면 최소한의 이동으로 정렬할 수 있다.
		int max = 0;
		for (int i = 0; i < N; i++) {
			int input = Integer.parseInt(st.nextToken());
			// +1씩 증가하는 수열을 찾아야하므로 바로 앞의 수열에 +1로 구한다.
			arr[input] = arr[input - 1] + 1;
			max = Math.max(max, arr[input]);
		}

		bw.write(String.valueOf(N - max));
		bw.flush();
	}
}
