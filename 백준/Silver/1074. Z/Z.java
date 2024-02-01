import java.io.*;
import java.util.*;

public class Main {

	static int count = 0;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		z(r, c, (int)Math.pow(2, N));
		bw.write(String.valueOf(count));
		bw.flush();

	}

	static void z(int r, int c, int N) {
		if (N == 1)
			return;

		N /= 2;
		if (r < N && c < N) // 좌상단
			z(r, c, N);
		else if (r < N && c >= N) { // 우상단
			count += (int) Math.pow((N * 2), 2) / 4;
			z(r, c - N, N); // 우상단을 탐색하므로 c - N
		} else if (r >= N && c < N) { // 좌하단
			count += (int) Math.pow((N * 2), 2) / 4 * 2;
			z(r - N, c, N); // 좌하단을 탐색하므로 r - N
		} else { // 우하단 (r >= N && c >= N)
			count += (int) Math.pow((N * 2), 2) / 4 * 3;
			z(r - N, c - N, N); //우하단을 탐색하므로 r - N, c - N
		}
	}
}
