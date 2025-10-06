import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        long ret = 0;
        for (int i = 1; i <= N; i++) {
            ret += i;
        }

        bw.write(ret + "");
        bw.flush();
    }
}
