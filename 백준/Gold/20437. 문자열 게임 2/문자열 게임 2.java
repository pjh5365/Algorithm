import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            String W = br.readLine();
            int K = Integer.parseInt(br.readLine());
            int min = Integer.MAX_VALUE;
            int max = 0;

            if (K == 1) {
                sb.append("1 1 \n");
                continue;
            }

            int[] arr = new int[26];
            for (int i = 0; i < W.length(); i++) {
                arr[W.charAt(i) - 'a']++;
            }

            for (int i = 0; i <= W.length() - K; i++) {
                if (arr[W.charAt(i) - 'a'] >= K) {
                    int cnt = 1;
                    for (int j = i + 1; j < W.length(); j++) {
                        if (W.charAt(i) == W.charAt(j)) {
                            cnt++;
                        }

                        if (cnt == K) {
                            int len = j - i + 1;
                            min = Math.min(min, len);
                            max = Math.max(max, len);
                            break;
                        }
                    }
                }
            }
            if (min == Integer.MAX_VALUE || max == 0) {
                sb.append(-1).append("\n");
            }
            else {
                sb.append(min + " " + max).append("\n");
            }
        }

        bw.write(sb + "");
        bw.flush();
    }
}
