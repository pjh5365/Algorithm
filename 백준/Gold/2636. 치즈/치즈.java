import java.io.*;
import java.util.*;

public class Main {
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static int N;
    static int M;
    static int[][] map;
    static boolean[][] visited;
    static Queue<Pair> q = new ArrayDeque<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        int size = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) {
                    size++;
                }
            }
        }
        int cnt = 0;
        while (true) {
            visited = new boolean[N][M];
            dfs(0, 0);
            if (q.isEmpty()) {
                break;
            }
            cnt++;

            size = q.size();
            while (!q.isEmpty()) {
                Pair get = q.poll();
                map[get.x][get.y] = 0;
            }
        }

        bw.write(cnt + " \n");
        bw.write(size + " \n");
        bw.flush();
    }

    static void dfs(int x, int y) {
        visited[x][y] = true;
        if (map[x][y] == 1) {
            q.add(new Pair(x, y));
            return;
        }

        for (int i = 0; i < 4; i++) {
            int X = x + dx[i];
            int Y = y + dy[i];

            if (X < 0 || X > N - 1 || Y < 0 || Y > M - 1) {
                continue;
            }

            if (!visited[X][Y]) {
                dfs(X, Y);
            }
        }
    }

    static class Pair {
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
