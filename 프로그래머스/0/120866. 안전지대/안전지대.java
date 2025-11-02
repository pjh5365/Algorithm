import java.util.*;

class Solution {
    public int solution(int[][] board) {
        int[] dx = {-1 , 0, 1, -1, 1, -1, 0, 1};
        int[] dy = {-1, -1, -1, 0, 0, 1, 1, 1};
        int answer = 0;
        int n = board.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 1) {
                    for (int k = 0; k < 8; k++) {
                        int x = i + dx[k];
                        int y = j + dy[k];
                        
                        if (x < 0 || x > n - 1 || y < 0 || y > n - 1) {
                            continue;
                        }
                        if (board[x][y] == 0) {
                            board[x][y] = 2;
                        }
                    }
                }
            }
        }
        
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 0) {
                    answer++;
                }
            }
        }
        return answer;
    }
}