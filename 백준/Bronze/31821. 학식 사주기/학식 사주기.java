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
        int M = Integer.parseInt(br.readLine());
        int ret = 0;
        for (int i = 0; i < M; i++) {
            int tmp = Integer.parseInt(br.readLine());
            ret += arr[tmp - 1];
        }

        bw.write(String.valueOf(ret));
        bw.flush();
    }
}
