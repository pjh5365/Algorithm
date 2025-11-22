import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int time = 1;
        boolean flag = true;
        while (N-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            int x = Integer.parseInt(st.nextToken());

            sb.append(time);
            if (s.equals("HOURGLASS")) {
                if (time != x) {
                    flag = !flag;
                }
                sb.append(" NO \n");
            } else {
                if (time == x) {
                    sb.append(" YES \n");
                } else {
                    sb.append(" NO \n");
                }
            }

            if (flag) {
                time++;
            } else {
                time--;
            }

            if (time < 1) {
                time = 12;
            } else if (time > 12) {
                time = 1;
            }
        }

        bw.write(String.valueOf(sb));
        bw.flush();
    }
}
