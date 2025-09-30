import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        int ret = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            boolean flag = true;
            int a = Integer.parseInt(st.nextToken());
            if (a < L) {
                flag = false;
            }
            int b = Integer.parseInt(st.nextToken());
            if (b < L) {
                flag = false;
            }
            int c = Integer.parseInt(st.nextToken());
            if (c < L) {
                flag = false;
            }

            int sum = a + b + c;

            if (flag && sum >= K) {
                ret++;
                sb.append(a).append(" ").append(b).append(" ").append(c).append(" ");
            }
        }

        bw.write(ret + "\n" + sb);
        bw.flush();
    }
}
