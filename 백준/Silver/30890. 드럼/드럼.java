import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int X = Integer.parseInt(st.nextToken());
        int Y = Integer.parseInt(st.nextToken());

        int l = lcm(X, Y);
        int x = l / X;
        int y = l / Y;

        for (int i = 1; i <= l; i++) {
            if (i % x == 0 && i % y == 0) {
                sb.append("3");
            } else if (i % x == 0) {
                sb.append("1");
            } else if (i % y == 0) {
                sb.append("2");
            }
        }

        bw.write(sb + "");
        bw.flush();
    }

    static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    static int lcm(int a, int b) {
        return a * b / gcd(a, b);
    }
}
