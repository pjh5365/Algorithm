import java.util.*;

class Solution {
    static int ret = 0;
    
    public int solution(int n) {
        make("", n, 0, 0);
        return ret;
    }
    
    static void make(String s, int n, int cnt1, int cnt2) { // 모든 괄호 문자열 생성
        if (cnt1 > n || cnt2 > n) { // 올바른 괄호 문자열이 아니라면 바로 종료
            return;
        }
        
        if (s.length() == n * 2) {
            check(s);
            return;
        }
        make(s + "(", n, cnt1 + 1, cnt2);
        make(s + ")", n, cnt1, cnt2 + 1);
    }
    
    static void check(String s) { // 괄호 문자열 확인
        Stack<Integer> stack = new Stack<>();
        
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(1);
            } else {
                if (stack.isEmpty()) { // 스택이 비어있다면 올바른 괄호쌍이 아님
                    return;
                }
                stack.pop();
            }
        }
        if (stack.isEmpty()) { // 모든 탐색 후 스택이 비어있다면 올바른 괄호쌍
            ret++;
        }
    }
}