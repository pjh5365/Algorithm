import java.io.*;
import java.util.*;

public class Main {

    static ArrayList<ArrayList<Pair>> list;
    static int[] dist;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            dist = new int[n + 1];
            list = new ArrayList<>();

            for (int i = 0; i <= n; i++) {
                dist[i] = Integer.MAX_VALUE;
                list.add(new ArrayList<>());
            }

            for (int i = 0; i < d; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int s = Integer.parseInt(st.nextToken());

                list.get(b).add(new Pair(a, s));
            }

            dijkstra(c);
        }

        bw.write(String.valueOf(sb));
        bw.flush();
    }

    static void dijkstra(int start) {
        PriorityQueue<Pair> q = new PriorityQueue<>();
        Set<Integer> s = new HashSet<>();
        q.add(new Pair(start, 0));
        dist[start] = 0;
        s.add(start);

        while (!q.isEmpty()) {
            Pair now = q.poll();

            if (now.cost > dist[now.to]) {
                continue;
            }

            for (Pair next : list.get(now.to)) {
                int cost = next.cost + now.cost;

                if (dist[next.to] > cost) {
                    dist[next.to] = cost;
                    q.add(new Pair(next.to, cost));
                    s.add(next.to);
                }
            }
        }
        int ret = 0;
        for (int i : dist) {
            if (i != 0 && i != Integer.MAX_VALUE) {
                ret = Math.max(ret, i);
            }
        }
        sb.append(s.size()).append(" ").append(ret).append("\n");
    }
    static class Pair implements Comparable<Pair> {

        int to;
        int cost;

        public Pair(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }

        @Override
        public int compareTo(Pair o) {
            return this.cost - o.cost;
        }
    }
}
