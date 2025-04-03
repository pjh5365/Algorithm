import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int M;
    static ArrayList<ArrayList<Pair>> arr = new ArrayList<>();
    static int[] dist;
    static boolean[] visited;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        StringTokenizer st;

        dist = new int[N + 1];
        visited = new boolean[N + 1];

        for (int i = 0; i <= N; i++) {
            arr.add(new ArrayList<>());
            dist[i] = Integer.MAX_VALUE;
        }


        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            arr.get(a).add(new Pair(b, c));
        }
        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        dijkstra(start, end);

        bw.write(String.valueOf(dist[end]));
        bw.flush();
    }

    static void dijkstra(int start, int end) {
        PriorityQueue<Pair> q = new PriorityQueue<>();
        q.add(new Pair(start, 0));
        dist[start] = 0;

        while (!q.isEmpty()) {
            Pair now = q.poll();

            if (!visited[now.end]) {
                visited[now.end] = true;

                for (Pair next : arr.get(now.end)) {
                    if (dist[next.end] > dist[now.end] + next.cost) {
                        dist[next.end] = dist[now.end] + next.cost;
                        q.add(new Pair(next.end, dist[next.end]));
                    }
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
