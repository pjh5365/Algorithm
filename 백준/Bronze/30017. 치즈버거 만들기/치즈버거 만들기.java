import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int ret = 0;
        if (A > B) {
            ret = B * 2 + 1;
        } else if (A == B) {
            ret = (B - 1) * 2 + 1;
        } else {
            ret = (A - 1) * 2 + 1;
        }

        bw.write(String.valueOf(ret));
        bw.flush();
    }
}
