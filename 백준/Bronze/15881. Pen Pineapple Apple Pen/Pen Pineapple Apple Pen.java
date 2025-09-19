import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        String s = br.readLine();
        int ret = 0;
        for (int i = 0; i <= n - 4; i++) {
            String sub = s.substring(i, i + 4);
            if (sub.equals("pPAp")) {
                ret++;
                i += 3;
            }
        }

        bw.write(String.valueOf(ret));
        bw.flush();
    }
}
