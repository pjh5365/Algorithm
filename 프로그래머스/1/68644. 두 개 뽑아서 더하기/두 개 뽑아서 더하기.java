import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        Set<Integer> s = new HashSet<>();
        
        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < numbers.length; j++) {
                if (i == j) {
                    continue;
                }
                s.add(numbers[i] + numbers[j]);
            }
        }
        int[] ret = new int[s.size()];
        int idx = 0;
        for (int i : s) {
            ret[idx++] = i;
        }
        // for (int i = 0; i < s.size(); i++) {
        //     ret[i] = s.get(i);
        // }
        Arrays.sort(ret);
        return ret;
    }
}