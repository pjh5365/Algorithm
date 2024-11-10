import java.util.*;

class Solution {
    static int N;
    static int M;
    static int R;
    static int C;
    static int K;
    static int[] dx = {1, 0, 0, -1};
    static int[] dy = {0, -1, 1, 0};
    static char[] ds = {'d', 'l', 'r', 'u'};
    static StringBuilder sb = new StringBuilder();
    static String ret;
    
    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        N = n;
        M = m;
        R = r;
        C = c;
        K = k;
        
        int len = distance(x, y, r, c);
        if ((k - len) % 2 == 1 || k < len) {
            return "impossible";
        }
        dfs(x, y, 0);
        if (ret == null) {
            ret = "impossible";
        }
        return ret;
    }
    
    static int distance(int x, int y, int r, int c){
        return (int)Math.abs(x-r) + (int)Math.abs(y-c);
    }

    
    static void dfs(int x, int y, int k) {
        if (ret != null) {
            return;
        }
        if(k + distance(x, y, R, C) > K) {
            return; // 현재 깊이 + 남은 거리 > k   
        }

        if (k == K) {
            ret = sb.toString();
            return;
        }
        
        for (int i = 0; i < 4; i++) {
            int X = dx[i] + x;
            int Y = dy[i] + y;
            
            if (X < 1 || X > N || Y < 1 || Y > M) {
                continue;
            }
            
            sb.append(ds[i]);
            dfs(X, Y, k + 1);
            sb.delete(k, k + 1);
        }
    }
}