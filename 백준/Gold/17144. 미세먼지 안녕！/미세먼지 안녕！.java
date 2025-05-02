import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());

        int[][] arr = new int[R + 1][C + 1];
        Queue<Pair> q = new ArrayDeque<>();
        int fresh1 = -1;
        int fresh2 = -1;
        for (int i = 1; i <= R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= C; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] > 0) {
                    q.add(new Pair(i, j, arr[i][j]));
                } else if (arr[i][j] == -1) {
                    if (fresh1 == -1) {
                        fresh1 = i;
                    } else {
                        fresh2 = i;
                    }
                }
            }
        }
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};

        while (T-- > 0) {
            while (!q.isEmpty()) {
                // 1
                Pair now = q.poll();

                int cnt = 0; // 확산된 방향
                int dust = now.dust / 5;
                for (int i = 0; i < 4; i++) {
                    int x = dx[i] + now.x;
                    int y = dy[i] + now.y;

                    if (x < 1 || x > R || y < 1 || y > C) {
                        continue;
                    }

                    if (arr[x][y] != -1) { // 공기 청정기가 아니라면 확산
                        arr[x][y] += dust;
                        cnt++;
                    }
                }
                arr[now.x][now.y] = Math.max(0, arr[now.x][now.y] - dust * cnt);
            }
            // 2
            arr[fresh1 - 1][1] = 0;
            arr[fresh2 + 1][1] = 0;
            for (int i = fresh1 - 1; i > 1; i--) {
                arr[i][1] = arr[i - 1][1];
                arr[i - 1][1] = 0;
            }
            for (int i = 1; i < C; i++) {
                arr[1][i] = arr[1][i + 1];
                arr[1][i + 1] = 0;
            }
            for (int i = 1; i < fresh1; i++) {
                arr[i][C] = arr[i + 1][C];
                arr[i + 1][C] = 0;
            }
            for (int i = C; i > 2; i--) {
                arr[fresh1][i] = arr[fresh1][i - 1];
                arr[fresh1][i - 1] = 0;
            }

            for (int i = fresh2 + 1; i < R; i++) {
                arr[i][1] = arr[i + 1][1];
                arr[i + 1][1] = 0;
            }
            for (int i = 1; i < C; i++) {
                arr[R][i] = arr[R][i + 1];
                arr[R][i + 1] = 0;
            }
            for (int i = R; i > fresh2; i--) {
                arr[i][C] = arr[i - 1][C];
                arr[i - 1][C] = 0;
            }
            for (int i = C; i > 2; i--) {
                arr[fresh2][i] = arr[fresh2][i - 1];
                arr[fresh2][i - 1] = 0;
            }

            for (int i = 1; i <= R; i++) {
                for (int j = 1; j <= C; j++) {
                    if (arr[i][j] > 0) {
                        q.add(new Pair(i, j, arr[i][j]));
                    }
                }
            }
        }

        int ret = 0;
        for (int i = 1; i <= R; i++) {
            for (int j = 1; j <= C; j++) {
                ret += arr[i][j];
            }
        }

        bw.write(String.valueOf(ret + 2));
        bw.flush();
    }

    static class Pair {
        int x;
        int y;
        int dust;

        public Pair(int x, int y, int dust) {
            this.x = x;
            this.y = y;
            this.dust = dust;
        }
    }
}
