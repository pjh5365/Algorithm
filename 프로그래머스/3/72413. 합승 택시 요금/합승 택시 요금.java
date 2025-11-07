import java.util.*;

class Solution {
    public int solution(int n, int s, int a, int b, int[][] fares) {
        
        int[][] dist = new int[n + 1][n + 1];
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                dist[i][j] = (int) 2e7;
            }
            dist[i][i] = 0;
        }
        
        for (int i = 0; i < fares.length; i++) {
            int start = fares[i][0];
            int end = fares[i][1];
            dist[start][end] = fares[i][2];
            dist[end][start] = fares[i][2];
        }
        
        for (int k = 1; k < n + 1; k++) {
            for (int i = 1; i < n + 1; i++) {
                for (int j = 1; j < n + 1; j++) {
                    if (dist[i][j] > dist[i][k] + dist[k][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }
        
        int min = (int) 2e7;
        for (int i = 1; i < n + 1; i++) {
            min =  Math.min(min, dist[s][i] + dist[i][a] + dist[i][b]);
        }
        return min;
    }
}