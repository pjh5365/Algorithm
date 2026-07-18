import java.util.*;

class Solution {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        HashMap<String, Integer> m1 = new HashMap<>(); // 이름 -> 이익
        HashMap<String, String> m2 = new HashMap<>(); // 자식 -> 부모

        m1.put("center", 0);

        for (int i = 0; i < enroll.length; i++) {
            String name = enroll[i];
            String parent = referral[i];
            if (parent.equals("-")) {
                m1.put(name, 0);
                m2.put(name, "center");
            } else {
                m1.put(name, 0);
                m2.put(name, parent);
            }
        }

        for (int i = 0; i < seller.length; i++) {
            String name = seller[i];
            int money = amount[i] * 100;

            while (money > 0 && !name.equals("center")) {
                m1.put(name, m1.getOrDefault(name, 0) + money - (money / 10));
                name = m2.get(name);
                money /= 10;
            }
        }

        int[] ret = new int[enroll.length];

        for (int i = 0; i < ret.length; i++) {
            ret[i] = m1.get(enroll[i]);
        }

        return ret;
    }
}