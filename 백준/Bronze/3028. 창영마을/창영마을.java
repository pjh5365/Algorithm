import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();
        int[] arr = new int[4];
        arr[1] = 1;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'A') {
                int tmp = arr[1];
                arr[1] = arr[2];
                arr[2] = tmp;
            } else if (s.charAt(i) == 'B') {
                int tmp = arr[2];
                arr[2] = arr[3];
                arr[3] = tmp;
            } else if (s.charAt(i) == 'C') {
                int tmp = arr[1];
                arr[1] = arr[3];
                arr[3] = tmp;
            }
        }

        int ret = 1;
        for (int i = 1; i < 4; i++) {
            if (arr[i] == 1) {
                ret = i;
            }
        }

        bw.write(ret + "");
        bw.flush();
    }
}
