import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		while (T > 0) {

			StringTokenizer st = new StringTokenizer(br.readLine());

			int M = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			int max = M * N / gcd(M, N);
			int i = 0;
			int result = -1;
			while (i * M < max) { // 마지막해까지 반복
				int tmp = i * M + x; // x년을 먼저 찾고
				if ((tmp - y) % N == 0) { // 찾은 년도중에서 N의 배수로 y를 찾을 수 있다면
					result = tmp;
					break;
				}
				i++;
			}
			sb.append(result).append("\n");
			T--;
		}

		bw.write(String.valueOf(sb));
		bw.flush();
	}

	static int gcd(int x, int y) {
		if (x % y == 0) {
			return y;
		}
		return gcd(y, x % y);
	}
}
