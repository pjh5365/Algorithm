import java.util.*;

class Solution {

    static int[] dx = {1, 0, -1, 0}; // 아래, 오른쪽, 위, 왼쪽
    static int[] dy = {0, 1, 0, -1};

    static int N;
    static int ret = Integer.MAX_VALUE;

    public int solution(int[][] board) {
        N = board.length;

        bfs(board);

        return ret;
    }

    static void bfs(int[][] board) {
        Queue<Pair> q = new ArrayDeque<>();

        // cost[x][y][way]
        // 해당 방향으로 (x, y)에 도착했을 때 최소 비용
        int[][][] cost = new int[N][N][4];

        for (int x = 0; x < N; x++) {
            for (int y = 0; y < N; y++) {
                Arrays.fill(cost[x][y], Integer.MAX_VALUE);
            }
        }

        // 첫 이동은 무조건 직선 비용 100원이므로
        // 시작점에서 갈 수 있는 방향을 직접 넣어준다.
        for (int i = 0; i < 4; i++) {
            cost[0][0][i] = 100;
            q.add(new Pair(0, 0, 0, i));
        }

        while (!q.isEmpty()) {
            Pair now = q.poll();

            // 이미 더 좋은 경로가 발견된 상태라면 무시
            if (cost[now.x][now.y][now.way] < now.cost) {
                continue;
            }

            for (int i = 0; i < 4; i++) {
                int x = now.x + dx[i];
                int y = now.y + dy[i];

                if (x < 0 || x >= N || y < 0 || y >= N) {
                    continue;
                }

                // 벽
                if (board[x][y] == 1) {
                    continue;
                }

                int moveCost;

                if (i == 0 || i == 2) {
                    if (now.way == 0 || now.way == 2) {
                        moveCost = 100;
                    } else {
                        moveCost = 600;
                    }
                } else {
                    if (now.way == 0 || now.way == 2) {
                        moveCost = 600;
                    } else {
                        moveCost = 100;
                    }
                }

                int newCost = now.cost + moveCost;

                // 같은 칸이어도 "어느 방향으로 도착했는지" 별도로 비교
                if (cost[x][y][i] > newCost) {
                    cost[x][y][i] = newCost;
                    q.add(new Pair(x, y, newCost, i));
                }
            }
        }

        for (int i = 0; i < 4; i++) {
            ret = Math.min(ret, cost[N - 1][N - 1][i]);
        }
    }

    static class Pair {
        int x;
        int y;
        int cost;
        int way;

        public Pair(int x, int y, int cost, int way) {
            this.x = x;
            this.y = y;
            this.cost = cost;
            this.way = way;
        }
    }
}