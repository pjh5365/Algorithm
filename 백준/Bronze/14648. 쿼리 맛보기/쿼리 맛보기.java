import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        while (q-- > 0) {
            st = new StringTokenizer(br.readLine());
            int Q = Integer.parseInt(st.nextToken());
            double sum = 0;

            if (Q == 1) {
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                for (int i = a; i <= b; i++) {
                    sum += arr[i];
                }
                int tmp = arr[a];
                arr[a] = arr[b];
                arr[b] = tmp;
            } else {
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                int d = Integer.parseInt(st.nextToken());

                for (int i = a; i <= b; i++) {
                    sum += arr[i];
                }
                for (int i = c; i <= d; i++) {
                    sum -= arr[i];
                }
            }
            System.out.printf("%.0f \n", sum);
        }
    }
}
