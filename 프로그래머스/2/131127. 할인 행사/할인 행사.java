import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        HashMap<String, Integer> map = new HashMap<>();
        HashMap<String, Integer> cnt = new HashMap<>();

        for (int i = 0; i < want.length; i++) {
            map.put(want[i], number[i]);
        }

        for (int i = 0; i < 10; i++) {
            cnt.put(discount[i], cnt.getOrDefault(discount[i], 0) + 1);
        }

        int ret = 0;

        for (int i = 10; i < discount.length; i++) {
            boolean flag = true;
            for (String s : want) {
                if (map.get(s) > cnt.getOrDefault(s, 0)) {
                    flag = false;
                }
            }
            if (flag) {
                ret++;
            }
            cnt.put(discount[i], cnt.getOrDefault(discount[i], 0) + 1);

            if (cnt.get(discount[i - 10]) > 0) {
                cnt.put(discount[i - 10], cnt.get(discount[i - 10]) - 1);
            } else {
                cnt.remove(discount[i - 10]);
            }
        }

        boolean flag = true;
        for (String s : want) {
            if (map.get(s) > cnt.getOrDefault(s, 0)) {
                flag = false;
            }
        }
        if (flag) {
            ret++;
        }

        return ret;
    }
}