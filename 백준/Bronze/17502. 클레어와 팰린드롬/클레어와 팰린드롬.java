import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        String s = br.readLine();


        String s1 = s.substring(0, N / 2);
        String s2;

        char mid = ' ';

        if (N % 2 == 0) {
            s2 = s.substring(N / 2);
        } else {
            s2 = s.substring(N / 2 + 1);
            mid = s.charAt(N / 2);
            if (mid == '?') {
                mid = 'a';
            }
        }

        for (int i = 0; i < N / 2; i++) {
            char s1Now = s1.charAt(i);
            char s2Now = s2.charAt(s2.length() - 1 - i);
            if (s1Now == '?' && s2Now == '?') {
                sb1.append('a');
                sb2.append('a');
            } else if (s1Now == '?') {
                sb1.append(s2Now);
                sb2.append(s2Now);
            } else if (s2Now == '?') {
                sb1.append(s1Now);
                sb2.append(s1Now);
            } else {
                sb1.append(s1Now);
                sb2.append(s1Now);
            }
        }

        if (mid != ' ') {
            sb1.append(mid);
        }
        sb1.append(sb2.reverse());
        bw.write(String.valueOf(sb1));
        bw.flush();
    }
}
