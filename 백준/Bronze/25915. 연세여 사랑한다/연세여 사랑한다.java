import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();
        int tmp = Math.abs('I' - s.charAt(0));
        int ret = tmp + 84;

        bw.write(ret + "\n");
        bw.flush();
    }
}
