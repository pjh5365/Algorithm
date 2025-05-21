import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[101];
        int ret = 0;
        for (int i = 0; i < N; i++) {
            int now = Integer.parseInt(st.nextToken());
            arr[now]++;
            if (arr[now] > 1) {
                ret++;
            }
        }

        bw.write(String.valueOf(ret));
        bw.flush();
    }
}
