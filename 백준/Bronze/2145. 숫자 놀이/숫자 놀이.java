import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        String s;
        while (true) {
            s = br.readLine();
            if (s.equals("0")) {
                break;
            }
            while (s.length() != 1) {
                int sum = 0;
                for (int i = 0; i < s.length(); i++) {
                    sum += s.charAt(i) - '0';
                }
                s = String.valueOf(sum);
            }
            sb.append(s).append("\n");
        }

        bw.write(String.valueOf(sb));
        bw.flush();
    }
}
