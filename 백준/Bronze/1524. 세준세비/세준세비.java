import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            br.readLine();
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            int[] a = new int[N];
            int[] b = new int[M];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                a[i] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                b[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(a);
            Arrays.sort(b);

            int aIdx = 0;
            int bIdx = 0;


            while (true) {
                int A = a[aIdx];
                int B = b[bIdx];

                if (A < B) {
                    aIdx++;
                } else {
                    bIdx++;
                }

                if (N == aIdx) {
                    sb.append("B").append("\n");
                    break;
                } else if (M == bIdx) {
                    sb.append("S").append("\n");
                    break;
                }
            }

        }

        bw.write(String.valueOf(sb));
        bw.flush();
    }
}
