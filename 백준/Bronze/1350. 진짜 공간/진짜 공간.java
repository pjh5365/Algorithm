import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int size = Integer.parseInt(br.readLine());

        long ret = 0;
        for (int i = 0; i < N; i++) {
            int now = Integer.parseInt(st.nextToken());
            int cnt = 0;
            if (now == 0) {
                continue;
            }
            cnt += now / size;
            if (now % size != 0) {
                cnt++;
            }
            ret += (long)size * cnt;
        }

        bw.write(ret + "\n");
        bw.flush();
    }
}
