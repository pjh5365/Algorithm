import java.util.*;

class Solution {
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    
    public int solution(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;
        boolean[][] v = new boolean[n][m];
        
        Queue<Pair> q = new ArrayDeque<>();
        q.add(new Pair(0, 0));
        v[0][0] = true;
        
        while (!q.isEmpty()) {
            Pair now = q.poll();
            
            for (int i = 0; i < 4; i++) {
                int x = now.x + dx[i];
                int y = now.y + dy[i];
                
                if (x < 0 || x >= n || y < 0 || y >= m) {
                    continue;
                }
                
                if (!v[x][y] && maps[x][y] != 0) {
                    q.add(new Pair(x, y));
                    v[x][y] = true;
                    maps[x][y] = maps[now.x][now.y] + 1;
                }
            }
        }
        
        return maps[n - 1][m - 1] == 1 ? -1 : maps[n - 1][m - 1];
    }
    
    static class Pair {
        int x;
        int y;
        
        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}