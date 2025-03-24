import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        String S = br.readLine();
        int[] arr = new int[5];
        for (int i = 0; i < n; i++) {
            if (S.charAt(i) == 'u') {
                arr[0]++;
            } else if (S.charAt(i) == 'o') {
                arr[1]++;
            } else if (S.charAt(i) == 's') {
                arr[2]++;
            } else if (S.charAt(i) == 'p') {
                arr[3]++;
            } else if (S.charAt(i) == 'c') {
                arr[4]++;
            }
        }
        Arrays.sort(arr);

        bw.write(String.valueOf(arr[0]));
        bw.flush();
    }
}
