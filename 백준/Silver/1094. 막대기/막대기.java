import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int X = Integer.parseInt(br.readLine());
        int ret = 0;
        int now = 64;

        while (X > 0) {
            if (now > X) {
                now /= 2;
            } else {
                X -= now;
                ret++;
            }
        }

        bw.write(ret + "\n");
        bw.flush();
    }
}
