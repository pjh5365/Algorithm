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
            int M = Integer.parseInt(st.nextToken());
            String N = st.nextToken();

            st = new StringTokenizer(br.readLine());
            if (N.equals("C")) {
                for (int i = 0; i < M; i++) {
                    int now = st.nextToken().charAt(0);
                    sb.append(now - 'A' + 1).append(" ");
                }
            } else {
                for (int i = 0; i < M; i++) {
                    int now = Integer.parseInt(st.nextToken());
                    sb.append((char)('A' - 1 + now)).append(" ");
                }
            }
            sb.append("\n");
        }

        bw.write(sb + "");
        bw.flush();
    }
}
