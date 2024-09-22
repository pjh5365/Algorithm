import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		Queue<Integer> q = new LinkedList<>();
		for (int i = 1; i <= N; i++) {
			q.add(i);
		}

		sb.append("<");

		while (q.size() > 1) {
			for (int i = 0; i < K - 1; i++) {
				q.add(q.poll());
			}
			sb.append(q.poll()).append(", ");
		}
		sb.append(q.poll()).append(">");

		bw.write(String.valueOf(sb));
		bw.newLine();
		bw.flush();
	}
}
