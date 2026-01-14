import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int ret = 0;

        while (A - 2 >= 0 && B - 1 >= 0) {
            A -= 2;
            B--;
            ret++;
        }

        bw.write(ret + "");
        bw.flush();
    }
}
