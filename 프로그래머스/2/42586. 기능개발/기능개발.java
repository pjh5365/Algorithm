import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Stack<Integer> s = new Stack<>();
        ArrayList<Integer> list = new ArrayList<>();
        
        int len = progresses.length;
        
        for (int i = len - 1; i >= 0; i--) {
            s.push(i);
        }
        while (!s.isEmpty()) {
            for (int i = 0; i < len; i++) {
                progresses[i] += speeds[i];
            }
            int ret = 0;
            while (progresses[s.peek()] >= 100) {
                s.pop();
                ret++;
                if (s.isEmpty()) {
                    break;
                }
            }
            if (ret > 0) {
                list.add(ret);
            }
        }
        int[] arr = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            arr[i] = list.get(i);
        }
        return arr;
    }
}