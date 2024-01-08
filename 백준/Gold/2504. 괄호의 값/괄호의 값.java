import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String input = br.readLine();

		Stack<Character> s = new Stack<>();
		int result = 0;
		int product = 1;
		for (int i = 0; i < input.length(); i++) {
			char now = input.charAt(i);
			if (now == '(' || now == '[') {    // 여는 모양이라면 일단 스택에 넣기
				if (now == '(')
					product *= 2;
				else
					product *= 3;
				s.push(now);
			} else {    // 닫는 모양일 때
				if (s.isEmpty()) {
					result = 0;
					break;
				}
				if (now == ']') {
					if (s.peek() != '[') {
						result = 0;
						break;
					}
					if (input.charAt(i - 1) == '[') {
						result += product;
					}
					s.pop();
					product /= 3;
				} else {
					if (s.peek() != '(') {
						result = 0;
						break;
					}
					if (input.charAt(i - 1) == '(') {
						result += product;
					}
					s.pop();
					product /= 2;
				}
			}
		}
		if (!s.isEmpty()) {    // 연산 후 스택에 값이 남아 있다면 0
			result = 0;
		}

		bw.write(String.valueOf(result));
		bw.flush();
	}
}
