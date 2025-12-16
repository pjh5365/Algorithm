import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int p = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] room = new int[p];
        int[] cnt = new int[p];
        int idx = 0;
        ArrayList<ArrayList<String>> users = new ArrayList<>();
        TreeMap<String, Integer> map = new TreeMap<>();
        for (int i = 0; i < p; i++) {
            users.add(new ArrayList<>());
        }

        for (int i = 0; i < p; i++) {
            st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken());
            String n = st.nextToken();

            for (int j = 0; j <= idx; j++) {
                if (room[j] == 0) {
                    room[j]++;
                    cnt[j] = l;
                    map.put(n, l);
                    users.get(j).add(n);
                    break;
                } else if (room[j] < m && (l <= cnt[j] + 10 && cnt[j] - 10 <= l)) {
                    map.put(n, l);
                    users.get(j).add(n);
                    room[j]++;
                    break;
                } else {
                    idx++;
                }
            }
        }

        for (int i = 0; i < p; i++) {
            if (room[i] == 0) {
                break;
            }
            if (room[i] == m) {
                sb.append("Started!").append("\n");
            } else {
                sb.append("Waiting!").append("\n");
            }
            users.get(i).sort(String::compareTo);
            for (String s : users.get(i)) {
                sb.append(map.get(s)).append(" ").append(s).append("\n");
            }
        }

        bw.write( sb + "");
        bw.flush();
    }
}
