import java.util.*;

class Solution {
    public int solution(int[] citations) {
        Arrays.sort(citations);
        int h = 0;
        int size = citations.length;
        while (h <= size) {
            int count = 0;
            for (int i = 0; i < size; i++) {
                if (citations[i] >= h) {
                    count++;
                }
            }
            System.out.println(count + " h = " + h);
            if (count < h) {
                break;
            }
            h++;
        }
        return h - 1;
    }
}