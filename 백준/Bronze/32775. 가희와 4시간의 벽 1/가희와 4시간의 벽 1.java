import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int S = Integer.parseInt(br.readLine());
        int F = Integer.parseInt(br.readLine());

        if (S <= F) {
            bw.write("high speed rail");
        } else {
            bw.write("flight");
        }
        bw.flush();
    }
}
