import java.io.*;
import java.util.*;

public class Main {
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        char[][] arr = new char[N][M];
        boolean[][] visited = new boolean[N][M];

        Queue<Pair> q = new ArrayDeque<>();
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                arr[i][j] = s.charAt(j);
                if (arr[i][j] == 'I') {
                    q.add(new Pair(i, j));
                    visited[i][j] = true;
                }
            }
        }
        int ret = 0;

        while (!q.isEmpty()) {
            Pair now = q.poll();
            for (int i = 0; i < 4; i++) {
                int X = now.x + dx[i];
                int Y = now.y + dy[i];
                if (X < 0 || X >= N || Y < 0 || Y >= M) {
                    continue;
                }

                if (!visited[X][Y] && (arr[X][Y] == 'O' || arr[X][Y] == 'P')) {
                    visited[X][Y] = true;
                    q.add(new Pair(X, Y));
                    if (arr[X][Y] == 'P') {
                        ret++;
                    }
                }
            }
        }

        if (ret == 0) {
            bw.write("TT");
        } else {
            bw.write(String.valueOf(ret));
        }
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
