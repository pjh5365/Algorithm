import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());

        int tmp = (int)Math.sqrt(W * W + H * H);

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());

            if (num <= tmp) {
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
