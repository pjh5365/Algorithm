import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), "*");
        String start = st.nextToken();
        String end = st.nextToken();
        while (N-- > 0) {
            String s = br.readLine();
            if (s.length() >= start.length() + end.length() && s.startsWith(start) && s.endsWith(end)) {
                sb.append("DA");
            } else {
                sb.append("NE");
            }
            sb.append("\n");
        }

        bw.write(String.valueOf(sb));
        bw.flush();
    }
}
