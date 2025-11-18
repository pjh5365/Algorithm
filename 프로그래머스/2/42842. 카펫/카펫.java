class Solution {
    public int[] solution(int b, int y) {
        int total = b + y;
        
        int[] ret = new int[2];
        for (int i = total / 2; i > 1; i--) {
            for (int j = 2; j <= total / 2; j++) {
                int tmp = i * j;
                if (tmp == total) {
                    int sum = i * 2 + (j - 2) * 2;
                    if (sum == b) {
                        ret[0] = i;
                        ret[1] = j;
                        return ret;
                    }
                } else if (tmp > total) {
                    break;
                }
            }
        }
        return ret;
    }
}