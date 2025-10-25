import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        long B1 = Long.parseLong(br.readLine(), 2);
        long B2 = Long.parseLong(br.readLine(), 2);

        String ret = Long.toBinaryString(B1 * B2);

        bw.write(ret + "\n");
        bw.flush();
    }
}
