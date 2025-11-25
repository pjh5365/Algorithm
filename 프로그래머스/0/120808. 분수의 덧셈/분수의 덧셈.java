class Solution {
    public int[] solution(int numer1, int denom1, int numer2, int denom2) {
        int num = numer1 * denom2 + numer2 * denom1;
        int denom = denom1 * denom2;
        int g = gcd(num, denom);
        int[] ret = new int[2];
        ret[0] = num / g;
        ret[1] = denom / g;
        return ret;
    }
    
    static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}