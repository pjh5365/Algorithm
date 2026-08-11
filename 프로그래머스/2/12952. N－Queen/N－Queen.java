import java.util.*;

class Solution {
    static int ret = 0;
    static int[][] map;
    public int solution(int n) {
        map = new int[n][n];
        dfs(0, n);
        return ret;
    }
    
    static void dfs(int depth, int n) {
        if (depth == n) {
            ret++;
            return;
        }
        
        for (int i = 0; i < n; i++) { // 퀸의 경우 한 행에 하나만 가능하므로 행은 제외
            if (isOk(depth, i, n)) {
                map[depth][i] = 1;
                dfs(depth + 1, n);
                map[depth][i] = 0;
            }
        }
    }
    
    static boolean isOk(int x, int y, int n) {
        // 좌상, 우상, 상 만 보면된다
        for (int i = 0; i < x; i++) { // 위쪽 확인
            if (map[i][y] == 1) {
                return false;
            }
        }
        
        int i = x;
        int j = y;
        while (i >= 0 && j >= 0) { // 좌상 확인
            if (map[i][j] == 1) {
                return false;
            }
            i--;
            j--;
        }
        i = x;
        j = y;
        
        while (i >= 0 && j < n) { // 우상 확인
            if (map[i][j] == 1) {
                return false;
            }
            i--;
            j++;
        }
        
        return true;
    }
}