import java.util.*;

class Solution {
    public int solution(int n, int a, int b) {
        int ret = 0;

        while (a != b) {
            a = (a + 1) / 2;
            b = (b + 1) / 2;
            ret++;
        }

        return ret;
    }
}