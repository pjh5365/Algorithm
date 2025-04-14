import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] map = new int[3];
        int[] minBefore = new int[3];
        int[] minAfter = new int[3];
        int[] maxBefore = new int[3];
        int[] maxAfter = new int[3];
        int[] dy = {-1, 0, 1};
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                map[j] = Integer.parseInt(st.nextToken());
            }
            if (i == 0) {
                minBefore[0] = map[0];
                minBefore[1] = map[1];
                minBefore[2] = map[2];
                maxBefore[0] = map[0];
                maxBefore[1] = map[1];
                maxBefore[2] = map[2];
            } else {
                for (int j = 0; j < 3; j++) {
                    int min = Integer.MAX_VALUE;
                    int max = 0;
                    for (int k = 0; k < 3; k++) {
                        int y = j + dy[k];

                        if (y < 0 || y > 2) {
                            continue;
                        }

                        min = Math.min(min, map[j] + minBefore[y]);
                        max = Math.max(max, map[j] + maxBefore[y]);
                    }
                    minAfter[j] = min;
                    maxAfter[j] = max;
                }
                for (int j = 0; j < 3; j++) {
                    minBefore[j] = minAfter[j];
                    maxBefore[j] = maxAfter[j];
                }
            }
        }



        int max = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < 3; i++) {
            min = Math.min(min, minBefore[i]);
            max = Math.max(max, maxBefore[i]);
        }

        bw.write(max + " " + min);
        bw.flush();
    }
}
