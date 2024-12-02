import java.util.*;

class Solution {
    /**
    * 
    */
    public static int[] solution(int N, int[] stages) {
		int[] cnt = new int[N + 2]; // 스테이지별 도전자 수
        for (int i : stages) {
            cnt[i]++;
        }
        HashMap<Integer, Double> fails = new HashMap<>();
        double total = stages.length; // 모든 플레이어가 1 스테이지에 도달
        
        for (int i = 1; i <= N; i++) {
            if (cnt[i] == 0) { // 도전자가 0이라면 실패율 0
                fails.put(i, 0.0);
            } else {
                fails.put(i, cnt[i] / total); // 도전자 / 도달한 플레이어 수
                total -= cnt[i]; // 다음 스테이지 실패율을 구하기 위해 현재 스테이지 인원 빼기
            }
        }
        
        return fails.entrySet().stream().sorted((o1, o2) -> Double.compare(o2.getValue(), o1.getValue())).mapToInt(HashMap.Entry::getKey).toArray();
	}
}