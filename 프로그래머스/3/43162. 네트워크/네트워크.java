import java.util.*;

class Solution {
    
    static int[][] arr;
    static boolean[] visited;
    
    public int solution(int n, int[][] computers) {
        arr = new int[n][n];
        visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (computers[i][j] == 1) {
                    arr[i][j] = 1;
                    arr[j][i] = 1;
                }
            }
        }
        
        // for (int i = 0; i < n; i++) {
        //     for (int j = 0; j < n; j++) {
        //         System.out.print(arr[i][j] + " ");
        //     }
        //     System.out.println();
        // }
        
        int ret = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                ret++;
                dfs(i, n);
            }
        }

        return ret;
    }
    
    static void dfs(int start, int n) {    
        System.out.println("start = " + start);
        if (visited[start]) {
            return;
        }
        visited[start] = true; // 방문처리
        for (int i = 0; i < n; i++) {
            if (i != start) {
                if (arr[start][i] == 1) { // 간선이 연결되어 있을때
                    dfs(i, n);
                }
            }
        }
    }
}