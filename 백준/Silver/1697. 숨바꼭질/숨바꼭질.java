import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int[] x = new int[100001];
		Queue<Integer> q = new LinkedList<>();

		q.add(N);
		x[N] = 0;
		while (!q.isEmpty()) {
			int poll = q.poll();
			if (poll == K) {
				break;
			}
			if (poll + 1 <= 100000 && x[poll + 1] == 0) {
				x[poll + 1] = x[poll] + 1;
				q.add(poll + 1);
			}
			if (poll - 1 >= 0 && x[poll - 1] == 0) {
				x[poll - 1] = x[poll] + 1;
				q.add(poll - 1);
			}
			if (poll * 2 <= 100000 && x[poll * 2] == 0) {
				x[poll * 2] = x[poll] + 1;
				q.add(poll * 2);
			}
		}

		bw.write(String.valueOf(x[K]));
		bw.flush();
	}
}
