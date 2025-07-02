import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int ret = 5000;
        while (st.hasMoreElements()) {
            int now = Integer.parseInt(st.nextToken());
            if (now == 1) {
                ret -= 500;
            } else if (now == 2) {
                ret -= 800;
            } else if (now == 3) {
                ret -= 1000;
            }
        }

        bw.write(ret + "");
        bw.flush();
    }
}
