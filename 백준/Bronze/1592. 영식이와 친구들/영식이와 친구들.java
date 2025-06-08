import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        arr[0] = 1;
        int now = 1;
        int idx = 0;
        int cnt = 0;

        while (true) {
            if (now == M) {
                break;
            }
            if (now % 2 == 0) {
                idx += L;
                if (idx >= N) {
                    idx -= N;
                }
            } else {
                idx -= L;
                if (idx < 0) {
                    idx += N;
                }
            }
            arr[idx]++;
            now = arr[idx];
            cnt++;
        }

        bw.write(cnt + " ");
        bw.flush();
    }
}
