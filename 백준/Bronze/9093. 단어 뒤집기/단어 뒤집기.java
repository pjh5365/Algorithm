import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		Stack<Character> s = new Stack<>();
		int T = Integer.parseInt(br.readLine());

		while (T > 0) {
			String input = br.readLine();

			char now;
			for (int i = 0; i < input.length(); i++) {
				if (input.charAt(i) != ' ') {
					s.push(input.charAt(i));
				} else {
					while (!s.empty()) {
						sb.append(s.pop());
					}
					sb.append(" ");
				}
			}
			while (!s.empty()) {
				sb.append(s.pop());
			}
			sb.append("\n");
			T--;
		}

		bw.write(String.valueOf(sb));
		bw.flush();
	}
}
