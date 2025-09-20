import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        long A = (long)K * N;
        long B = (N - 1);
        long ret;
        if (N == 1) {
            ret = -1;
        } else {
            ret = A / B;
            if (A % B > 0) {
                ret++;
            }
        }


        bw.write(String.valueOf(ret));
        bw.flush();
    }
}
// (X - K) * N >= X

// N * X - X >= K * N
// (N - 1) * X >= K * N
// X >= K * N / (N - 1)
