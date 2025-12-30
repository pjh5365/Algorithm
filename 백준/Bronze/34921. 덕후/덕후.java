import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());

        int ret = 10 + 2 * (25 - A + T);

        bw.write(Math.max(0, ret) + "");
        bw.flush();
    }
}
