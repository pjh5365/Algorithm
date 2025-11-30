class Solution {
    public int solution(int a, int b) {
        String A = a + "" + b;
        String B = b + "" + a;
        
        return Math.max(Integer.parseInt(A), Integer.parseInt(B));
    }
}