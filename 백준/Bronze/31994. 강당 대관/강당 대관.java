import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int max = 0;
        String ret = "";

        for (int i = 0; i < 7; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            int num = Integer.parseInt(st.nextToken());

            if (num > max) {
                max = num;
                ret = s;
            }
        }

        bw.write(ret + "\n");
        bw.flush();
    }
}
