import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        Deque<Integer> q = new ArrayDeque<>();

        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());

            if (a == 1) {
                q.addFirst(Integer.valueOf(st.nextToken()));
            } else if (a == 2) {
                q.addLast(Integer.valueOf(st.nextToken()));
            } else if (a == 3) {
                if (!q.isEmpty()) {
                    sb.append(q.pollFirst()).append("\n");
                } else {
                    sb.append("-1").append("\n");
                }
            } else if (a == 4) {
                if (!q.isEmpty()) {
                    sb.append(q.pollLast()).append("\n");
                } else {
                    sb.append(-1).append("\n");
                }
            } else if (a == 5) {
                sb.append(q.size()).append("\n");
            } else if (a == 6) {
                if (!q.isEmpty()) {
                    sb.append(0).append("\n");
                } else {
                    sb.append(1).append("\n");
                }
            } else if (a == 7) {
                if (!q.isEmpty()) {
                    sb.append(q.peekFirst()).append("\n");
                } else {
                    sb.append(-1).append("\n");
                }
            } else if (a == 8) {
                if (!q.isEmpty()) {
                    sb.append(q.peekLast()).append("\n");
                } else {
                    sb.append(-1).append("\n");
                }
            }
        }

        bw.write(String.valueOf(sb));
        bw.flush();
    }
}
