import java.io.*;
import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        Arrays.sort(times);
        long l = times[0];
        long r = (long)times[times.length-1]*(long)n;
        long answer = Long.MAX_VALUE;
        
        while (l <= r) {
            long mid = (l + r) / 2;
            long tmp = 0;
            for (int i : times) {
                tmp += mid / i;
            }
            if (tmp >= n) {
                answer = Math.min(answer, mid);
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return answer;
    }
}