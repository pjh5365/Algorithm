import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        String s = br.readLine();

        int cnt = 0;
        int ret = 0;
        for (int i = 1; i <= M - 1;) {
            if (s.startsWith("OI", i)) {
                cnt++;
                if (cnt == N) {
                    if (s.charAt(i - (cnt * 2 - 1)) == 'I') {
                        ret++;
                    }
                    cnt--;
                }
                i += 2;
            } else {
                cnt = 0;
                i++;
            }
        }
        bw.write(String.valueOf(ret));
        bw.flush();
    }
}
