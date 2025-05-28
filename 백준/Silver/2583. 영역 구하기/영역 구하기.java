import java.io.*;
import java.util.*;

public class Main {
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static ArrayList<Integer> list = new ArrayList<>();
    static int size = 0;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[][] map = new int[M][N];
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int y1 = Integer.parseInt(st.nextToken());
            int x1 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());

            for (int j = x1; j < x2; j++) {
                for (int k = y1; k < y2; k++) {
                    map[j][k] = -1;
                }
            }
        }

        int ret = 0;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 0) {
                    ret++;
                    size = 0;
                    dfs(i, j, ret, map, M, N);
                    list.add(size);
                }
            }
        }
        Collections.sort(list);
        bw.write(ret + "\n");
        for (int i : list) {
            bw.write(i + " ");
        }
        bw.flush();
    }

    static void dfs(int x, int y, int cnt, int[][] map, int M, int N) {
        map[x][y] = cnt;
        size++;

        for (int i = 0; i < 4; i++) {
            int X = x + dx[i];
            int Y = y + dy[i];

            if (X < 0 || X > M - 1 || Y < 0 || Y > N - 1) {
                continue;
            }

            if (map[X][Y] == 0) {
                dfs(X, Y, cnt, map, M, N);
            }
        }
    }
}
