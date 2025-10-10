import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int L = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[L + 1];
        int[] cnt = new int[N + 1];

        int max = 0;
        int maxIdx = 0;

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int P = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            int tmp = K - P;
            if (max < tmp) {
                max = tmp;
                maxIdx = i + 1;
            }

            for (int j = P; j <= K; j++) {
                if (arr[j] == 0) {
                    arr[j] = i + 1;
                    cnt[i + 1]++;
                }
            }
        }

        int cntMax = 0;
        int cntIdx = 0;
        for (int i = 1; i <= N; i++) {
            if (cntMax < cnt[i]) {
                cntMax = cnt[i];
                cntIdx = i;
            }
        }
        bw.write(maxIdx + "\n");
        bw.write(cntIdx + "\n");
        bw.flush();
    }
}
