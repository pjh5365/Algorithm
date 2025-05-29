import java.io.*;
import java.math.BigDecimal;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        ArrayList<BigDecimal> list = new ArrayList<>();
        while (N-- > 0) {
            String s = br.readLine();
            StringBuilder tmp = new StringBuilder();
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                    tmp.append(s.charAt(i));
                } else {
                    if (tmp.length() != 0) {
                        list.add(new BigDecimal(tmp.toString()));
                        tmp = new StringBuilder();
                    }
                }
            }
            if (tmp.length() != 0) {
                list.add(new BigDecimal(tmp.toString()));
            }
        }
        list.sort(BigDecimal::compareTo);

        for (BigDecimal i : list) {
            bw.write(i + " \n");
        }
        bw.flush();
    }
}
