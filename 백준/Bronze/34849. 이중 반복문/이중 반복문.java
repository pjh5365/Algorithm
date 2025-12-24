import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        String ret = "";
        if (Math.pow(N, 2) <= 1e8) {
            ret = "Accepted";
        } else {
            ret = "Time limit exceeded";
        }

        bw.write(ret + "");
        bw.flush();
    }
}
