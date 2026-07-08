import java.util.*;

class Solution {
    public int solution(String str) {
        Stack<Character> s = new Stack<>();
        
        for (int i = 0; i < str.length(); i++) {
            char now = str.charAt(i);
            if (s.isEmpty()) {
                s.push(now);
            } else if (s.peek() == now) {
                s.pop();
            } else {
                s.push(now);
            }
        }
        
        return s.isEmpty() ? 1 : 0;
    }
}