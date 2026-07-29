import java.util.*;

class Solution {
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int n;
    static int m;

    public int solution(String[] maps) {

        int[] start = new int[2];
        int[] lever = new int[2];
        int[] end = new int[2];
        n = maps.length;
        m = maps[0].length();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (maps[i].charAt(j) == 'S') {
                    start = new int[]{i, j};
                } else if (maps[i].charAt(j) == 'E') {
                    end = new int[]{i, j};
                } else if (maps[i].charAt(j) == 'L') {
                    lever = new int[]{i, j};
                }
            }
        }

        int ret1 = find(start, lever, maps);
        int ret2 = find(lever, end, maps);

        if (ret1 == -1 || ret2 == -1) {
            return -1;
        }
        return ret1 + ret2;
    }

    static int find(int[] start, int[] end, String[] maps) {
        Queue<int[]> q = new ArrayDeque<>();
        q.add(start);
        int[][] map = new int[n][m];
        map[start[0]][start[1]] = 1;

        while (!q.isEmpty()) {
            int[] now = q.poll();

            for (int i = 0; i < 4; i++) {
                int x = now[0] + dx[i];
                int y = now[1] + dy[i];

                if (x < 0 || x > n - 1 || y < 0 || y > m - 1) {
                    continue;
                }

                if (map[x][y] == 0 && maps[x].charAt(y) != 'X') {
                    q.add(new int[] {x, y});
                    map[x][y] = map[now[0]][now[1]] + 1;
                }

                if (x == end[0] && y == end[1]) {
                    return map[now[0]][now[1]];
                }
            }
        }
        return -1;
    }
}