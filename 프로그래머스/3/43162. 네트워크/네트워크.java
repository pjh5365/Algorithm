import java.util.*;

class Solution {
    static boolean[] v;
    public int solution(int n, int[][] g) {
        v = new boolean[n];
        int ret = 0;
        for (int i = 0; i < n; i++) {
            if (!v[i]) {
                dfs(i, g);
                ret++;
            }
        }
        
        return ret;
    }
    
    static void dfs(int x, int[][] g) {
        v[x] = true;
        for (int i = 0; i < g.length; i++) {
            if (g[x][i] == 1 && !v[i]) {
                dfs(i, g);
            }
        }
    }
}