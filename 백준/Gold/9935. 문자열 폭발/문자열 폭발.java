import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		String input = br.readLine();
		String bomb = br.readLine();

		Stack<Character> s1 = new Stack<>();
		Stack<Character> s2 = new Stack<>();

		for (int i = 0; i < input.length(); i++) {
			s1.add(input.charAt(i));
			if (s1.peek() == bomb.charAt(bomb.length() - 1)) {
				boolean isRemoved = true;
				for (int j = bomb.length() - 1; j >= 0; j--) {
					if (!s1.isEmpty() && s1.peek() == bomb.charAt(j)) {
						s2.add(s1.pop());
					} else {
						isRemoved = false;
						break;
					}
				}
				if (isRemoved) {
					s2.clear();
				} else {
					while (!s2.isEmpty()) {
						s1.add(s2.pop());
					}
				}
			}

		}

		if (s1.isEmpty()) {
			sb.append("FRULA");
		} else {
			while (!s1.isEmpty()) {
				s2.add(s1.pop());
			}
			while (!s2.isEmpty()) {
				sb.append(s2.pop());
			}
		}
		bw.write(String.valueOf(sb));
		bw.newLine();
		bw.flush();
	}
}
