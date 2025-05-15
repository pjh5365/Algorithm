import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            long a = Long.parseLong(st.nextToken());
            String b = st.nextToken();
            long c = Long.parseLong(st.nextToken());
            String d = st.nextToken();
            long e = Long.parseLong(st.nextToken());

            long ret = 0;
            if (b.equals("+")) {
                ret = a + c;
            } else if (b.equals("-")) {
                ret = a - c;
            } else if (b.equals("*")) {
                ret = a * c;
            } else if (b.equals("/")) {
                ret = a / c;
            }

            if (ret == e) {
                sb.append("correct").append("\n");
            } else {
                sb.append("wrong answer").append("\n");
            }
        }

        bw.write(String.valueOf(sb));
        bw.flush();
    }
}
