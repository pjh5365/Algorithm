import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());

		Queue<Integer> q = new LinkedList<>();
		int b = 0;
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String a = st.nextToken();

			if (a.equals("push")) {
				b = Integer.parseInt(st.nextToken());
				q.add(b);
			} else if (a.equals("pop")) {
				if (q.isEmpty()) {
					sb.append("-1").append("\n");
				} else {
					sb.append(q.poll()).append("\n");
				}
			} else if (a.equals("size")) {
				sb.append(q.size()).append("\n");
			} else if (a.equals("empty")) {
				if (q.isEmpty()) {
					sb.append("1").append("\n");
				} else {
					sb.append("0").append("\n");
				}
			} else if (a.equals("front")) {
				if (q.isEmpty()) {
					sb.append("-1").append("\n");
				} else {
					sb.append(q.peek()).append("\n");
				}
			} else {
				if (q.isEmpty()) {
					sb.append("-1").append("\n");
				} else {
					sb.append(b).append("\n");
				}
			}
		}

		bw.write(String.valueOf(sb));
		bw.newLine();
		bw.flush();
	}
}
