import java.io.*;
import java.util.*;

public class Main {
    // 참고: https://superohinsung.tistory.com/204?category=988407
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        long n = Long.parseLong(br.readLine());

        long[][] ret = fibonacci(n - 1);

        bw.write(String.valueOf(ret[0][0]));
        bw.flush();
    }

    static long[][] multiple(long[][] a, long[][] b) {
        long[][] arr = new long[2][2];

        arr[0][0] = ((a[0][0] * b[0][0]) + (a[0][1] * b[1][0])) % 1000000007;
        arr[1][0] = ((a[0][0] * b[0][1]) + (a[0][1] * b[1][1])) % 1000000007;
        arr[0][1] = ((a[1][0] * b[0][0]) + (a[1][1] * b[1][0])) % 1000000007;
        arr[1][1] = ((a[1][0] * b[0][1]) + (a[1][1] * b[1][1])) % 1000000007;

        return arr;
    }

    static long[][] fibonacci(long n) {
        if (n == 0 || n == 1) {
            return new long[][] {{1, 1}, {1, 0}};
        }

        long[][] tmp = fibonacci(n / 2);

        if (n % 2 == 1) {
            return multiple(multiple(tmp, tmp), new long[][] {{1, 1}, {1, 0}});
        } else {
            return multiple(tmp, tmp);
        }
    }
}
