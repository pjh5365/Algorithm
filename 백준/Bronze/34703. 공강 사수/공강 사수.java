import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[6];
        for (int i = 0; i < N; i++) {
            int tmp = Integer.parseInt(br.readLine());
            arr[tmp] = 1;
        }
        String ret = "NO";
        for (int i = 1; i <= 5; i++) {
            if (arr[i] == 0) {
                ret = "YES";
            }
        }

        bw.write(ret + "");
        bw.flush();
    }
}
