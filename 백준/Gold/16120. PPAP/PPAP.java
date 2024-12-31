import java.io.*;
import java.util.*;

public class Main {
	/**
	 * BOJ 16120번
	 * 스택을 사용해서 앞에서부터 스택에 문자를 입력한 후 스택의 값이 PPAP의 반대인 PAPP를 나타낸다면 P로 변환하여 다시 넣는다.
	 * 해당 과정을 반복해서 P만 남아있을때 PPAP문자열이다.
	 */
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String s = br.readLine();

		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < s.length(); i++) {
			stack.push(s.charAt(i));

			if (stack.size() >= 4) {
				String tmp = "";
				for (int j = 0; j < 4; j++) {
					tmp += stack.pop();
				}
				if (tmp.equals("PAPP")) { // PPAP라면
					stack.push('P');
				} else {
					for (int j = 3; j >= 0; j--) {
						stack.push(tmp.charAt(j));
					}
				}
			}
		}

		if (stack.size() == 1 && stack.peek() == 'P') {
			bw.write("PPAP");
		} else {
			bw.write("NP");
		}
		bw.flush();
	}
}
