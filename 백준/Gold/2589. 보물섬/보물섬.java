import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int M;
    static int ret = 0;
    static int[][] map;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                char now = s.charAt(j);
                if (now == 'L') {
                    map[i][j] = 1;
                } else {
                    map[i][j] = 0;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 1) {
                    bfs(i, j);
                }
            }
        }

        bw.write(ret + " ");
        bw.flush();
    }

    static void bfs(int x, int y) {
        boolean[][] visited = new boolean[N][M];

        Queue<Pair> q = new ArrayDeque<>();
        q.add(new Pair(x, y, 0));
        visited[x][y] = true;

        while (!q.isEmpty()) {
            Pair now = q.poll();
            for (int i = 0; i < 4; i++) {
                int X = now.x + dx[i];
                int Y = now.y + dy[i];

                if (X < 0 || X > N - 1 || Y < 0 || Y > M - 1) {
                    continue;
                }

                if (!visited[X][Y] && map[X][Y] == 1) {
                    visited[X][Y] = true;
                    q.add(new Pair(X, Y, now.cost + 1));
                }
            }
            ret = Math.max(ret, now.cost);
        }
    }

    static class Pair {
        int x;
        int y;
        int cost;

        public Pair(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }
    }
}
