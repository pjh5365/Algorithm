import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] map = new int[101];
        boolean[] visit = new boolean[101];
        int ret = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            map[x] = y;
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            map[u] = v;
        }

        Queue<Pair> q = new ArrayDeque<>();
        q.add(new Pair(1, 0));
        while (!q.isEmpty()) {
            Pair now = q.poll();
            if (now.idx > 100 || now.cnt > ret) {
                continue;
            }
            if (now.idx == 100) {
                ret = now.cnt;
            }
            for (int i = 1; i <= 6; i++) {
                if (now.idx + i > 100) {
                    break;
                }
                if (!visit[now.idx + i] && map[now.idx + i] == 0) {
                    visit[now.idx + i] = true;
                    q.add(new Pair(now.idx + i, now.cnt + 1));
                } else if (!visit[now.idx + i]) { // 사다리를 타거나 뱀을 타거나
                    visit[now.idx + i] = true;
                    q.add(new Pair(map[now.idx + i], now.cnt + 1));
                }
            }
        }

        bw.write(String.valueOf(ret));
        bw.flush();
    }

    static class Pair {
        int idx;
        int cnt;

        public Pair(int idx, int cnt) {
            this.idx = idx;
            this.cnt = cnt;
        }
    }
}
