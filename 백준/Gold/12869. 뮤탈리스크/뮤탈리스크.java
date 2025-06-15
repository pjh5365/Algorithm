import java.io.*;
import java.util.*;

public class Main {
    static int[][] attack = {
            {9, 3, 1},
            {1, 9, 3},
            {3, 1, 9},
            {3, 9, 1},
            {1, 3, 9},
            {9, 1, 3}
    };
    static int [][][] visited = new int[61][61][61];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[3];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Queue<Pair> q = new ArrayDeque<>();
        q.add(new Pair(arr[0], arr[1], arr[2]));
        while (!q.isEmpty()) {
            Pair get = q.poll();

            int a = get.x;
            int b = get.y;
            int c = get.z;

            if (visited[0][0][0] != 0) {
                break;
            }

            for (int i = 0; i < 6; i++) {
                int da = Math.max(0, a - attack[i][0]);
                int db = Math.max(0, b - attack[i][1]);
                int dc = Math.max(0, c - attack[i][2]);

                if (visited[da][db][dc] == 0) {
                    visited[da][db][dc] = visited[a][b][c] + 1;
                    q.add(new Pair(da, db, dc));
                }
            }
        }


        bw.write(String.valueOf(visited[0][0][0]));
        bw.flush();
    }

    static class Pair {
        int x;
        int y;
        int z;

        public Pair(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }
}
