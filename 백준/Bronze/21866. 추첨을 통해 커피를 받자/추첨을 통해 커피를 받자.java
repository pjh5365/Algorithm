import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int ret = 0;
        boolean flag = false;
        int sum = 0;
        for (int i = 0; i < 9; i++) {
            int now = Integer.parseInt(st.nextToken());
            if (i % 2 == 0) {
                sum += 100;
            }
            if (now > sum) {
                flag = true;
            }
            ret += now;
        }

        if (flag) {
            bw.write("hacker");
        } else if (!flag && ret >= 100) {
            bw.write("draw");
        } else {
            bw.write("none");
        }
        bw.flush();
    }
}
