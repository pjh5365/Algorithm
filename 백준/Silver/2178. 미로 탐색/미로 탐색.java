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
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new int[N][M];

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = s.charAt(j) - '0';
            }
        }

        Queue<Pair> q = new ArrayDeque<>();
        visited[0][0] = 1;
        q.add(new Pair(0, 0));

        while (!q.isEmpty()) {
            Pair get = q.poll();

            for (int i = 0; i < 4; i++) {
                int x = get.x + dx[i];
                int y = get.y + dy[i];

                if (x < 0 || x > N - 1 || y < 0 || y > M - 1) {
                    continue;
                }

                if (visited[x][y] == 0 && map[x][y] == 1) {
                    visited[x][y] = visited[get.x][get.y] + 1;
                    q.add(new Pair(x, y));
                }
            }
        }

        bw.write(String.valueOf(visited[N - 1][M - 1]));
        bw.flush();
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
