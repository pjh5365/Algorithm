import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int cnt = 1;
        int now = 666;
        while (true) {
            if (cnt == N) {
                break;
            }
            now++;
            String s = String.valueOf(now);
            if (s.contains("666")) {
                cnt++;
            }
        }

        bw.write(now + "");
        bw.flush();
    }
}
