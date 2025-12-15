import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] intArr;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        String[] strArr = new String[N];
        intArr = new int[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            strArr[i] = st.nextToken();
            intArr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < M; i++) {
            int now = Integer.parseInt(br.readLine());
            int idx = binarySearch(now);
            sb.append(strArr[idx]).append("\n");
        }

        bw.write(sb + "");
        bw.flush();
    }

    static int binarySearch(int key) {
        int start = 0;
        int end = N - 1;
        int idx = 0;

        while (start <= end) {
            int mid = (start + end) / 2;
            if (key > intArr[mid]) {
                start = mid + 1;
            } else if (key <= intArr[mid]) {
                end = mid - 1;
                idx = mid;
            }
        }
        return idx;
    }
}
