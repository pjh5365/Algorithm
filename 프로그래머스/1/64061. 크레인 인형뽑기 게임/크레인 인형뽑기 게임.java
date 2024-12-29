import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
		ArrayList<Stack<Integer>> map = new ArrayList<>();
		for (int i = 0; i < board.length; i++) {
			map.add(new Stack<>());
		}

		for (int i = board[0].length - 1; i >= 0; i--) {
			for (int j = board.length - 1; j >= 0; j--) {
				if (board[j][i] != 0) {
					map.get(i).push(board[j][i]);
				}
			}
		}

		Stack<Integer> s = new Stack<>();
		int ret = 0;
		for (int i : moves) {
			if (!map.get(i - 1).isEmpty()) {
				int tmp = map.get(i - 1).pop();
				if (!s.isEmpty() && s.peek() == tmp) {
					ret += 2;
					s.pop();
				} else {
					s.push(tmp);
				}
			}
		}

		return ret;
	}
}