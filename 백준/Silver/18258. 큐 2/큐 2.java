import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());

		Queue<Integer> queue = new LinkedList<>();
		int back = 0;
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String operation = st.nextToken();
			if (operation.equals("push")) {
				back = Integer.parseInt(st.nextToken());
				queue.add(back);
			} else if (operation.equals("front")) {
				if (queue.isEmpty()) {
					sb.append("-1").append("\n");
				} else {
					sb.append(queue.peek()).append("\n");
				}
			} else if (operation.equals("back")) {
				if (queue.isEmpty()) {
					sb.append("-1").append("\n");
				} else {
					sb.append(back).append("\n");
				}
			} else if (operation.equals("size")) {
				sb.append(queue.size()).append("\n");
			} else if (operation.equals("empty")) {
				if (queue.isEmpty()) {
					sb.append("1").append("\n");
				} else {
					sb.append("0").append("\n");
				}
			} else if (operation.equals("pop")) {
				if (queue.isEmpty()) {
					sb.append("-1").append("\n");
				} else {
					sb.append(queue.poll()).append("\n");
				}
			}

		}

		bw.write(String.valueOf(sb));
		bw.flush();
	}
}
