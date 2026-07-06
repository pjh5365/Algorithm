import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int[][] pattern = {
            {1, 2, 3, 4, 5},
            {2, 1, 2, 3, 2, 4, 2, 5},
            {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}
        };
        
        int[] sum = {0, 0, 0};
    
        
        for (int i = 0; i < answers.length; i++) {
            for (int j = 0; j < 3; j++) {
                if (answers[i] == pattern[j][i % pattern[j].length]) {
                    sum[j]++;
                }
            }
        }
        
        int maxScore = Arrays.stream(sum).max().getAsInt();
        
        ArrayList<Integer> list = new ArrayList<>();
        
        for (int i = 0; i < 3; i++) {
            if (maxScore == sum[i]) {
                list.add(i + 1);
            }
        }
        
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}