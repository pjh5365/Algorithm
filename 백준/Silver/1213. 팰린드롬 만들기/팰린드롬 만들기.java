import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        String s = br.readLine();
        int[] arr = new int[26];
        for (int i = 0; i < s.length(); i++) {
            arr[s.charAt(i) - 'A']++;
        }

        boolean flag = true;
        char mid = '-';
        for (int i = 0; i < arr.length; i++) {
            if (mid == '-' && arr[i] % 2 != 0) {
                mid = (char)('A' + i);
            } else if (mid != '-' && arr[i] % 2 != 0) {
                flag = false;
            }
        }

        String ret = null;
        if (!flag) {
            ret = "I'm Sorry Hansoo";
        } else {
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] != 0) {
                    for (int j = 0; j < arr[i] / 2; j++) {
                        sb.append((char)('A' + i));
                    }
                }
            }
            String end = String.valueOf(sb.reverse());
            sb.reverse();
            if (mid != '-') {
                sb.append(mid);
            }
            ret = sb + end;
        }

        bw.write(String.valueOf(ret));
        bw.flush();
    }
}
