import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int ret = 0;
        for (int i = 0; i < N; i++) {
            int now = Integer.parseInt(br.readLine());
            ret += now;
        }
        ret -= N - 1;

        bw.write(ret + "\n");
        bw.flush();
    }
}
