import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());

		Stack<Integer> s = new Stack<>();

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			if (a == 1) {
				int b = Integer.parseInt(st.nextToken());
				s.add(b);
			} else if (a == 2) {
				if (s.isEmpty()) {
					sb.append("-1").append("\n");
				} else {
					sb.append(s.pop()).append("\n");
				}
			} else if (a == 3) {
				sb.append(s.size()).append("\n");
			} else if (a == 4) {
				if (s.isEmpty()) {
					sb.append(1).append("\n");
				} else {
					sb.append(0).append("\n");
				}
			}else{
				if (s.isEmpty()) {
					sb.append("-1").append("\n");
				} else {
					sb.append(s.peek()).append("\n");
				}
			}
		}
		bw.write(String.valueOf(sb));
		bw.newLine();
		bw.flush();
	}
}
