import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        
        ArrayDeque<Integer> q = new ArrayDeque<>();
        for (int i : arr) {
            if (q.isEmpty()) {
                q.add(i);
            } else {
                if (q.peekLast() == i) {
                    continue;
                } else {
                    q.add(i);
                }
            }
        }
        
        int[] ret = new int[q.size()];
        int idx = 0;
        while (!q.isEmpty()) {
            ret[idx] = q.poll();
            idx++;
        }
        
        return ret;
    }
}