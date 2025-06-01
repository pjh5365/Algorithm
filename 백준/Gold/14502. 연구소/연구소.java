import java.io.*;
import java.util.*;

public class Main {
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static int[][] map;
    static int[] wall = new int[3];
    static boolean[][] visited;
    static int ret = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) {
                    visited[i][j] = true;
                }
            }
        }

        find(0, N, M);

        bw.write(ret + "");
        bw.flush();
    }

    static void find(int k, int N, int M) {
        if (k == 3) {
            int[][] arr = new int[N][M];
            for (int i = 0; i < N; i++) {
                arr[i] = map[i].clone();
            }
            for (int i = 0; i < 3; i++) {
                int x = wall[i] / M;
                int y = wall[i] % M;
                arr[x][y] = 1;
            }
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (arr[i][j] == 2) {
                        bfs(i, j, arr, N, M);
                    }
                }
            }
            int cnt = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (arr[i][j] == 0) {
                        cnt++;
                    }
                }
            }
            ret = Math.max(ret, cnt);
            return;
        }

        for (int i = 0; i < N * M; i++) {
            int x = i / M;
            int y = i % M;
            if (!visited[x][y] && map[x][y] == 0) {
                visited[x][y] = true;
                wall[k] = i;
                find(k + 1, N, M);
                visited[x][y] = false;
            }
        }
    }

    static void bfs(int x, int y, int[][] arr, int N, int M) {
        Queue<Pair> q = new ArrayDeque<>();
        q.add(new Pair(x, y));
        arr[x][y] = 3;

        while (!q.isEmpty()) {
            Pair get = q.poll();

            for (int i = 0; i < 4; i++) {
                int X = get.x + dx[i];
                int Y = get.y + dy[i];

                if (X < 0 || X > N - 1 || Y < 0 || Y > M - 1) {
                    continue;
                }

                if (arr[X][Y] == 0) {
                    arr[X][Y] = 3;
                    q.add(new Pair(X, Y));
                }
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
