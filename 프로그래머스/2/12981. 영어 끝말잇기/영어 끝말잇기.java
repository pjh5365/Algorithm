import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        HashSet<String> s = new HashSet<>();
        
        int[] ret = {0, 0};
        int cnt = 0;
        int turn = 1;
        int idx = 1;
        boolean flag = false;
        String before = words[0].charAt(0) + "";
        for (String word : words) {
            if (s.contains(word) || before.charAt(before.length() - 1) != word.charAt(0)) {
                flag = true;
                break;
            }
            s.add(word);
            cnt++;
            idx++;
            if (cnt % n == 0) {
                idx = 1;
                turn++;
            }
            before = word;
        }
        
        if (flag) {
            ret[0] = idx;
            ret[1] = turn;
        }

        return ret;
    }
}