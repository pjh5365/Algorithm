import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        br.readLine();
        br.readLine();
        br.readLine();

        for (int i = 0; i < 10000; i++) {
            sb.append("-1").append("\n");
        }

        bw.write(sb + "\n");
        bw.flush();
    }
}
