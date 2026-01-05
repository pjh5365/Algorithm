import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        int[] arr = new int[W];
        for (int i = 0; i < W; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int ret = 0;
        for (int i = 1; i < W; i++) {
            int left = 0;
            int right = 0;
            for (int j = 0; j < i; j++) {
                left = Math.max(left, arr[j]);
            }
            for (int j = i + 1; j < W; j++) {
                right = Math.max(right, arr[j]);
            }
            if (arr[i] < left && arr[i] < right) {
                ret += Math.min(left, right) - arr[i];
            }
        }

        bw.write(ret + "");
        bw.flush();
    }
}
