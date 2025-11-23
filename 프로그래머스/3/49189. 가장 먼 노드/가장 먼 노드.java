import java.util.*;

class Solution {  
    
    
    
    public int solution(int n, int[][] edge) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        boolean[] visited = new boolean[n + 1];
        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }
        
        for (int[] a : edge) {
            list.get(a[0]).add(a[1]);
            list.get(a[1]).add(a[0]);
        }
        
        Queue<Pair> q = new ArrayDeque<>();
        q.add(new Pair(1, 0));
        
        int max = 0;
        int ret = 0;
        
        visited[1] = true;
        while (!q.isEmpty()) {
            Pair get = q.poll();
            ArrayList<Integer> l = list.get(get.now);
            if (max < get.depth) {
                max = get.depth;
                ret = 1;
            } else if (max == get.depth) {
                ret++;
            }
             
            for (int i : l) {
                if (!visited[i]) {
                    visited[i] = true;
                    q.add(new Pair(i, get.depth + 1));
                }
            }
        }
        
        return ret;
    }
    
    static class Pair {
        int now;
        int depth;
        
        public Pair(int now, int depth) {
            this.now = now;
            this.depth = depth;
        }
    }
}