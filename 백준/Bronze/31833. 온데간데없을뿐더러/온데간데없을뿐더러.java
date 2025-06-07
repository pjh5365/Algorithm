import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        String A;
        String B;
        A = br.readLine().replace(" ", "");
        long X = Long.parseLong(A);
        B = br.readLine().replace(" ", "");
        long Y = Long.parseLong(B);

        long ret = Math.min(X, Y);

        bw.write(ret + " ");
        bw.flush();
    }
}
