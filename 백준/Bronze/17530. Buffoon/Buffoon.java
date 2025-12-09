import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int max = 0;
        String ret = "S";
        for (int i = 0; i < N; i++) {
            int now = Integer.parseInt(br.readLine());
            if (max == 0) {
                max = now;
            } else {
                if (max < now) {
                    ret = "N";
                }
            }
        }

        bw.write(ret + "");
        bw.flush();
    }
}
