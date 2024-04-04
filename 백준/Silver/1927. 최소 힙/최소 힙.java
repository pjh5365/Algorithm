import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());
		Queue<Long> q = new PriorityQueue<>();

		int heapSize = 0;
		for (int i = 0; i < N; i++) {
			long now = Long.parseLong(br.readLine());
			if (now == 0) {
				if (heapSize == 0) {
					sb.append("0").append("\n");
					continue;
				}
				long poll = q.poll();
				sb.append(poll).append("\n");
				heapSize--;
				continue;
			}
			q.add(now);
			heapSize++;
		}

		bw.write(String.valueOf(sb));
		bw.flush();
	}
}
