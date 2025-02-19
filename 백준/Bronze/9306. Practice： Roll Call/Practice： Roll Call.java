import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        for (int i = 1; i <= N; i++) {
            String s1 = br.readLine();
            String s2 = br.readLine();
            sb.append("Case ").append(i).append(": ").append(s2).append(", ").append(s1).append("\n");
        }

        bw.write(String.valueOf(sb));
        bw.flush();
    }
}
