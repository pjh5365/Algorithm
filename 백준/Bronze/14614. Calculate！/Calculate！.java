import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        String C = st.nextToken();

        int ret = A ^ B;
        if ((C.charAt(C.length() - 1) - '0') % 2 == 0) {
            ret ^= B;
        }

        bw.write(String.valueOf(ret));
        bw.flush();
    }
}
