import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        while (n-- > 0) {
            int p = Integer.parseInt(br.readLine());
            int max = 0;
            String ret = "";
            for (int i = 0; i < p; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int C = Integer.parseInt(st.nextToken());
                String name = st.nextToken();

                if (max < C) {
                    ret = name;
                    max = C;
                }
            }
            sb.append(ret).append("\n");
        }

        bw.write(sb + "");
        bw.flush();
    }
}
