class Solution {
    public int solution(int[][] sizes) {
        int xMax = 0;
        int yMax = 0;
        for (int i = 0; i < sizes.length; i++) {
            int max = Math.max(sizes[i][0], sizes[i][1]);
            int min = Math.min(sizes[i][0], sizes[i][1]);
            // sizes[i][0] = max;
            // sizes[i][1] = min;
            xMax = Math.max(xMax, max);
            yMax = Math.max(yMax, min);
        }
        return xMax * yMax;
    }
}