import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            int N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());

            Map<Integer, Integer> map = new HashMap<>();
            int[] arr = new int[2 * N];
            for (int i = 0; i < 2 * N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
                map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
            }

            sb.append("Case #").append(t).append(": ");
            ArrayList<Integer> answer = new ArrayList<>();
            for (int i = 2 * N - 1; i >= 1; i--) {
                int now = arr[i];
                if (map.get(now) == 0)
                    continue;
                map.put(now, map.get(now) - 1);
                int tmp = now - now / 4;
                answer.add(tmp);
                map.put(tmp, map.get(tmp) - 1);
            }

            Collections.sort(answer);
            for (int i : answer) {
                sb.append(i).append(" ");
            }
            sb.append("\n");
        }

        bw.write(String.valueOf(sb));
        bw.flush();
    }
}
