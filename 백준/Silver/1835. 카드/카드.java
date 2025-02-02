import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		Deque<Integer> q = new ArrayDeque<>();

		int N = Integer.parseInt(br.readLine());
		for (int i = N; i > 0; i--) {
			q.addFirst(i);
			for (int j = 0; j < i; j++) {
				q.addFirst(q.pollLast());
			}
		}
		for (int i : q) {
			sb.append(i).append(" ");
		}

		bw.write(String.valueOf(sb));
		bw.flush();
	}
}
