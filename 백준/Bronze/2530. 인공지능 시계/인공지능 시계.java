import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        int D = Integer.parseInt(br.readLine());

        while (D >= 3600) {
            D -= 3600;
            A++;
        }
        while (D >= 60) {
            D -= 60;
            B++;
        }
        C += D;
        B += C / 60;
        A += B / 60;
        A %= 24;
        B %= 60;
        C %= 60;

        bw.write(A + " " + B + " " + C);
        bw.flush();
    }
}
