import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();
        int key = s.charAt(0) ^ 'C';

        for (int i = 0; i < s.length(); i++) {
            System.out.print((char)(s.charAt(i) ^ key));
        }

        // bw.write(ret + "\n");
        bw.flush();
    }
}
