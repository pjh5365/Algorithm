import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		Queue<Integer> q = new LinkedList<>();
		int n = Integer.parseInt(br.readLine());
		int max = 0;
		int ret = n;
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			if (a == 1) {
				int b = Integer.parseInt(st.nextToken());
				q.add(b);
				if (q.size() > max) {
					max = q.size();
					ret = b;
				} else if (q.size() == max) {
					ret = Math.min(ret, b);
				}
			} else {
				q.poll();
			}
		}
		sb.append(max).append(" ").append(ret).append("\n");

		bw.write(String.valueOf(sb));
		bw.flush();
	}
}
