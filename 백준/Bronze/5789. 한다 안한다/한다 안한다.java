import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            String s = br.readLine();

            if (s.charAt(s.length() / 2 - 1) == s.charAt(s.length() / 2)) {
                sb.append("Do-it\n");
            } else {
                sb.append("Do-it-Not\n");
            }
        }


        bw.write(sb + "\n");
        bw.flush();
    }
}
