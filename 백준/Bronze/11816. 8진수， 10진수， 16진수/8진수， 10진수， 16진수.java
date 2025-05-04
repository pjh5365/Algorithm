import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String x = br.readLine();
        int ret = 0;
        if (x.startsWith("0x")) {
            ret = Integer.parseInt(x.substring(2), 16);
        } else if (x.startsWith("0")) {
            ret = Integer.parseInt(x, 8);
        } else {
            ret = Integer.parseInt(x);
        }

        bw.write(String.valueOf(ret));
        bw.flush();
    }
}
