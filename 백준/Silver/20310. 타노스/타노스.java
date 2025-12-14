import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String S = br.readLine();
        int cnt1 = 0;
        int cnt2 = 0;
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == '0') {
                cnt1++;
            } else {
                cnt2++;
            }
        }

        if (cnt1 != 0) {
            cnt1 /= 2;
        }
        if (cnt2 != 0) {
            cnt2 /= 2;
        }

        StringBuilder sb = new StringBuilder(S);

        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == '1') {
                sb.setCharAt(i, '2');
                cnt2--;
                if (cnt2 == 0) {
                    break;
                }
            }
        }

        for (int i = S.length() - 1; i >= 0; i--) {
            if (S.charAt(i) == '0') {
                sb.setCharAt(i, '2');
                cnt1--;
                if (cnt1 == 0) {
                    break;
                }
            }
        }

        StringBuilder s = new StringBuilder();
        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) != '2') {
                s.append(sb.charAt(i));
            }
        }

        bw.write(s + "");
        bw.flush();
    }
}
