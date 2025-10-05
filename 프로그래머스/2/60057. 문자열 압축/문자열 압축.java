import java.util.*;

class Solution {
    public int solution(String s) {
        int ret = s.length();
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= (s.length() / 2); i++) { // S의 절반 길이가 최대 압축
            int tmp = s.length();
            String before = "";
            for (int j = 0; j < s.length() - i; j += i) {
                String now = s.substring(j, j + i);
                if (before.equals(now)) { // 이미 압축한 문자열이라면 건너뛰기
                    continue;
                }
                int cnt = 1;
                for (int k = j + i; k <= s.length() - i; k += i) {
                    if (s.substring(k, k + i).equals(now)) {
                        cnt++;
                    } else {
                        break;
                    }
                }
                if (cnt > 1) { // 1개 이상 반복된다면
                    tmp -= cnt * i; // 반복되는만큼 제거
                    tmp += String.valueOf(cnt).length(); // 반복되는 숫자의 자리수 더하기
                    tmp += i; // 기본 자리수 더하기
                }
                cnt = 0;
                before = now;
            }
            ret = Math.min(tmp, ret);
        }
        return ret;
    }
}