import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());

        int ret = t / 5;
        if (t % 5 != 0) {
            ret++;
        }

        bw.write(String.valueOf(ret));
        bw.flush();
    }
}
