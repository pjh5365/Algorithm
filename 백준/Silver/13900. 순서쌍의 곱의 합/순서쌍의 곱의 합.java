import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        long[] arr = new long[N + 1];
        long ret = 0;
        for (int i = 1; i <= N; i++) {
            int tmp = Integer.parseInt(st.nextToken());
            arr[i] = tmp + arr[i - 1];
            ret += arr[i - 1] * tmp;
        }

        bw.write(ret + "\n");
        bw.flush();
    }
}
