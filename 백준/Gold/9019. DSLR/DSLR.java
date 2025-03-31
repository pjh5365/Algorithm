import java.io.*;
import java.util.*;

public class Main {

    static int A;
    static int B;
    static boolean[] visited;
    static String[] cmd;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            A = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());

            visited = new boolean[10000];
            cmd = new String[10000];
            Arrays.fill(cmd, "");
            sb.append(bfs()).append("\n");
        }

        bw.write(String.valueOf(sb));
        bw.flush();
    }

    static String bfs() {
        Queue<Integer> q = new ArrayDeque<>();
        visited[A] = true;
        q.add(A);

        while (!q.isEmpty() && !visited[B]) {
            int now = q.poll();

            int D = (2 * now) % 10000;
            int S = now == 0 ? 9999 : now - 1;
            int L = (now % 1000) * 10 + now / 1000;
            int R = (now % 10) * 1000 + now / 10;

            if (!visited[D]) {
                q.add(D);
                visited[D] = true;
                cmd[D] = cmd[now] + "D";
            }

            if (!visited[S]) {
                q.add(S);
                visited[S] = true;
                cmd[S] = cmd[now] + "S";
            }

            if (!visited[L]) {
                q.add(L);
                visited[L] = true;
                cmd[L] = cmd[now] + "L";
            }

            if (!visited[R]) {
                q.add(R);
                visited[R] = true;
                cmd[R] = cmd[now] + "R";
            }

        }
        return cmd[B];
    }

    static class Pair {
        String s;
        String num;

        public Pair(String s, String num) {
            this.s = s;
            this.num = num;
        }
    }
}
