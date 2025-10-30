import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int ret = 0;
        while (st.hasMoreTokens()) {
            ret += Integer.parseInt(st.nextToken());
        }

        bw.write(ret + "\n");
        bw.flush();
    }
}
