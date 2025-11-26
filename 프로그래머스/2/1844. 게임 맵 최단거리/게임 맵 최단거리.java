import java.util.*;

class Solution {
    
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static int n;
    static int m;
    
    public int solution(int[][] maps) {
        n = maps.length;
        m = maps[0].length;
        
        int[][] visited = new int[n][m];
        
        Queue<Pair> q = new ArrayDeque<>();
        q.add(new Pair(0, 0));
        visited[0][0] = 1;
        while (!q.isEmpty()) {
            Pair now = q.poll();
            
            for (int i = 0; i < 4; i++) {
                int x = now.x + dx[i];
                int y = now.y + dy[i];
                
                if (x < 0 || x > n - 1 || y < 0 || y > m - 1) {
                    continue;
                }
                
                if (maps[x][y] == 1 && visited[x][y] == 0) {
                    visited[x][y] = visited[now.x][now.y] + 1;
                    q.add(new Pair(x, y));
                }
            }
        }
        
        return visited[n - 1][m - 1] == 0 ? -1 : visited[n - 1][m - 1];
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