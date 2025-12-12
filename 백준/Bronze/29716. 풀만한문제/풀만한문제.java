import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int J = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int ret = 0;
        for (int i = 0; i < N; i++) {
            int cnt = 0;
            String s = br.readLine();

            for (int j = 0; j < s.length(); j++) {
                if (s.charAt(j) <= 'Z' && s.charAt(j) >= 'A') {
                    cnt += 4;
                } else if ((s.charAt(j) <= 'z' && s.charAt(j) >= 'a') || (s.charAt(j) <= '9' && s.charAt(j) >= '0')) {
                    cnt += 2;
                } else {
                    cnt += 1;
                }
            }

            if (cnt <= J) {
                ret++;
            }
        }

        bw.write(ret + "");
        bw.flush();
    }
}
