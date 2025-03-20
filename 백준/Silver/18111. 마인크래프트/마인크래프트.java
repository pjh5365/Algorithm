import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N][M];
        int maxLen = 0;
        int minLen = Integer.MAX_VALUE;
        int retTime = Integer.MAX_VALUE;
        int retLen = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                maxLen = Math.max(maxLen, arr[i][j]);
                minLen = Math.min(minLen, arr[i][j]);
            }
        }

        for (int i = maxLen; i >= minLen; i--) {
            int time = 0;
            int block = B;

            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if (arr[j][k] > i) {
                        block += arr[j][k] - i;
                        time += 2 * (arr[j][k] - i);
                    } else if (arr[j][k] < i) {
                        block -= i - arr[j][k];
                        time += i - arr[j][k];
                    }
                }
            }

            if (block >= 0 && retTime > time) {
                retLen = i;
                retTime = time;
            }
        }

        bw.write(retTime + " " + retLen);
        bw.flush();
    }
}
