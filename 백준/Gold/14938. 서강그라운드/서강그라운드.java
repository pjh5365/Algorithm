import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int m;
    static int r;
    static int[] arr;
    static int[] dist;
    static ArrayList<ArrayList<Pair>> list = new ArrayList<>();
    static int ret = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        arr = new int[n + 1];
        dist = new int[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            list.get(a).add(new Pair(b, c));
            list.get(b).add(new Pair(a, c));
        }

        for (int i = 1; i <= n; i++) {
            Arrays.fill(dist, Integer.MAX_VALUE);
            dijkstra(i);
        }

        bw.write(String.valueOf(ret));
        bw.flush();
    }

    static void dijkstra(int start) {
        PriorityQueue<Pair> q = new PriorityQueue<>();
        q.add(new Pair(start, 0));
        dist[start] = 0;

        while (!q.isEmpty()) {
            Pair now = q.poll();

            if (now.cost > dist[now.end]) {
                continue;
            }

            for (Pair next : list.get(now.end)) {
                int cost = now.cost + next.cost;

                if (cost < dist[next.end]) {
                    dist[next.end] = cost;
                    q.add(new Pair(next.end, cost));
                }
            }
        }

        int sum = 0;
        for (int i = 1; i <= n; i++) {
            if (dist[i] <= m) {
                sum += arr[i];
            }
        }
        ret = Math.max(ret, sum);
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
