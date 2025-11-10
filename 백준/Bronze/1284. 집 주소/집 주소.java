import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        String s;
        while (!(s = br.readLine()).equals("0")) {
            int ret = 1;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '1') {
                    ret += 2;
                } else if (s.charAt(i) == '0') {
                    ret += 4;
                } else {
                    ret += 3;
                }
                ret++;
            }
            sb.append(ret).append("\n");
        }

        bw.write(sb + "\n");
        bw.flush();
    }
}
