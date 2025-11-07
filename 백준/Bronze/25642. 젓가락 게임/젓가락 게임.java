import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        while (true) {
            B += A;
            if (B >= 5) {
                bw.write("yt");
                break;
            }
            A += B;
            if (A >= 5) {
                bw.write("yj");
                break;
            }
        }

        bw.flush();
    }
}
