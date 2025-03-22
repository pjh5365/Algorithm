import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        String s = br.readLine();

        StringBuilder P = new StringBuilder("IOI");
        for (int i = 1; i < N; i++) {
            P.append("OI");
        }
        String Pn = P.toString();
        int ret = 0;
        for (int i = 0; i <= M - Pn.length(); i++) {
            if (s.startsWith(Pn, i)) {
                ret++;
            }
        }
        bw.write(String.valueOf(ret));
        bw.flush();
    }
}
