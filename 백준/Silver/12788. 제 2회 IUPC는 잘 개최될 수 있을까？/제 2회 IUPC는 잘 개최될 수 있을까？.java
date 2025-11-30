import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int total = M * K;
        int ret = -1;
        int cnt = 0;
        for (int i = arr.length - 1; i >= 0; i--) {
            total -= arr[i];
            cnt++;
            if (total <= 0) {
                ret = cnt;
                break;
            }
        }

        if (ret == -1) {
            bw.write(String.valueOf("STRESS"));
        } else {
            bw.write(String.valueOf(ret));
        }

        bw.flush();
    }
}
