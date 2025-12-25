import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int ret = 0;
        int len = 0;
        for (int i = 0; i < N; i++) {
            int now = Integer.parseInt(st.nextToken());
            if (now != 0) {
                len++;
            } else {
                ret = Math.max(ret, len);
                len = 0;
            }
        }
        ret = Math.max(ret, len);

        bw.write(ret + "");
        bw.flush();
    }
}
