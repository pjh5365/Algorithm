import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            T -= Integer.parseInt(st.nextToken());
        }

        if (T <= 0) {
            bw.write("Padaeng_i Happy \n");
        } else {
            bw.write("Padaeng_i Cry \n");
        }

        bw.flush();
    }
}
