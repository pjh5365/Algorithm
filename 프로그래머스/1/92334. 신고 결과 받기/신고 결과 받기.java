import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        HashMap<String, Set<String>> m1 = new HashMap<>(); // 회원의 신고내역
        HashMap<String, Integer> m2 = new HashMap<>(); // 신고당한 회원의 누적신고수

        for (String s : report) {
            StringTokenizer st = new StringTokenizer(s);
            String a = st.nextToken();
            String b = st.nextToken();

            if (m1.get(a) == null) {
                m1.put(a, new HashSet<>());
            }
            if (!m1.get(a).contains(b)) { // a가 b를 신고한적이 없을때만
                m1.get(a).add(b); // a가 b를 신고함 추가
                m2.put(b, m2.getOrDefault(b, 0) + 1); // b의 누적신고 추가
            }
        }

        int[] ret = new int[id_list.length];
        int idx = 0;

        for (String key : id_list) {
            Set<String> s = m1.get(key);
            if (s == null) {
                ret[idx++] = 0;
                continue;
            }
            int cnt = 0;
            for (String str : s) {
                if (m2.get(str) >= k) {
                    cnt++;
                }
            }
            ret[idx++] = cnt;
        }

        return ret;
    }
}