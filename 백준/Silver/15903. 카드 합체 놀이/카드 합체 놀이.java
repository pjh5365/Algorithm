import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		Queue<Long> q = new PriorityQueue<>();
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			q.add(Long.parseLong(st.nextToken()));
		}

		for (int i = 0; i < M; i++) {
			long a = q.poll();
			long b = q.poll();
			long sum = a + b;
			q.add(sum);
			q.add(sum);
		}

		long result = 0;
		while (!q.isEmpty()) {
			result += q.poll();
		}

		bw.write(String.valueOf(result));
		bw.flush();
	}
}
