import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> map = new HashMap<>();

        for (String s : participant) {
            map.put(s, map.get(s) == null ? 1 : map.get(s) + 1);
        }

        for (String s : completion) {
            if (map.get(s) == 1) {
                map.remove(s);
            } else {
                map.put(s, map.get(s) - 1);
            }
            
        }

        return map.keySet().stream().toList().get(0);
    }
}