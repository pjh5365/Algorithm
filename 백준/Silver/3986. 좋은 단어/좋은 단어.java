import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		int result = 0;
		for (int i = 0; i < N; i++) {
			String input = br.readLine();
			Stack<Character> s = new Stack<>();
			if (input.length() % 2 != 0) {
				continue;
			}
			for (int j = 0; j < input.length(); j++) {
				if (!s.isEmpty() && s.peek() != input.charAt(j)) {
					s.push(input.charAt(j));
				} else if (!s.isEmpty() && s.peek() == input.charAt(j)) {
					s.pop();
				} else {
					s.push(input.charAt(j));
				}
			}
			if (s.isEmpty()) {
				result++;
			}
		}

		bw.write(String.valueOf(result));
		bw.flush();
	}
}
