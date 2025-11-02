import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        String s = br.readLine();

        int ret = 1;
        if ((s.charAt(N - 1) == 'y' || s.charAt(N - 1) == 'u' || s.charAt(N - 1) == 'i' || s.charAt(N - 1) == 'o'
                || s.charAt(N - 1) == 'p' || s.charAt(N - 1) == 'h' || s.charAt(N - 1) == 'j' || s.charAt(N - 1) == 'k')
                || s.charAt(N - 1) == 'l' || s.charAt(N - 1) == 'b' || s.charAt(N - 1) == 'n'
                || s.charAt(N - 1) == 'm') {
            ret = 0;
        }

        bw.write(ret + "\n");
        bw.flush();
    }
}
