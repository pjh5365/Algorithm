import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        long ret = 0;
        long tmp = 0;
        for (long i = 1; i < (long)N * N; i++) {
            if (i % N == i / N) {
                tmp = i;
                break;
            }
        }
        if (N != 1) {
            for (int i = 1; i * tmp <= (long)N * N; i++) {
                ret += i * tmp;
            }
        }

        bw.write(ret + "");
        bw.flush();
    }
}
