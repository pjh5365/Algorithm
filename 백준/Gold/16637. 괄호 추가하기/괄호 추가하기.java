import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] num;
    static char[] op;
    static String s;
    static int ret = Integer.MIN_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        s = br.readLine();
        int numSize = N / 2 + 1;
        int opSize = N / 2;
        num = new int[numSize];
        op = new char[opSize];

        int numIdx = 0;
        int opIndx = 0;
        for (int i = 0; i < N; i++) {
            if (i % 2 == 0) {
                num[numIdx++] = s.charAt(i) - '0';
            } else {
                op[opIndx++] = s.charAt(i);
            }
        }

        find(0, num[0]);

        bw.write(ret + "");
        bw.flush();
    }

    static void find(int now, int sum) {
        if (now == op.length) {
            ret = Math.max(ret, sum);
            return;
        }

        find(now + 1, oper(sum, op[now], num[now + 1]));
        if (now + 2 <= num.length - 1) {
            int tmp = oper(num[now + 1], op[now + 1], num[now + 2]);
            find(now + 2, oper(sum, op[now], tmp));
        }
    }

    static int oper(int a, char b, int c) {
        if (b == '+') {
            return a + c;
        } else if (b == '-') {
            return a - c;

        } else {
            return a * c;
        }
    }
}
