import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        String  M = new StringBuilder(br.readLine()).reverse().toString();
        int K = Integer.parseInt(br.readLine());

        boolean flag = true;
        for (int i = 0; i < Math.min(M.length(), K); i++) {
            if (M.charAt(i) == '1') {
                flag = false;
                break;
            }
        }

        if (flag) {
            bw.write("YES");
        } else {
            bw.write("NO");
        }

        bw.flush();
    }
}
