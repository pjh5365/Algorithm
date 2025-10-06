import java.util.*;

class Solution {
    public String solution(String p) {
        return dfs(p);
    }
    
    static String dfs(String p) {
        if (p.length() == 0) {
            return "";
        }
        int idx1 = 0;
        int idx2 = 0;
        int subIdx = 0;
        for (int i = 0; i < p.length(); i++) {
            char now = p.charAt(i);
            if (now == '(') {
                idx1++;
            } else {
                idx2++;
            }
            
            if (idx1 == idx2) {
                subIdx = i;
                break;
            }
        }
        String u = p.substring(0, subIdx + 1);
        String v = p.substring(subIdx + 1, p.length());
        
        // u 가 올바른 문자열인지 검사
        Stack<Character> s = new Stack<>();
        boolean flag = true;
        for (int i = 0; i < u.length(); i++) {
            if (u.charAt(i) == '(') {
                s.push('(');
            } else {
                if (!s.isEmpty()) {
                    s.pop();
                } else { // 올바르지 않은 문자열
                    flag = false;
                }
            }
        }
        
        if (flag) { // u가 올바른 문자열이라면
            return u + dfs(v);
        } else { // 올바르지 않은 문자열이라면
            String tmp = u.substring(1, u.length() - 1);
            String newU = "";
            for (int i = 0; i < tmp.length(); i++) { // 반대로 붙이기
                if (tmp.charAt(i) == '(') {
                    newU += ")";
                } else {
                    newU += "(";
                }
                
            }
            return "(" + dfs(v) + ")" + newU;
        }
    }
}
