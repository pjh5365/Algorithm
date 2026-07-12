import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        Stack<Integer> s = new Stack<>();
        int n = board.length;
        int ret = 0;
        for (int now : moves) {
            for (int i = 0; i < n; i++) {
                int tmp = board[i][now - 1];
                if (tmp != 0) {
                    if (!s.isEmpty()) {
                        if (s.peek() == tmp) {
                            s.pop();
                            ret += 2;
                        } else {
                            s.push(tmp);
                        }
                    } else {
                        s.push(tmp);
                    }
                    board[i][now - 1] = 0;
                    break;
                }
            }
        }
        return ret;
    }
}