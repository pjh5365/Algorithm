import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        int before = 0;
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine()) + before;
            before = arr[i];
        }
        for (int i = 0; i < Q; i++) {
            int t = Integer.parseInt(br.readLine());
            for (int j = 0; j < N; j++) {
                if (t <= arr[j] - 1) {
                    sb.append(j + 1).append("\n");
                    break;
                }
            }
        }

        bw.write(String.valueOf(sb));
        bw.flush();
    }
}
