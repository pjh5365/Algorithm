import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int A = 0;
            int B = 0;

            for (int i = 0; i < 6; i++) {
                double x = Double.parseDouble(st.nextToken());
                double y = Double.parseDouble(st.nextToken());

                double tmp = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
                int score = 0;

                if (tmp <= 3) {
                    score += 100;
                } else if (tmp <= 6) {
                    score += 80;
                } else if (tmp <= 9) {
                    score += 60;
                } else if (tmp <= 12) {
                    score += 40;
                } else if (tmp <= 15) {
                    score += 20;
                }

                if (i < 3) {
                    A += score;
                } else {
                    B += score;
                }
            }
            System.out.printf("SCORE: %d to %d, %s.\n", A, B, A == B ? "TIE" : A > B ? "PLAYER 1 WINS" : "PLAYER 2 WINS");
        }


        // bw.write(ret + "\n");
        // bw.flush();
    }
}
