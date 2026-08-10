import java.util.*;

class Solution {
    static ArrayList<ArrayList<Integer>> tree;
    static boolean[] visited;
    public int solution(int n, int[][] wires) {
        int ret = (int)1e9;
        for (int idx = 0; idx < wires.length; idx++) {
            tree = new ArrayList<>();
            for (int i = 0; i <= n; i++) {
                tree.add(new ArrayList<>());
            }
            visited = new boolean[n + 1];

            for (int i = 0; i < wires.length; i++) {
                if (i == idx) continue;
                tree.get(wires[i][0]).add(wires[i][1]);
                tree.get(wires[i][1]).add(wires[i][0]);
            }

            int ret1 = 0;
            int ret2 = 0;
            for (int i = 1; i <= n; i++) {
                if (!visited[i]) {
                    if (ret1 == 0) {
                        ret1 = dfs(i) + 1;
                    } else {
                        ret2 = dfs(i) + 1;
                    }
                }
            }
            ret = Math.min(ret, Math.abs(ret1 - ret2));
        }
        
        return ret;
    }
    
    static int dfs(int now) {
        if (visited[now]) {
            return 1;
        }
        int cnt = 0;
        visited[now] = true;
        for (int i : tree.get(now)) {
            cnt += dfs(i);
        }
        return cnt;
    }
}