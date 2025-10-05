import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());
        long[] arr = new long[N + 1];

        while (Q-- > 0) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());

            if (num == 1) {
                arr[p] += x;
            } else {
                long sum = 0;
                for (int i = p; i <= x; i++) {
                    sum += arr[i];
                }
                sb.append(sum).append("\n");
            }
        }

        bw.write(sb + "");
        bw.flush();
    }
}
