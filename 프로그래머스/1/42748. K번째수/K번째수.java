import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] result = new int[commands.length];
        for (int i = 0; i < commands.length; i++) {
            int[] tmp = array.clone();
            Arrays.sort(tmp, commands[i][0] - 1, commands[i][1]);
            result[i] = tmp[commands[i][0] + commands[i][2] - 2];
        }
        
        return result;
    }
}