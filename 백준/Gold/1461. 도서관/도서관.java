import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int ret = 0;
		int max = 0;

		PriorityQueue<Integer> plus = new PriorityQueue<>(Collections.reverseOrder());
		PriorityQueue<Integer> minus = new PriorityQueue<>(Collections.reverseOrder());

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int tmp = Integer.parseInt(st.nextToken());
			max = Math.max(max, Math.abs(tmp));

			if (tmp < 0) {
				minus.add(-tmp);
			} else {
				plus.add(tmp);
			}
		}

		while (!minus.isEmpty()) {
			int tmp = minus.poll();
			for (int i = 0; i < M - 1; i++) {
				minus.poll();

				if (minus.isEmpty()) {
					break;
				}
			}
			ret += tmp * 2;
		}

		while (!plus.isEmpty()) {
			int tmp = plus.poll();
			for (int i = 0; i < M - 1; i++) {
				plus.poll();

				if (plus.isEmpty()) {
					break;
				}
			}
			ret += tmp * 2;
		}

		ret -= max;

		bw.write(String.valueOf(ret));
		bw.flush();
	}
}
