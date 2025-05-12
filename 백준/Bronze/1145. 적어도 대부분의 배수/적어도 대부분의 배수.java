import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] arr = new int[5];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 5; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int ret = arr[0];
        while (true) {
            int cnt = 0;

            for (int i = 0; i < 5; i++) {
                if (ret % arr[i] == 0) {
                    cnt++;
                }
            }

            if (cnt >= 3) {
                break;
            }
            ret++;
        }
        bw.write(String.valueOf(ret));
        bw.flush();
    }
}
