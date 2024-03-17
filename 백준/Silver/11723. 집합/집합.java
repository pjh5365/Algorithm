import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		Set<Integer> set = new HashSet<>();

		while (N > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String s = st.nextToken();

			if (s.equals("add")) {
				int x = Integer.parseInt(st.nextToken());
				set.add(x);
			} else if (s.equals("check")) {
				int x = Integer.parseInt(st.nextToken());
				if (set.contains(x)) {
					sb.append("1").append("\n");
				} else {
					sb.append("0").append("\n");
				}
			} else if (s.equals("remove")) {
				int x = Integer.parseInt(st.nextToken());
				set.remove(x);
			} else if (s.equals("toggle")) {
				int x = Integer.parseInt(st.nextToken());
				if (set.contains(x)) {
					set.remove(x);
				} else {
					set.add(x);
				}
			} else if (s.equals("all")) {
				set.clear();
				for (int i = 1; i <= 20; i++) {
					set.add(i);
				}
			} else if (s.equals("empty")) {
				set.clear();
			}

			N--;
		}

		bw.write(String.valueOf(sb));
		bw.flush();
	}
}
