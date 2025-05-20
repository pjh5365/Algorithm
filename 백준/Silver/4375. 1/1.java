import java.io.*;
import java.math.BigDecimal;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        String input;
        while ((input = br.readLine()) != null) {
            int n = Integer.parseInt(input);
            int num = 0;
            for (int i = 1; ; i++) {
                num = (num * 10 + 1) % n;
                if (num == 0) {
                    sb.append(i).append("\n");
                    break;
                }
            }
        }

        bw.write(String.valueOf(sb));
        bw.flush();
    }
}
