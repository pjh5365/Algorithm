import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		String s = br.readLine();

		Stack<Character> stack = new Stack<>();
		int ret = 0;
		int cnt = 0;
		for (int i = 0; i < s.length(); i++) {
			char now = s.charAt(i);
			if (stack.isEmpty()) {
				stack.push(now);
				cnt++;
			} else {
				if (now == '(') {
					if (stack.peek() == ')') {
						stack.pop();
						cnt--;
					} else {
						stack.push(now);
						cnt++;
					}
				} else {
					if (stack.peek() == '(') {
						stack.pop();
						cnt--;
					} else {
						stack.push(now);
						cnt++;
					}
				}
			}
			ret = Math.max(cnt, ret);
		}
		if (!stack.isEmpty()) {
			ret = -1;
		}

		bw.write(String.valueOf(ret));
		bw.flush();
	}
}
