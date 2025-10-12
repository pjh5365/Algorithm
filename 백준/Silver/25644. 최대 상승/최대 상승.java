import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int ret = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            int now = Integer.parseInt(st.nextToken());
            ret = Math.max(ret, now - min);
            min = Math.min(min, now);
        }

        bw.write(ret + "\n");
        bw.flush();
    }
}
