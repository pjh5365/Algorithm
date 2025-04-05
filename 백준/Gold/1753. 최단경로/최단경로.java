import java.io.*;
import java.util.*;

public class Main {

    static ArrayList<ArrayList<Pair>> list = new ArrayList<>();
    static int[] dist;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(br.readLine());

        dist = new int[V + 1];
        for (int i = 0; i <= V; i++) {
            list.add(new ArrayList<>());
            dist[i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            list.get(u).add(new Pair(v, w));
        }

        dijkstra(K);

        for (int i = 1; i <= V; i++) {
            sb.append(dist[i] == Integer.MAX_VALUE ? "INF" : dist[i]).append("\n");
        }

        bw.write(String.valueOf(sb));
        bw.flush();
    }

    static void dijkstra(int start) {
        PriorityQueue<Pair> q = new PriorityQueue<>();
        q.add(new Pair(start, 0));
        dist[start] = 0;

        while (!q.isEmpty()) {
            Pair get = q.poll();

            for (Pair pair : list.get(get.end)) {
                int cost = get.cost + pair.cost;
                if (cost < dist[pair.end]) {
                    dist[pair.end] = cost;
                    q.add(new Pair(pair.end, cost));
                }
            }
        }
    }

    static class Pair implements Comparable<Pair> {
        int end;
        int cost;

        public Pair(int end, int cost) {
            this.end = end;
            this.cost = cost;
        }

        @Override
        public int compareTo(Pair o) {
            return this.cost - o.cost;
        }
    }
}
