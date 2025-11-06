import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            String x = br.readLine();
            int[] arr = new int[10];
            for (int i = 0; i < x.length(); i++) {
                arr[x.charAt(i) - '0']++;
            }

            int ret = 0;
            for (int i = 0; i < 10; i++) {
                if (arr[i] != 0) {
                    ret++;
                }
            }
            sb.append(ret).append("\n");
        }
        
        bw.write(sb + "\n");
        bw.flush();
    }
}
