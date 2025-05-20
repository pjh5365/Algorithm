import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        long A = Long.parseLong(br.readLine());
        long X = Long.parseLong(br.readLine());

        bw.write(String.valueOf(find(A % 1000000007, X)));
        bw.flush();
    }

    static long find(long A, long X) {
        if (X == 1) {
            return A % 1000000007;
        }

        long ret = find(A, X / 2);
        ret = ret * ret % 1000000007;

        if (X % 2 != 0) {
            ret = ret * A % 1000000007;
        }
        return ret;
    }
}
