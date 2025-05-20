import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());
        long C = Long.parseLong(st.nextToken());

        long ret = find(A, B, C);

        bw.write(String.valueOf(ret));
        bw.flush();
    }

    static long find(long a, long b, long c) {
        if (b == 1) {
            return a % c;
        }
        long ret = find(a, b / 2, c);
        ret = ret * ret % c;

        if (b % 2 == 1) {
            ret = ret * a % c;
        }
        
        return ret;
    }
}
