import java.io.*;
import java.util.*;

public class Main {

    static ArrayList<ArrayList<Pair>> list = new ArrayList<>();
    static int[] dist;
    static int[] before;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        dist = new int[n + 1];
        before = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
            dist[i] = Integer.MAX_VALUE;
        }

        StringTokenizer st;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            list.get(a).add(new Pair(b, c));
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        dijkstra(start);
        sb.append(dist[end]).append("\n");

        ArrayDeque<Integer> visited = new ArrayDeque<>();
        visited.push(end);
        while (before[end] != 0) {
            visited.push(before[end]);
            end = before[end];
        }
        sb.append(visited.size()).append("\n");
        for (int i : visited) {
            sb.append(i).append(" ");
        }

        bw.write(String.valueOf(sb));
        bw.flush();
    }

    static void dijkstra(int start) {
        PriorityQueue<Pair> q = new PriorityQueue<>();
        q.add(new Pair(start, 0));
        dist[start] = 0;
        while (!q.isEmpty()) {
            Pair now = q.poll();

            if (dist[now.end] < now.cost) {
                continue;
            }

            for (Pair next : list.get(now.end)) {
                int cost = now.cost + next.cost;
                if (dist[next.end] > cost) {
                    dist[next.end] = cost;
                    before[next.end] = now.end;
                    q.add(new Pair(next.end, cost));
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
