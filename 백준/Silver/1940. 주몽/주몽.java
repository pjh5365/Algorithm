import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int start = 0;
        int end = N - 1;

        int ret = 0;
        while (start < end) {
            int value = arr[start] + arr[end];
            if (value < M) {
                start++;
            } else if (value > M) {
                end--;
            } else {
                ret++;
                start++;
            }
        }

        bw.write(String.valueOf(ret));
        bw.flush();
    }
}
