import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		Stack<Character> s = new Stack<>();
		String input = br.readLine();
		for (int i = 0; i < input.length(); i++) {
			if (input.charAt(i) == '<') {
				while (!s.empty()) {
					sb.append(s.pop());
				}
				while (input.charAt(i) != '>') {
					sb.append(input.charAt(i));
					i++;
				}
				sb.append(input.charAt(i));
			} else {
				if (input.charAt(i) != ' ') {
					s.push(input.charAt(i));
				} else {
					while (!s.empty()) {
						sb.append(s.pop());
					}
					sb.append(" ");
				}
			}
		}
		while (!s.empty()) {
			sb.append(s.pop());
		}

		bw.write(String.valueOf(sb));
		bw.flush();
	}
}
