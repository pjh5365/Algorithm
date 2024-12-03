import java.util.*;

class Solution {
    public int solution(String dirs) {
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        
        Set<Pair> set = new HashSet<>();
        int x = 0;
        int y = 0;
        for (int i = 0; i < dirs.length(); i++) {
            int idx = 0;
            if (dirs.charAt(i) == 'D') {
                idx = 1;
            } else if (dirs.charAt(i) == 'R') {
                idx = 2;
            } else if (dirs.charAt(i) == 'L') {
                idx = 3;
            }
            
            int X = x + dx[idx];
            int Y = y + dy[idx];
            
            if (X < -5 || X > 5 || Y < -5 || Y > 5) { // 범위를 넘어선다면 제자리에
                X = x;
                Y = y;
            }
            if (x == X && y == Y) { // 제자리인 경우 넘어가기
                continue;
            }
            set.add(new Pair(x, y, X, Y));
            set.add(new Pair(X, Y, x, y)); // 반대 방향도 넣어주기
            x = X;
			y = Y;
        }
        return set.size() / 2; // 반대방향도 포함되니 나눠주기
    }
    
    static class Pair {
        int beforeX;
        int beforeY;
        int afterX;
        int afterY;
        
        public Pair (int beforeX, int beforeY, int afterX, int afterY) {
            this.beforeX = beforeX;
            this.beforeY = beforeY;
            this.afterX = afterX;
            this.afterY = afterY;
        }
        
        @Override
		public boolean equals(Object o) {
			if (o == null || getClass() != o.getClass())
				return false;
			Pair pair = (Pair)o;
			return beforeX == pair.beforeX && beforeY == pair.beforeY && afterX == pair.afterX && afterY == pair.afterY;
		}

		@Override
		public int hashCode() {
			return Objects.hash(beforeX, beforeY, afterX, afterY);
		}
    }
}