import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine(), ",");
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= K; i++) {
            for (int j = 0; j < N - i; j++) {
                arr[j] = arr[j + 1] - arr[j];
            }
        }

        for (int i = 0; i < N - K - 1; i++) {
            bw.write(arr[i] + ",");
        }
        bw.write(arr[N - K - 1] + " ");
        bw.flush();
    }
}
