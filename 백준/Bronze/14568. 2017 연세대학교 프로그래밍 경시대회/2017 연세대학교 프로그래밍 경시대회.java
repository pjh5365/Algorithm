import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int ret = 0;
        for (int A = 1; A <= N; A++) {
            for (int B = 1; B <= N; B++) {
                for (int C = 1; C <= N; C++) {
                    if (A + B + C == N) {
                        if (A >= B + 2 && C % 2 == 0) {
                            ret++;
                        }
                    }
                }
            }
        }

        bw.write(ret + "");
        bw.flush();
    }
}
