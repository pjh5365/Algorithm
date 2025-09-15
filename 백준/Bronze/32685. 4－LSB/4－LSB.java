import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
        int c = Integer.parseInt(br.readLine());

        String A = fun(Integer.toBinaryString(a));
        String B = fun(Integer.toBinaryString(b));
        String C = fun(Integer.toBinaryString(c));


        int ret = Integer.parseInt(A + B + C, 2);

        System.out.printf("%04d", ret);
    }

    static String fun(String s) {
        String ret = "";

        if (s.length() > 4) {
            return s.substring(s.length() - 4);
        }
        for (int i = 0; i < 4 - s.length(); i++) {
            ret += "0";
        }
        return ret + s;
    }
}
