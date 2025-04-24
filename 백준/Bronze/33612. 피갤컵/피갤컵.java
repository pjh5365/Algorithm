import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int year = 2024;
        int month = 8;

        for (int i = 1; i < N; i++) {
            month += 7;
            if (month > 12) {
                month -= 12;
                year++;
            }
        }

        bw.write(year + " " + month);
        bw.flush();
    }
}
