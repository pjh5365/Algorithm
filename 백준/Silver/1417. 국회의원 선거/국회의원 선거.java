import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
		int dasom = Integer.parseInt(br.readLine());
		int ret = 0;
		for (int i = 1; i < N; i++) {
			q.add(Integer.valueOf(br.readLine()));
		}
		while (!q.isEmpty() && dasom <= q.peek()) {
			int get = q.poll();
			get--;
			dasom++;
			ret++;
			q.add(get);
		}

		bw.write(String.valueOf(ret));
		bw.flush();
	}
}
