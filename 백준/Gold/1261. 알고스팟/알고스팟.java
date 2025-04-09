import java.io.*;
import java.util.*;

public class Main {

    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static int[][] map;
    static int[][] visited;
    static int N;
    static int M;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        map = new int[N + 1][M + 1];
        visited = new int[N + 1][M + 1];

        for (int i = 1; i <= N; i++) {
            String s = br.readLine();
            for (int j = 1; j <= M; j++) {
                map[i][j] = s.charAt(j - 1) - '0';
                visited[i][j] = Integer.MAX_VALUE;
            }
        }

        Queue<Pair> q = new ArrayDeque<>();
        q.add(new Pair(1, 1, 0));

        while (!q.isEmpty()) {
            Pair now = q.poll();

            for (int i = 0; i < 4; i++) {
                int x = now.x + dx[i];
                int y = now.y + dy[i];

                if (x < 1 || x > N || y < 1 || y > M) {
                    continue;
                }

                if (visited[x][y] > now.cost) {
                    visited[x][y] = now.cost;
                    q.add(new Pair(x, y, now.cost + map[x][y]));
                }
            }
        }

        bw.write(String.valueOf(visited[N][M] == Integer.MAX_VALUE ? "0" : visited[N][M]));
        bw.flush();
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
