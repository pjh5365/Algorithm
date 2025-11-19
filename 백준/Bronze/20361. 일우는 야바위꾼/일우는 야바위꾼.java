import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] arr = new int[N + 1];
        arr[X] = 1;

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int tmp = arr[A];
            arr[A] = arr[B];
            arr[B] = tmp;
        }

        int ret = 0;
        for (int i = 1; i <= N; i++) {
            if (arr[i] != 0) {
                ret = i;
                break;
            }
        }

        bw.write(ret + "\n");
        bw.flush();
    }
}
