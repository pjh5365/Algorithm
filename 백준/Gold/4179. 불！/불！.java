import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int[][] arr = new int[R][C];

        Queue<Pair> q = new ArrayDeque<>();
        Pair jihun = null;
        for (int i = 0; i < R; i++) {
            String input = br.readLine();
            for (int j = 0; j < C; j++) {
                if (input.charAt(j) == 'F') {    // 불의 위치라면 큐에 삽입
                    q.add(new Pair(i, j));
                } else if (input.charAt(j) == 'J') {    // 지훈이의 위치기억하기
                    arr[i][j] = -2;
                    jihun = new Pair(i, j);
                } else if (input.charAt(j) == '#') {	// 벽은 -1 로 표시
                    arr[i][j] = -1;
                } else {	// 불이 없는 구역은 -2 로 표시
                    arr[i][j] = -2;
                }
            }
        }

        int ret = Integer.MAX_VALUE;
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};
        while (!q.isEmpty()) {	// 불 먼저 탐색
            Pair now = q.poll();
            int X = now.x;
            int Y = now.y;

            for (int i = 0; i < 4; i++) {
                int x = X + dx[i];
                int y = Y + dy[i];

                if (x < 0 || x > R - 1 || y < 0 || y > C - 1)
                    continue;

                if (arr[x][y] == -2) {
                    arr[x][y] = arr[X][Y] + 1;
                    q.add(new Pair(x, y));
                }
            }
        }
        q.add(jihun);
        arr[jihun.x][jihun.y] = 0;	// 지훈이의 시작점은 다시 0으로 초기화
        while (!q.isEmpty()) {	// 지훈이 탐색
            Pair now = q.poll();
            int X = now.x;
            int Y = now.y;

            for (int i = 0; i < 4; i++) {
                int x = X + dx[i];
                int y = Y + dy[i];

                if (x < 0 || x >= R || y < 0 || y >= C) {	// 지훈이가 탈출 가능하다면
                    ret = Math.min(ret, arr[X][Y]);
                    break;
                }

                if (arr[x][y] == -2 || (arr[x][y] > 0 && arr[x][y] > arr[X][Y] + 1)) {	// 불이 없는 구역이거나 || 불보다 지훈이가 먼저 도착하는 경우 (불의 위치와 벽은 제외하도록 > 0 설정)
                    arr[x][y] = arr[X][Y] + 1;
                    q.add(new Pair(x, y));
                }
            }
        }

        if (ret == Integer.MAX_VALUE)	// 탈출 못해 ret 를 갱신하지 못하는 경우
            bw.write("IMPOSSIBLE");
        else
            bw.write(String.valueOf(ret + 1));
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
