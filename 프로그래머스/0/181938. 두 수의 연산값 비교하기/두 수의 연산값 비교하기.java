class Solution {
    public int solution(int a, int b) {
        String A = a + "" + b;
        String B = (2 * a * b) + "";
        return Math.max(Integer.parseInt(A), Integer.parseInt(B));
    }
}