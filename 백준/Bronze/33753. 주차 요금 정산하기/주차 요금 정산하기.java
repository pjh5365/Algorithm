import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        int T = Integer.parseInt(br.readLine());

        int ret = A;
        if (T > 30) {
            int tmp = T - 30;
            ret += tmp / B * C;
            if (tmp % B != 0) {
                ret += C;
            }
        }

        bw.write(ret + "");
        bw.flush();
    }
}
