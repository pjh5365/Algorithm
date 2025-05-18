import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        String s = br.readLine();
        for (int i = 0; i < s.length(); i++) {
            char now = s.charAt(i);
            if (s.charAt(i) >= 'a' && s.charAt(i) <= 'z') {
                now = (char)('a' + (now - 'a' + 13) % 26);
            } else if (s.charAt(i) >= 'A' && s.charAt(i) <= 'Z') {
                now = (char)('A' + (now - 'A' + 13) % 26);
            }
            sb.append(now);
        }

        bw.write(String.valueOf(sb));
        bw.flush();
    }
}
