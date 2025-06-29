import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        long N = Long.parseLong(st.nextToken());
        long M = Long.parseLong(st.nextToken());

        long ret = 1;
        if (N >= M) {
            ret = 0;
        } else {
            for (long i = 2; i <= N; i++) {
                ret *= i;
                ret %= M;
            }
        }

        bw.write(ret + "");
        bw.flush();
    }
}
