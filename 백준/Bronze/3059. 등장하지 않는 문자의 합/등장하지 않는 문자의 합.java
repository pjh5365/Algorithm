import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		int num = 0;
		for (int i = 'A'; i <= 'Z'; i++) {
			num += i;
		}
		while (T-- > 0) {
			Set<Character> set = new HashSet<>();
			int sum = num;
			String s = br.readLine();

			for (int i = 0; i < s.length(); i++) {
				char now = s.charAt(i);
				if (!set.contains(now)) {
					sum -= now;
					set.add(now);
				}
			}
			sb.append(sum).append("\n");
		}

		bw.write(String.valueOf(sb));
		bw.flush();
	}
}
