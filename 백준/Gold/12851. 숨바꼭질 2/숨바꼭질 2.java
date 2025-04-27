import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] arr = new int[100001];
        int ret = 0;
        Queue<Integer> q = new ArrayDeque<>();
        q.add(N);
        arr[N] = 1;
        while (!q.isEmpty()) {
            int now = q.poll();

            int next1 = now - 1;
            int next2 = now + 1;
            int next3 = now * 2;

            if (next1 >= 0) {
                if (arr[next1] == 0 || arr[next1] >= arr[now] + 1) {
                    if (arr[next1] == arr[now] + 1 && next1 == K) { // 동생의 위치라면
                        ret++;
                    } else {
                        if (next1 == K) {
                            ret = 1;
                        }
                        arr[next1] = arr[now] + 1;
                    }
                    q.add(next1);
                }
            }
            if (next2 <= 100000) {
                if (arr[next2] == 0 || arr[next2] >= arr[now] + 1) {
                    if (arr[next2] == arr[now] + 1 && next2 == K) { // 동생의 위치라면
                        ret++;
                    } else {
                        if (next2 == K) {
                            ret = 1;
                        }
                        arr[next2] = arr[now] + 1;
                    }
                    q.add(next2);
                }
            }
            if (next3 <= 100000) {
                if (arr[next3] == 0 || arr[next3] >= arr[now] + 1) {
                    if (arr[next3] == arr[now] + 1 && next3 == K) { // 동생의 위치라면
                        ret++;
                    } else {
                        if (next3 == K) {
                            ret = 1;
                        }
                        arr[next3] = arr[now] + 1;
                    }
                    q.add(next3);
                }
            }
        }

        if (N == K) {
            ret = 1;
        }

        bw.write((arr[K] - 1) + "\n" + ret);
        bw.flush();
    }
}
