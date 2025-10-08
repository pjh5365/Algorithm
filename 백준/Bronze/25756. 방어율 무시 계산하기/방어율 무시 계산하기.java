import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        double v = 0;
        double now;
        for (int i = 0; i < N; i++) {
            now = Double.parseDouble(st.nextToken());
            v = now + v - v * now / 100;
            sb.append(v).append("\n");
        }

        bw.write(sb + "");
        bw.flush();
    }
}
