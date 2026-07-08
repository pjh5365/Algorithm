import java.util.*;

class Solution {
    public int solution(String dirs) {
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        Set<String> set = new HashSet<>();
        int x = 0;
        int y = 0;
        for (int i = 0; i < dirs.length(); i++) {
            char d = dirs.charAt(i);
            int idx = 0;
            if (d == 'D') {
                idx = 1;
            } else if (d == 'R') {
                idx = 2;
            } else if (d == 'L') {
                idx = 3;
            }
            
            int X = x + dx[idx];
            int Y = y + dy[idx];
            
            if (X < -5 || X > 5 || Y < -5 || Y > 5) {
                X = x;
                Y = y;
            }
            if (x == X && y == Y) {
                continue;
            }
            String s1 = x + " " + y + " " + X + " " + Y;
            String s2 = X + " " + Y + " " + x + " " + y;
            set.add(s1);
            set.add(s2);
            x = X;
			y = Y;
        }
        
        return set.size() / 2;
    }
}