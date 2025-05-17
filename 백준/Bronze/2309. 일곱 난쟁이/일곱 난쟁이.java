import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int[] p = new int[9];

        for (int i = 0; i < 9; i++) {
            p[i] = Integer.parseInt(br.readLine());
        }
        
        Arrays.sort(p);

        for (int i = 0; i < 9; i++) {
            for (int j = i + 1; j < 9; j++) {
                int sum = 0;
                for (int k = 0; k < 9; k++) {
                    if (k == i || k == j) {
                        continue;
                    }
                    sum += p[k];
                    sb.append(p[k]).append("\n");
                }
                if (sum == 100) {
                    bw.write(String.valueOf(sb));
                    bw.flush();
                    return;
                } else {
                    sb.delete(0, sb.length());
                }
            }
        }
    }
}
