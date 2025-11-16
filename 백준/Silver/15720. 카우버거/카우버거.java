import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());

        int ret1 = 0;
        st = new StringTokenizer(br.readLine());
        Integer[] b = new Integer[B];
        for (int i = 0; i < B; i++) {
            b[i] = Integer.parseInt(st.nextToken());
            ret1 += b[i];
        }
        st = new StringTokenizer(br.readLine());
        Integer[] c = new Integer[C];
        for (int i = 0; i < C; i++) {
            c[i] = Integer.parseInt(st.nextToken());
            ret1 += c[i];
        }
        st = new StringTokenizer(br.readLine());
        Integer[] d = new Integer[D];
        for (int i = 0; i < D; i++) {
            d[i] = Integer.parseInt(st.nextToken());
            ret1 += d[i];
        }
        Arrays.sort(b, Collections.reverseOrder());
        Arrays.sort(c, Collections.reverseOrder());
        Arrays.sort(d, Collections.reverseOrder());
        int tmp = 0;
        int ret2 = 0;
        for (int i = 0; i < Math.min(B, Math.min(C, D)); i++) {
            tmp += b[i];
            tmp += c[i];
            tmp += d[i];

            int t = b[i] + c[i] + d[i];
            ret2 += (int)(t * 0.9);
        }

        bw.write(ret1 + "\n");
        bw.write(ret2 + (ret1 - tmp) + "\n");
        bw.flush();
    }
}
