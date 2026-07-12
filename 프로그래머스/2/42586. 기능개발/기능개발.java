import java.util.*;

class Solution {
    public int[] solution(int[] p, int[] speeds) {
        Queue<Integer> q1 = new ArrayDeque<>();
        Queue<Integer> q2 = new ArrayDeque<>();
        
        for (int i = 0; i < p.length; i++) {
            q1.add(p[i]);
            q2.add(speeds[i]);
        }
        
        ArrayList<Integer> ret = new ArrayList<>();
        int cnt = 0;
        
        for (int i = 1; i <= 100; i++) {
            cnt = 0;
            while (!q1.isEmpty() && q1.peek() + q2.peek() * i >= 100) {
                cnt++;
                q1.poll();
                q2.poll();
            }
            if (cnt != 0) {
                ret.add(cnt);
            }
        }
        return ret.stream().mapToInt(Integer::intValue).toArray();
    }
}