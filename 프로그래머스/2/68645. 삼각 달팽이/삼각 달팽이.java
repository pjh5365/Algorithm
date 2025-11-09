import java.util.*;

class Solution {
    public int[] solution(int n) {
        int[][] arr = new int[n + 1][n + 1];
        int[] ret = new int[(n * (n + 1) / 2)];
        
        int x = 0;
        int y = 1;
        int num = 1;
        
        for (int i = 1; i <= n; i++) {
            for (int j = i; j <= n; j++) {
                if (i % 3 == 1) {
                    x++;
                } else if (i % 3 == 2) {
                    y++;
                } else if (i % 3 == 0) {
                    x--;
                    y--;
                }
                arr[x][y] = num++;
            }
        }
        
        int idx = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (arr[i][j] == 0) {
                    break;
                }
                ret[idx++] = arr[i][j];
            }
        }
        
        return ret;
    }
}