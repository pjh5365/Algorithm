import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int cnt = 0;
		while (true) {
			String s = br.readLine();
			cnt++;
			if (s.contains("-")) {
				break;
			}
			Stack<Character> stack = new Stack<>();
			int ret = 0;

			for (int i = 0; i < s.length(); i++) {
				char now = s.charAt(i);
				if (now == '{') {
					stack.push(now);
				} else {
					if (stack.isEmpty()) {
						ret++;
						stack.push('{');
					} else {
						stack.pop();
					}
				}
			}
			sb.append(cnt).append(". ").append(ret + stack.size() / 2).append("\n");
		}

		bw.write(String.valueOf(sb));
		bw.flush();
	}
}
