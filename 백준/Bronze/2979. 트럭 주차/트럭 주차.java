import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] fee = new int[3];
        fee[0] = Integer.parseInt(st.nextToken());
        fee[1] = Integer.parseInt(st.nextToken());
        fee[2] = Integer.parseInt(st.nextToken());

        int[] arr = new int[101];
        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            for (int j = start; j < end; j++) {
                arr[j]++;
            }
        }

        int ret = 0;
        for (int i = 1; i <= 100; i++) {
            if (arr[i] > 0) {
                ret += fee[arr[i] - 1] * arr[i];
            }
        }

        bw.write(String.valueOf(ret));
        bw.flush();
    }
}
