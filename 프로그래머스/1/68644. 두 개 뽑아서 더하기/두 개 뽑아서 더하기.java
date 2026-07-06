import java.util.*;

class Solution {
    public int[] solution(int[] n) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < n.length; i++) {
            for (int j = 0; j < n.length; j++) {
                if (i == j) continue;
                list.add(n[i] + n[j]);
            }
        }
        return list.stream().sorted().distinct().mapToInt(Integer::intValue).toArray();
    }
}