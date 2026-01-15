import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine(), "(");
        String a = st.nextToken();
        String b = "-";
        if (st.hasMoreTokens()) {
            b = st.nextToken();
            b = b.substring(0, b.length() - 1);
        }
        sb.append(a).append("\n").append(b);

        bw.write(sb + "");
        bw.flush();
    }
}
