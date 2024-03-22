import java.util.*;

class Solution {
    
    static HashMap<Integer, Integer> size = new HashMap<>();
    
    public int solution(int[][] land) {
        int max = 0;
        int fillNum = 3;

        for (int i = 0; i < land[0].length; i++) {
            for (int j = 0; j < land.length; j++) {
                if (land[j][i] == 1) {
                    bfs(j, i, land, fillNum);
                    fillNum++;
                }   
            }
        }
        
        // for (int i = 0; i < land.length; i++) {
        //     for (int j = 0; j < land[0].length; j++) {
        //         System.out.print(land[i][j] + " ");
        //     }
        //     System.out.println();
        // }
        
        for (int i = 0; i < land[0].length; i++) {
            int sum = 0;
            boolean[] check = new boolean[fillNum];
            for (int j = 0; j < land.length; j++) {
                if (land[j][i] != 0) {
                    int get = land[j][i];
                    if (!check[get]) {
                        sum += size.get(get);
                        check[get] = true;
                    }
                }   
            }
            max = Math.max(max, sum);
        }
        return max;
    }
    
    public void bfs(int X, int Y, int[][] arr, int fillNum) {
        arr[X][Y] = fillNum;
        int count = 1;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(X, Y));
        
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};
        while (!q.isEmpty()) {
            Pair get = q.poll();
            
            for (int i = 0; i < 4; i++) {
                int x = dx[i] + get.x;
                int y = dy[i] + get.y;
                
                if (x < 0 || x >= arr.length || y < 0 || y >= arr[0].length)
                    continue;
                
                if (arr[x][y] == 1) {
                    count++;
                    arr[x][y] = fillNum;
                    q.add(new Pair(x, y));
                }
            }
        }
        size.put(fillNum, count);
    }
    
    public int[][] copyArr(int[][] land) {
        int[][] tmp = new int[land.length][land[0].length];
        
        for (int i = 0; i < land.length; i++) {
            tmp[i] = land[i].clone();
        }
        
        return tmp;
    }
    
    static class Pair {
        int x;
        int y;
        
        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}