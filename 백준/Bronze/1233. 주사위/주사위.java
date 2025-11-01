import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int S1 = Integer.parseInt(st.nextToken());
        int S2 = Integer.parseInt(st.nextToken());
        int S3 = Integer.parseInt(st.nextToken());

        int ret = 0;
        int maxCnt = 0;
        int[] arr = new int[81];
        for (int i = 1; i <= S1; i++) {
            for (int j = 1; j <= S2; j++) {
                for (int k = 1; k <= S3; k++) {
                    int now = i + j + k;
                    arr[now]++;
                    if (arr[now] >= maxCnt) {
                        if (arr[now] == maxCnt) {
                            ret = Math.min(ret, now);
                        } else {
                            ret = now;
                            maxCnt = arr[now];
                        }
                    }
                }
            }
        }

        bw.write(ret + "\n");
        bw.flush();
    }
}
