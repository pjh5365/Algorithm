class Solution {
    static int[] cnt = new int[2];
    public int[] solution(int[][] arr) {
        find(arr, arr.length, 0, 0);
        
        return cnt;
    }
    
    static void find(int[][] arr, int n, int startX, int startY) {
        if (n == 1) {
            cnt[arr[startX][startY]]++;
            return;
        }
        boolean flag = true;
        
        int startNum = arr[startX][startY];
        for (int i = startX; i < startX + n; i++) {
            for (int j = startY; j < startY + n; j++) {
                if (startNum != arr[i][j]) {
                    flag = false;
                    break;
                }
            }
        }
        
        int nextN = n / 2;
        
        if (flag) {
            cnt[startNum]++;
        } else {
            find(arr, nextN, startX, startY);
            find(arr, nextN, startX + nextN, startY);
            find(arr, nextN, startX, startY + nextN);
            find(arr, nextN, startX + nextN, startY + nextN);
        }
    }
}