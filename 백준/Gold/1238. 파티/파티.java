import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int M;
    static int X;

    static ArrayList<ArrayList<Pair>> list = new ArrayList<>();
    static int[][] dist;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        dist = new int[N + 1][N + 1];
        for (int i = 0; i <= N; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
            list.add(new ArrayList<>());
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            list.get(a).add(new Pair(b, c));
        }

        for (int i = 1; i <= N; i++) {
            dijkstra(i);
        }
        int ret = 0;
        for (int i = 1; i <= N; i++) {
            ret = Math.max(ret, dist[i][X] + dist[X][i]); // 왕복
        }

        bw.write(String.valueOf(ret));
        bw.flush();
    }

    static void dijkstra(int start) {
        PriorityQueue<Pair> q = new PriorityQueue<>();
        dist[start][start] = 0; // 학생의 시작점

        q.add(new Pair(start, 0));
        while (!q.isEmpty()) {
            Pair now = q.poll();

            for (Pair next : list.get(now.end)) {
                int cost = now.cost + next.cost;
                if (cost < dist[start][next.end]) {
                    dist[start][next.end] = cost;
                    q.add(new Pair(next.end, cost));
                }
            }
        }
    }

    static class Pair implements Comparable<Pair>{
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
