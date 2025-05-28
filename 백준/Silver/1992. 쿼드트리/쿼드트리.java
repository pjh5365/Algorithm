import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int[][] map = new int[N][N];

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = s.charAt(j) - '0';
            }
        }
        find(0, 0, N, map);

        bw.write(String.valueOf(sb));
        bw.flush();
    }

    static void find(int x, int y, int N, int[][] map) {
        boolean flag = true;
        int now = map[x][y];
        for (int i = x; i < x + N; i++) {
            for (int j = y; j < y + N; j++) {
                if (map[i][j] != now) {
                    flag = false;
                    break;
                }
            }
        }

        if (!flag) { // 할당된 영역에 다른 값이 있다면
            sb.append("(");
            find(x, y, N / 2, map); // 좌상
            find(x, y + N / 2, N / 2, map); // 우상
            find(x + N / 2, y, N / 2, map); // 좌하
            find(x + N / 2, y + N / 2, N / 2, map); // 우하
            sb.append(")");
        } else {
            sb.append(now);
        }
    }
}
