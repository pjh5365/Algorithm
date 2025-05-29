import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        Set<Character> set = new HashSet<>(List.of('a', 'e', 'i', 'o', 'u'));

        while (true) {
            String s = br.readLine();
            if (s.equals("end")) {
                break;
            }

            int cnt1 = 0;
            int cnt2 = 0;
            boolean flag1 = false;
            boolean flag2 = true;
            boolean flag3 = true;
            for (int i = 0; i < s.length(); i++) {
                if (set.contains(s.charAt(i))) {
                    flag1 = true;
                    cnt1++;
                    cnt2 = 0;
                } else {
                    cnt1 = 0;
                    cnt2++;
                }

                if (cnt1 == 3 || cnt2 == 3) {
                    flag2 = false;
                    break;
                }

                if (i > 0) {
                    if (s.charAt(i) != 'e' && s.charAt(i) != 'o' && s.charAt(i - 1) == s.charAt(i)) {
                        flag3 = false;
                    }
                }

            }

            if (flag1 && flag2 && flag3) {
                sb.append("<").append(s).append(">").append(" is acceptable.\n");
            } else {
                sb.append("<").append(s).append(">").append(" is not acceptable.\n");
            }
        }

        bw.write(sb + " ");
        bw.flush();
    }
}
