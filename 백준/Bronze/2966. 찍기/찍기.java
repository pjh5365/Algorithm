import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        String input = br.readLine();

        char[] Adrian = {'A', 'B', 'C'};
        char[] Bruno = {'B', 'A', 'B', 'C'};
        char[] Goran = {'C', 'C', 'A', 'A', 'B', 'B'};

        String[] ret = {"Adrian", "Bruno", "Goran"};

        int[] cnt = {0, 0, 0};
        int[] idx = {0, 0, 0};

        int max = 0;

        for (int i = 0; i < input.length(); i++) {
            char now = input.charAt(i);

            if (Adrian[idx[0]] == now) {
                cnt[0]++;
            }
            if (Bruno[idx[1]] == now) {
                cnt[1]++;
            }
            if (Goran[idx[2]] == now) {
                cnt[2]++;
            }

            for (int j = 0; j < 3; j++) {
                idx[j]++;
                max = Math.max(max, cnt[j]);
            }

            if (idx[0] == 3) {
                idx[0] = 0;
            }
            if (idx[1] == 4) {
                idx[1] = 0;
            }
            if (idx[2] == 6) {
                idx[2] = 0;
            }
        }

        sb.append(max).append("\n");
        for (int i = 0; i < 3; i++) {
            if (cnt[i] == max) {
                sb.append(ret[i]).append("\n");
            }
        }

        bw.write(String.valueOf(sb));
        bw.flush();
    }
}
