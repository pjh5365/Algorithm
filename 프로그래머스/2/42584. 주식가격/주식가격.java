import java.util.*;

class Solution {
    /**
    * prices의 idx를 스택에 넣기?
    */
    public int[] solution(int[] prices) {
        Stack<Integer> s = new Stack<>(); // 가격을 담을 스택
        Stack<Integer> time = new Stack<>(); // 입력된 시간을 담을 스택
        int len = prices.length;
        int[] answer = new int[len];
        
        for (int i = 0; i < len; i++) {
            int now = prices[i];
            if (s.isEmpty()) {
                s.push(now);
                time.push(i);
            } else {
                if (s.peek() > now) {
                    while (!s.isEmpty() && s.peek() > now) {
                        s.pop();
                        int tmp = time.pop();
                        answer[tmp] = i - tmp;   
                    }
                    s.push(now);
                    time.push(i);
                } else {
                    s.push(now);
                    time.push(i);
                }
            }
        }
        while (!time.isEmpty()) {
            int tmp = time.pop();
            answer[tmp] = len - tmp - 1;
        }
        
        return answer;
    }
}