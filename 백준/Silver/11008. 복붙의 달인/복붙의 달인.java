import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        while (n-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String a = st.nextToken();
            String b = st.nextToken();

            int ret = a.length();
            a = a.replaceAll(b, "");
            sb.append(a.length() + (ret - a.length()) / b.length()).append("\n");
        }

        bw.write(String.valueOf(sb));
        bw.flush();
    }
}
