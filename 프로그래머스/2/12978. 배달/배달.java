import java.util.*;

class Solution {
    public int solution(int N, int[][] road, int K) {
        ArrayList<ArrayList<Pair>> list = new ArrayList<>();
        
        for (int i = 0; i < N + 1; i++) {
            list.add(new ArrayList<>());
        }
        
        for (int[] arr : road) {
            list.get(arr[0]).add(new Pair(arr[1], arr[2]));
            list.get(arr[1]).add(new Pair(arr[0], arr[2]));
        }
        
        int[] dist = new int[N + 1];
        Arrays.fill(dist, (int)1e9);
        
        Queue<Pair> q = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.cost, o2.cost));
        q.add(new Pair(1, 0));
        dist[1] = 0;
        
        while (!q.isEmpty()) {
            Pair now = q.poll();
            
            if (dist[now.d] < now.cost) {
                continue;
            }
            
            for (Pair next : list.get(now.d)) {
                if (dist[next.d] > now.cost + next.cost) {
                    dist[next.d] = now.cost + next.cost;
                    q.add(new Pair(next.d, dist[next.d]));
                } 
            }
        }
        
        int ret = 0;
        
        for (int i = 1; i <= N; i++) {
            if (dist[i] <= K) ret++;
        }

        return ret;
    }
    
    static class Pair {
        int d;
        int cost;
        
        public Pair(int d, int cost) {
            this.d = d;
            this.cost = cost;
        }
    }
}