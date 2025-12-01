import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();
        int[] arr = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            arr[i] = s.charAt(i) - '0';
        }

        boolean flag = true;

        if (s.length() > 1) {
            int tmp = arr[0] - arr[1];
            for (int i = 1; i < s.length() - 1; i++) {
                if (arr[i] - arr[i + 1] != tmp) {
                    flag = false;
                    break;
                }
            }
        }

        String ret = "◝(⑅•ᴗ•⑅)◜..°♡ 뀌요미!!";
        if (!flag) {
            ret = "흥칫뿡!! <(￣ ﹌ ￣)>";
        }

        bw.write(ret);
        bw.flush();
    }
}
