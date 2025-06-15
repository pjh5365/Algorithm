import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'B') {
                sb.append("v");
            } else if (s.charAt(i) == 'E') {
                sb.append("ye");
            } else if (s.charAt(i) == 'H') {
                sb.append("n");
            } else if (s.charAt(i) == 'P') {
                sb.append("r");
            } else if (s.charAt(i) == 'C') {
                sb.append("s");
            } else if (s.charAt(i) == 'Y') {
                sb.append("u");
            } else if (s.charAt(i) == 'X') {
                sb.append("h");
            } else {
                sb.append(s.charAt(i));
            }
        }

        bw.write(sb.toString().toLowerCase());
        bw.flush();
    }
}
