import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            Set<Integer> set = new HashSet<>();
            int K = Integer.parseInt(br.readLine());
            int[] arr = new int[K];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < K; i++) {
                set.add(Integer.valueOf(st.nextToken()));
            }

            int N = Integer.parseInt(br.readLine());

            int cnt = 0;
            int ret = -1;
            int minHour = 6;
            int minMin = 59;
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                int num = Integer.parseInt(st.nextToken());
                int hour = Integer.parseInt(st.nextToken());
                int min = Integer.parseInt(st.nextToken());

                if (set.contains(num)) {
                    if (hour == -1 && min == -1) {
                        continue;
                    }
                    if (hour < 6) {
                        cnt++;
                    } else if (hour == 6 && min == 0) {
                        cnt++;
                    }

                    if (hour < minHour) {
                        ret = num;
                        minHour = hour;
                        minMin = min;
                    } else if (hour == minHour && min < minMin) {
                        ret = num;
                        minHour = hour;
                        minMin = min;
                    }
                }
            }
            sb.append(ret + " " + cnt).append("\n");
        }

        bw.write(String.valueOf(sb));
        bw.flush();
    }
}
