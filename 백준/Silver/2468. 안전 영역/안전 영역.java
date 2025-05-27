import java.io.*;
import java.util.*;

public class Main {
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static int N;
    static int[][] map;
    static boolean[][] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        int max = 0;
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                max = Math.max(max, map[i][j]);
            }
        }

        int ret = 0;
        for (int i = 0; i < max; i++) {
            int cnt = 0;
            visited = new boolean[N][N];
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    if (!visited[j][k] && map[j][k] > i) {
                        dfs(j, k, i);
                        cnt++;
                    }
                }
            }
            ret = Math.max(ret, cnt);
        }


        bw.write(String.valueOf(ret));
        bw.flush();
    }

    static void dfs(int x, int y, int depth) {
        visited[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int X = x + dx[i];
            int Y = y + dy[i];

            if (X < 0 || X > N - 1 || Y < 0 || Y > N - 1) {
                continue;
            }

            if (map[X][Y] > depth && !visited[X][Y]) {
                dfs(X, Y, depth);
            }
        }
    }
}
