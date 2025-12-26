import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();
        double ret = 0;
        for (int i = 0; i < s.length(); i++) {
            s = s.charAt(s.length() - 1) + s.substring(0, s.length() - 1);
            ret += Double.parseDouble(s);
        }

        System.out.printf("%.0f\n", ret);
        bw.flush();
    }
}
