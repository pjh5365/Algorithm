import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int ret = 0;
        int start = 1;
        int end = M;
        int J = Integer.parseInt(br.readLine());
        while (J-- > 0) {
            int now = Integer.parseInt(br.readLine());
            if (now < start) {
                int move = start - now;
                end -= move;
                start -= move;
                ret += move;
            } else if (now > end) {
                int move = now - end;
                end += move;
                start += move;
                ret += move;
            }
        }

        bw.write(String.valueOf(ret));
        bw.flush();
    }
}
