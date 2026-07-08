import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        HashMap<Integer, Double>map = new HashMap<>();
        int[] cnt = new int[N + 1]; // 전체 클리어한 플레이어 수 포함
        
        for (int i : stages) {
            cnt[i - 1]++; // 스테이지에 도달했으나 아직 클리어하지 못한 플레이어의 수
        }
        
        int sum = 0;
        int pSize = stages.length; // 전체 사용자 수
        
        Arrays.sort(stages); // 스테이지 정렬
        for (int i = 0; i < N; i++) {
            if (cnt[i] == 0) {
                map.put(i + 1, 0.0);
                continue;
            }
            double tmp = (double) cnt[i] / (pSize - sum);
            map.put(i + 1, tmp);
            sum += cnt[i];
        }

        List<Integer> keySet = new ArrayList<>(map.keySet());
        keySet.sort((o1, o2) -> map.get(o2).compareTo(map.get(o1)));
        
        
        return keySet.stream().mapToInt(Integer::intValue).toArray();
	}
}
/**
* 1. 스테이지 정렬
* 2. 오름차순 정렬이므로 해당 스테이지의 실패율 = cnt[i]  / pSize - 현재 인덱스 (최초 숫자가 바뀌는 인덱스)
* 3. 정렬하여 반환..?
*/