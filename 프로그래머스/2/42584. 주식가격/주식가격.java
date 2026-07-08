import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int len = prices.length;
        int[] ret = new int[len];

        Stack<Integer> s = new Stack<>();
        s.push(0);
        for (int i = 1; i < len; i++) {
            while (!s.isEmpty() && prices[i] < prices[s.peek()]) {
                int idx = s.pop();
                ret[idx] = i - idx;
            }
            s.push(i);
        }
        
        while (!s.isEmpty()) {
            int idx = s.pop();
            ret[idx] = len - 1 - idx;
        }
        
        return ret;
    }
}
