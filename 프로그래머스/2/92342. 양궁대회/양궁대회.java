import java.util.*;

class Solution {
    static int[] lion = new int[11];
    static int[] ret = {-1};
    static int max = 0;
    public int[] solution(int n, int[] info) {
        dfs(0, n, info);
        return ret;
    }
    
    static void dfs(int depth, int n, int[] info) {
        if (n == depth) {
            int a = 0;
            int b = 0;
            for (int i = 0; i < 11; i++) {
                if(info[i] == 0 && lion[i] == 0) {
                    continue;
                }
                if (info[i] >= lion[i]) {
                    a += 10 - i;
                } else {
                    b += 10 - i;
                }
            }
            int tmp = b - a;
            if (tmp <= 0) {
                return;
            }
            if (max <= tmp) {
                ret = lion.clone();
                max = tmp;
            }
            return;
        }
        
        for (int i = 0; i <= 10 && lion[i] <= info[i]; i++) {
            lion[i]++;
            dfs(depth + 1, n, info);
            lion[i]--;
        }
    }
}
