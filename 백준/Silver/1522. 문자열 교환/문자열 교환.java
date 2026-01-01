import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();
        int aCnt = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'a') {
                aCnt++;
            }
        }

        int ret = Integer.MAX_VALUE;

        for (int i = 0; i < s.length(); i++) {
            int cnt = 0;
            for (int j = i; j < i + aCnt; j++) {
                if (s.charAt(j % s.length()) == 'b') {
                    cnt++;
                }
            }
            ret = Math.min(ret, cnt);
        }

        bw.write(ret + "");
        bw.flush();
    }
}
