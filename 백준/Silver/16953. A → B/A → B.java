import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        Queue<Pair> q = new ArrayDeque<>();
        q.add(new Pair(A, 0));
        int ret = -1;
        while (!q.isEmpty()) {
            Pair now = q.poll();

            if (now.num == B) {
                ret = now.cnt + 1;
                break;
            }

            long first = now.num * 2;
            long second = now.num * 10 + 1;

            if (first <= B) {
                q.add(new Pair(first, now.cnt + 1));
            }
            if (second <= B) {
                q.add(new Pair(second, now.cnt + 1));
            }
        }

        bw.write(String.valueOf(ret));
        bw.flush();
    }

    static class Pair {
        long num;
        int cnt;

        public Pair(long num, int cnt) {
            this.num = num;
            this.cnt = cnt;
        }
    }
}
