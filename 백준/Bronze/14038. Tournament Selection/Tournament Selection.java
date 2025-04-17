import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int W = 0;
        int L = 0;
        for (int i = 0; i < 6; i++) {
            String s = br.readLine();
            if (s.equals("W")) {
                W++;
            } else {
                L++;
            }
        }
        
        int ret = -1;
        if (W >= 5) {
            ret = 1;
        } else if (W >= 3) {
            ret = 2;
        } else if (W >= 1) {
            ret = 3;
        }

        bw.write(String.valueOf(ret));
        bw.flush();
    }
}
