import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        double ret = 0;
        double sum = 0;
        for (int i = 0; i < 20; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String a = st.nextToken();
            double b = Double.parseDouble(st.nextToken());
            String c = st.nextToken();

            if (c.equals("P")) {
                continue;
            }
            sum += b;
            if (c.equals("A+")) {
                ret += 4.5 * b;
            } else if (c.equals("A0")) {
                ret += 4.0 * b;
            } else if (c.equals("B+")) {
                ret += 3.5 * b;
            } else if (c.equals("B0")) {
                ret += 3.0 * b;
            } else if (c.equals("C+")) {
                ret += 2.5 * b;
            } else if (c.equals("C0")) {
                ret += 2.0 * b;
            } else if (c.equals("D+")) {
                ret += 1.5 * b;
            } else if (c.equals("D0")) {
                ret += 1.0 * b;
            }
        }

        ret /= sum;

        bw.write(ret + "\n");
        bw.flush();
    }
}
