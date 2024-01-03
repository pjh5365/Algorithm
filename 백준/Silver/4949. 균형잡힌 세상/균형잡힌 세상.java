import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		while (true) {
			String input = br.readLine();
			if (input.equals(".")) {
				break;
			}
			Stack<Character> s = new Stack<>();
			Boolean No = false;
			for (int i = 0; i < input.length(); i++) {
				if (input.charAt(i) == '(' || input.charAt(i) == '[') {
					s.push(input.charAt(i));
				} else if (input.charAt(i) == ')') {
					if (!s.isEmpty() && s.peek() == '(') {
						s.pop();
					} else {
						s.clear();
						No = true;
						break;
					}
				} else if (input.charAt(i) == ']') {
					if (!s.isEmpty() && s.peek() == '[') {
						s.pop();
					} else {
						s.clear();
						No = true;
						break;
					}
				}
			}
			if (s.isEmpty() && !No) {
				sb.append("yes").append("\n");
			} else {
				sb.append("no").append("\n");
			}
		}

		bw.write(String.valueOf(sb));
		bw.flush();
	}
}
