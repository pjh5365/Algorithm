import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            String cmd = br.readLine();

            if (cmd.length() != 7) {
                sb.append("0").append("\n");
                continue;
            }
            char a = cmd.charAt(0);
            char b = cmd.charAt(2);

            char[] arr = {a, a, b, b, a, b, b};
            String s = new String(arr);
            if (a != b && cmd.equals(s)) {
                sb.append("1").append("\n");
            } else {
                sb.append("0").append("\n");
            }
        }

        bw.write(String.valueOf(sb));
        bw.flush();
    }
}
