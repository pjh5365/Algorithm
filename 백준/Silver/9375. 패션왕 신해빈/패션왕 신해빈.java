import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine());
            Map<String, Integer> map = new HashMap<>();
            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String a = st.nextToken();
                String b = st.nextToken();

                map.put(b, map.getOrDefault(b, 1) + 1);
            }
            int ret = 1;
            for (String key : map.keySet()) {
                int value = map.get(key);
                ret *= value;
            }
            ret--; // 아무것도 안입는 경우 제거
            sb.append(ret).append("\n");
        }

        bw.write(String.valueOf(sb));
        bw.flush();
    }
}
