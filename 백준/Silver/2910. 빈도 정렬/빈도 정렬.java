import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        ArrayList<Integer> list = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            int now = Integer.parseInt(st.nextToken());
            map.put(now, map.getOrDefault(now, 0) + 1);
            if (map.get(now) == 1) {
                list.add(now);
            }
        }

        Collections.sort(list, (o1, o2) -> map.get(o2) - map.get(o1));

        for (int i : list) {
            for (int j = 0; j < map.get(i); j++) {
                bw.write(i + " ");
            }
        }
        bw.flush();
    }
}
