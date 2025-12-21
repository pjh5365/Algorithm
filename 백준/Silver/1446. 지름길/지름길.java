import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());
        ArrayList<ArrayList<Pair>> graph = new ArrayList<>();

        int[] dist = new int[D + 1];
        boolean[] visited = new boolean[D + 1];
        for (int i = 0; i <= D; i++) {
            graph.add(new ArrayList<>());
            dist[i] = (int)1e9;
            if (i == D) {
                break;
            }
            graph.get(i).add(new Pair(i + 1, 1));
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if (a > D || b > D) {
                continue;
            }
            graph.get(a).add(new Pair(b, c));
        }

        PriorityQueue<Pair> q = new PriorityQueue<>();
        q.add(new Pair(0, 0));
        dist[0] = 0;

        while (!q.isEmpty()) {
            Pair now = q.poll();

            if (!visited[now.end]) {
                visited[now.end] = true;

                if (dist[now.end] < now.cost) {
                    continue;
                }

                for (Pair next : graph.get(now.end)) {
                    if (dist[next.end] > dist[now.end] + next.cost) {
                        dist[next.end] = dist[now.end] + next.cost;
                        q.add(new Pair(next.end, dist[next.end]));
                    }
                }
            }
        }

        bw.write(dist[D] + "");
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
