import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; i++) {
			String operation = br.readLine();
			int N = Integer.parseInt(br.readLine());
			boolean R = false;
			boolean error = false;
			StringTokenizer st = new StringTokenizer(br.readLine(), "[ , ]");
			LinkedList<Integer> deque = new LinkedList<>();
			while (st.hasMoreTokens()) {
				deque.addLast(Integer.valueOf(st.nextToken()));
			}
			for (int j = 0; j < operation.length(); j++) {
				char now = operation.charAt(j);
				if (now == 'R') {
					if (R) {
						R = false;
					} else {
						R = true;
					}
				} else {
					if (deque.isEmpty()) {
						sb.append("error").append("\n");
						error = true;
						break;
					} else {
						if (R) {
							deque.removeLast();
						} else {
							deque.removeFirst();
						}
					}
				}
			}
			if (!error) {
				if (!deque.isEmpty()) {
					if (R) {
						Collections.reverse(deque);
					}
					String line = deque.toString();
					line = line.replaceAll(" ", "");
					sb.append(line).append("\n");
				} else {
					sb.append("[]").append("\n");
				}
			}
		}

		bw.write(String.valueOf(sb));
		bw.flush();
	}
}
