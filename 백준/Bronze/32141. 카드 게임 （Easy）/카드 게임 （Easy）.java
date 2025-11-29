import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());

        int[] d = new int[N];
        st = new StringTokenizer(br.readLine());
        int ret = -1;
        for (int i = 0; i < N; i++) {
            d[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N; i++) {
            H -= d[i];
            if (H <= 0) {
                ret = i + 1;
                break;
            }
        }

        bw.write(String.valueOf(ret));
        bw.flush();
    }
}
