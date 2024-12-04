import java.util.*;

class Solution {
    public int solution(String s) {
        int ret = 0;
        StringBuilder sb = new StringBuilder(s);
        for (int i = 0; i < s.length(); i++) {
            sb.append(sb.substring(0, 1));
            sb.delete(0, 1);
            if (check(sb.toString())) {
                ret++;
            }
        }
        return ret;
    }
    static boolean check(String s) {
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < s.length(); i++) {
			char now = s.charAt(i);

			if (now == '(' || now == '[' || now == '{') {
				stack.push(now);
			} else {
				if (stack.isEmpty()) {
					return false;
				}

				if (now == ')') {
					if (stack.peek() == '(') {
						stack.pop();
					} else {
						return false;
					}
				} else if (now == ']') {
					if (stack.peek() == '[') {
						stack.pop();
					} else {
						return false;
					}
				} else if (now == '}') {
					if (stack.peek() == '{') {
						stack.pop();
					} else {
						return false;
					}
				}
			}
		}
		return stack.isEmpty();
	}
}