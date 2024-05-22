import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringBuilder sb = new StringBuilder();

		String input = br.readLine();
		Stack<Character> operator = new Stack<>();

		for (int i = 0; i < input.length(); i++) {
			char now = input.charAt(i);
			if (now <= 'Z' && now >= 'A') {
				sb.append(now);
			} else {
				if (now == '(') {
					operator.push(now);
				} else if (now == ')') {
					while (operator.peek() != '(') {
						sb.append(operator.pop());
					}
					operator.pop(); // '(' 제거
				} else if (now == '*' || now == '/') {
					while (!operator.empty() && (operator.peek() == '*' || operator.peek() == '/')) { // 우선순위가 같은 연산자들 꺼내기
						sb.append(operator.pop());
					}
					operator.push(now);
				} else {
					while (!operator.empty() && operator.peek() != '(') { // 우선순위가 같은 연산자들 꺼내기
						sb.append(operator.pop());
					}
					operator.push(now);
				}
			}
		}
		while (!operator.empty()) {
			sb.append(operator.pop());
		}

		bw.write(String.valueOf(sb));
		bw.flush();
	}
}
