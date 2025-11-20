import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            double num = Double.parseDouble(st.nextToken());
            while (st.hasMoreTokens()) {
                String s = st.nextToken();

                if (s.equals("@")) {
                    num *= 3;
                } else if (s.equals("%")) {
                    num += 5;
                } else {
                    num -= 7;
                }
            }
            System.out.printf("%.2f \n", num);
        }
    }
}
