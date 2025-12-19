import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int max = Integer.MIN_VALUE;
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < N; i++) {
                int now = Integer.parseInt(st.nextToken());
                max = Math.max(max, now);
                min = Math.min(min, now);
            }
            sb.append(min).append(" ").append(max).append("\n");
        }

        bw.write(sb + "");
        bw.flush();
    }
}
