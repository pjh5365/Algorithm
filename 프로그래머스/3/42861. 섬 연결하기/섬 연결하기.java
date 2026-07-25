import java.util.*;

class Solution {
    static int[] parent;
    public int solution(int n, int[][] costs) {
        Arrays.sort(costs, (o1, o2) -> Integer.compare(o1[2], o2[2]));
        
        parent = new int[n];
        
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        
        int ret = 0;
        int cnt = 0;
        
        for (int[] cost : costs) {
            if (cnt == n - 1) {
                break;
            }
            
            if (find(cost[0]) != find(cost[1])) { // 두 섬이 연결되어있지 않다면
                union(cost[0], cost[1]);
                
                ret += cost[2];
                cnt++;
            }
        }
        
        return ret;
    }
    
    static int find(int x) {
        if (x == parent[x]) {
            return x;
        }
        
        return parent[x] = find(parent[x]);
    }
    
    static void union(int x, int y) {
        int r1 = find(x);
        int r2 = find(y);
        parent[r2] = r1;
    }
}