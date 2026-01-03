import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] dist = new int[N + 1];
        ArrayList<ArrayList<Pair>> graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
            dist[i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph.get(a).add(new Pair(b, c));
            graph.get(b).add(new Pair(a, c));
        }

        PriorityQueue<Pair> q = new PriorityQueue<>();
        dist[1] = 0;
        q.add(new Pair(1, 0));
        while (!q.isEmpty()) {
            Pair now = q.poll();

            for (Pair pair : graph.get(now.end)) {
                int cost = now.cost + pair.cost;
                if (cost < dist[pair.end]) {
                    dist[pair.end] = cost;
                    q.add(new Pair(pair.end, cost));
                }
            }
        }

        bw.write(dist[N] + "");
        bw.flush();
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
            return Integer.compare(this.cost, o.cost);
        }
    }
}
