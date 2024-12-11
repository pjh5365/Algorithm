import java.util.*;

class Solution {
    /**
    * prices의 idx를 스택에 넣어 하나의 스택만 사용하기
    */
    public int[] solution(int[] prices) {
        Stack<Integer> s = new Stack<>(); // 가격을 idx를 담을 스택
        int len = prices.length;
        int[] answer = new int[len];
        
        s.push(0); // 0번 idx는 무조건 입력
        
        for (int i = 1; i < len; i++) {
            // 스택이 비어있지 않고, 새로운 가격이 현재 가격보다 낮다면 (가격이 떨어졌다면)
            while (!s.isEmpty() && prices[i] < prices[s.peek()]) {
                int tmp = s.pop();
                answer[tmp] = i - tmp; // 기존의 가격에 떨어지지 않은 길이 입력하기
            }
            s.push(i); // 가격이 떨어지지 않았다면
        }
        while (!s.isEmpty()) { // 스택에 남은 나머지 연산하기
            int tmp = s.pop();
            answer[tmp] = len - 1 - tmp;
        }
        return answer;
    }
}