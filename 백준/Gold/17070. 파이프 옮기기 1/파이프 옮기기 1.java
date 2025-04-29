import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int[][] arr = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == 1) { // 벽이라면
                    arr[i][j] = -1; // -1로 표시
                }
            }
        }

        arr[1][1] = 1;
        arr[1][2] = 1;

        Queue<Pair> q = new ArrayDeque<>();
        if (arr[N][N] == -1) {
            arr[N][N] = 0;
        } else {
            q.add(new Pair(1, 2, 0));
        }

        // 가로(가로, 대각선), 세로(세로, 대각선), 대각선(가로, 세로, 대각선)
        int[][] dx = {{0, 1}, {1, 1}, {0, 1, 1}};
        int[][] dy = {{1, 1}, {0, 1}, {1, 0, 1}};

        while (!q.isEmpty()) {
            Pair now = q.poll();
            int idx = now.way;

            for (int i = 0; i < dx[idx].length; i++) {
                int x = now.x + dx[idx][i];
                int y = now.y + dy[idx][i];
                if (x < 1 || x > N || y < 1 || y > N) {
                    continue;
                }

                if (i == dx[idx].length - 1) { // 대각선 방향이라면
                    if (arr[x][y] != -1 && arr[x - 1][y] != -1 && arr[x][y - 1] != -1) {
                        arr[x][y]++;
                        q.add(new Pair(x, y, 2));
                    }
                } else {
                    if (arr[x][y] != -1) {
                        arr[x][y]++;
                        // 가로일땐 가로 넣고 세로일땐 세로 넣고
                        // 대각선일땐 i 그대로 넣고
                        if (idx == 0) {
                            q.add(new Pair(x, y, 0));
                        } else if (idx == 1) {
                            q.add(new Pair(x, y, 1));
                        } else {
                            q.add(new Pair(x, y, i));
                        }
                    }
                }
            }
        }

        bw.write(String.valueOf(arr[N][N]));
        bw.flush();
    }

    static class Pair {
        int x;
        int y;
        int way; // 현재 방향 (0 -> 가로, 1 -> 세로, 2 -> 대각선)

        public Pair(int x, int y, int way) {
            this.x = x;
            this.y = y;
            this.way = way;
        }
    }
}
