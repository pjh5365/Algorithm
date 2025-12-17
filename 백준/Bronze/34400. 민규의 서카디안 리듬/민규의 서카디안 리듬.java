import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            int t = Integer.parseInt(br.readLine());
            t %= 25;
            if (t < 17) {
                sb.append("ONLINE").append("\n");
            } else {
                sb.append("OFFLINE").append("\n");
            }
        }

        bw.write(sb + "");
        bw.flush();
    }
}
