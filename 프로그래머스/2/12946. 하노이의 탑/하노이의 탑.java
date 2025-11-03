import java.util.*;

class Solution {
    static List<int[]> list = new ArrayList<>();
    public int[][] solution(int n) {
        hanoi(1, 2, 3, n);
        int[][] answer = new int[list.size()][];
            for (int i = 0; i < list.size(); i++) {
                answer[i] = new int[2];
                answer[i][0] = list.get(i)[0];
                answer[i][1] = list.get(i)[1];
            }
        return answer;
    }
    
    static void hanoi(int from, int mid, int to, int n) {
        if (n == 1) {
            int[] tmp = {from, to};
            list.add(tmp);
            return;
        }
        hanoi(from, to, mid, n - 1);
        int[] tmp = {from, to};
        list.add(tmp);
        hanoi(mid, from, to, n - 1);
        return;
    }
}