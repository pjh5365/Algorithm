import java.util.*;

class Solution {
    static boolean[] visited;
    static int[] arr;
    static int ret = 0;
    public int solution(int k, int[][] d) {
        int len = d.length;
        visited = new boolean[len];
        arr = new int[len];
        dfs(len, 0, d, k);
        return ret;
    }
    
    static void dfs(int n, int depth, int[][] d, int k) {
        if (depth == n) {
            int cnt = 0;
            int tmp = k;
            for (int i = 0; i < n; i++) {
                int tmp1 = d[arr[i]][0];
                int tmp2 = d[arr[i]][1];
                
                if (tmp >= tmp1) {
                    tmp -= tmp2;
                    cnt++;
                }
            }
            ret = Math.max(ret, cnt);
            return;
        }
        
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                arr[depth] = i;
                dfs(n, depth + 1, d, k);
                visited[i] = false;
            }
        }
    }
}
