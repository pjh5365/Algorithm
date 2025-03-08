import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            if (i % 2 == 0) {
                for (int j = 0; j < N; j++) {
                    sb.append("* ");
                }
            } else {
                for (int j = 0; j < N; j++) {
                    sb.append(" *");
                }
            }
            sb.append("\n");
        }
        bw.write(String.valueOf(sb));
        bw.flush();
    }
}
