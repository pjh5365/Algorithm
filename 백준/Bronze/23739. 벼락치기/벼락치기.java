import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        int ret = 0;
        int t = 30;
        for (int i = 0; i < N; i++) {
            int tmp = t - arr[i] / 2;
            if (arr[i] % 2 != 0) {
                tmp--;
            }
            if (tmp >= 0) {
                ret++;
            }
            t -= arr[i];
            if (t <= 0) {
                t = 30;
            }
        }

        bw.write(String.valueOf(ret));
        bw.flush();
    }
}
