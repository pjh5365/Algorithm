import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        Stack<Integer> s = new Stack<>();
        
        List<Stack<Integer>> sList = new ArrayList<>();
        
        for (int i = 0; i < board.length; i++) {
            sList.add(new Stack<>());
        }
                
        for (int i = 0; i < board.length; i++) {
            for (int j = board.length - 1; j >= 0; j--) {
                if (board[j][i] != 0) {
                    sList.get(i).push(board[j][i]);
                }
            }
        }
        
        int ret = 0;
        for (int i : moves) {
            Stack<Integer> now = sList.get(i - 1);
            if (!now.isEmpty()) {
                int get = now.pop();
                if (!s.isEmpty()) {
                    if (s.peek() == get) {
                        s.pop();
                        ret += 2;
                    } else {
                        s.push(get);
                    }
                } else {
                    s.push(get);
                }
            }
        }
        return ret;
    }
}