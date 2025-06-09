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
        long ret;
        if (arr[1] - arr[0] == arr[2] - arr[1]) {
            ret = arr[N - 1] + arr[1] - arr[0];
        } else {
            ret = (long)arr[N - 1] * arr[1] / arr[0];
        }

        bw.write(ret + " ");
        bw.flush();
    }
}
