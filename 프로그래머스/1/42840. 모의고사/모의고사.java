import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int[] one = {1, 2, 3, 4, 5};
        int[] two = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] three = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        
        int result1 = 0;
        int result2 = 0;
        int result3 = 0;
        
        int index1 = 0;
        int index2 = 0;
        int index3 = 0;
        
        for (int i : answers) {
            if (one[index1] == i) {
                result1++;
            }
            if (two[index2] == i) {
                result2++;
            }
            if (three[index3] == i) {
                result3++;
            }
            index1++;
            index1 %= 5;
            index2++;
            index2 %= 8;
            index3++;
            index3 %= 10;
        }
        int max = Math.max(result1, Math.max(result2, result3));
        ArrayList<Integer> list = new ArrayList<>();
        if (max == result1)
            list.add(1);
        if (max == result2)
            list.add(2);
        if (max == result3)
            list.add(3);
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }
}