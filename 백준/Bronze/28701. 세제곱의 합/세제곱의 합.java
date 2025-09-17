import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        int total = 0;
        for (int i = 1; i <= N; i++) {
            total += i;
        }
        sb.append(total).append("\n");
        sb.append(total * total).append("\n");

        total = 0;
        for (int i = 1; i <= N; i++) {
            total += i * i * i;
        }
        sb.append(total).append("\n");

        bw.write(String.valueOf(sb));
        bw.flush();
    }
}
