import java.util.*;

class Solution {
    boolean solution(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char now = s.charAt(i);
            if (stack.isEmpty()) {
                stack.push(now);
                continue;
            }
            if (now == ')' && stack.peek() == '(') {
                stack.pop();
                continue;
            } else {
                stack.push(now);
            }
        }

        return stack.isEmpty();
    }
}