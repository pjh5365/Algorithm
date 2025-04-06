import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int E;
    static ArrayList<ArrayList<Pair>> list = new ArrayList<>();
    static int[] dist;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        dist = new int[N + 1];
        Arrays.fill(dist, 200000000);
        for (int i = 0; i <= N; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            list.get(a).add(new Pair(b, c));
            list.get(b).add(new Pair(a, c));
        }
        st = new StringTokenizer(br.readLine());

        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());

        int ret1 = 0;
        ret1 += dijkstra(1, v1);
        ret1 += dijkstra(v1, v2);
        ret1 += dijkstra(v2, N);

        int ret2 = 0;
        ret2 += dijkstra(1, v2);
        ret2 += dijkstra(v2, v1);
        ret2 += dijkstra(v1, N);

        int ret = (ret1 >= 200000000 && ret2 >= 200000000) ? -1 : Math.min(ret1, ret2);

        bw.write(String.valueOf(ret));
        bw.flush();
    }

    static int dijkstra(int start, int end) {
        PriorityQueue<Pair> q = new PriorityQueue<>();
        Arrays.fill(dist, 200000000);
        dist[start] = 0;
        q.add(new Pair(start, 0));

        while (!q.isEmpty()) {
            Pair now = q.poll();

            for (Pair next : list.get(now.end)) {
                int cost = now.cost + next.cost;

                if (dist[next.end] > cost) {
                    dist[next.end] = cost;
                    q.add(new Pair(next.end, cost));
                }
            }
        }

        return dist[end];
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
