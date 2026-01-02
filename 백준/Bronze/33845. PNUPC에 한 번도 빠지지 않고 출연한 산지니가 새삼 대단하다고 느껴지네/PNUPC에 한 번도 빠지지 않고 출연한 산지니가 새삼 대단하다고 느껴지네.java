import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String S = br.readLine();
        String T = br.readLine();

        for (int i = 0; i < S.length(); i++) {
            T = T.replace(S.charAt(i), ' ');
        }
        String ret = "";
        for (int i = 0; i < T.length(); i++) {
            if (T.charAt(i) == ' ') {
                continue;
            }
            ret += T.charAt(i);
        }

        bw.write(ret + "");
        bw.flush();
    }
}
