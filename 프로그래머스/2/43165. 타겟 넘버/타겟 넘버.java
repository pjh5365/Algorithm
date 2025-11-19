import java.util.*;

class Solution {
    static int ret = 0;
    public int solution(int[] numbers, int target) {
        dfs(0, 0, target, numbers);
        return ret;
    }
    
    static void dfs(int sum, int depth, int target, int[] arr) {
        if (depth == arr.length) {
            if (sum == target) {
                ret++;
            }
            return;
        }
        
        dfs(sum + arr[depth], depth + 1, target, arr);
        dfs(sum - arr[depth], depth + 1, target, arr);
    }
}