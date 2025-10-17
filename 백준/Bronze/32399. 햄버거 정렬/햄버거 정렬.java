import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();
        int ret = 0;
        if (s.equals("(1)")) {
            ret = 0;
        } else if (s.charAt(1) == '1') {
            ret = 2;
        } else {
            ret = 1;
        }

        bw.write(ret + "\n");
        bw.flush();
    }
}
