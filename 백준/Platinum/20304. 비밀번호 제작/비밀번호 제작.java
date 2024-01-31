import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        // 참고 : https://imksh.com/47
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        int[] p = new int[M];
        int[] arr = new int[N + 1];
        boolean[] visited = new boolean[N + 1];

        Queue<Integer> q = new LinkedList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            p[i] = Integer.parseInt(st.nextToken());
            q.add(p[i]);
            visited[p[i]] = true;
        }

        int max = 0;

        while (!q.isEmpty()) {
            int now = q.poll();
            for (int i = 0; i < 20; i++) {
                int result = now ^ (1 << i);
                if (result <= N && arr[result] == 0 && !visited[result]) {
                    arr[result] = arr[now] + 1;
                    visited[result] = true;
                    max = Math.max(max, arr[result]);
                    q.add(result);
                }
            }
        }

        bw.write(String.valueOf(max));
        bw.flush();
    }
}
