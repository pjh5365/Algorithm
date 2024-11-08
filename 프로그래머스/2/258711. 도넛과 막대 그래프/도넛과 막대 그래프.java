import java.util.*;

class Solution {
    public int[] solution(int[][] edges) {
        Map<Integer, Integer> out = new HashMap<>();
        Map<Integer, Integer> in = new HashMap<>();
        
        int[] ret = new int[4];
        
        for (int[] edge : edges) {
            out.put(edge[0], out.getOrDefault(edge[0], 0) + 1); // 해당 노드의 나가는 간선 개수 저장
            in.put(edge[1], out.getOrDefault(edge[1], 0) + 1); // 해당 노드의 들어오는 간선 개수 저장
        }
        
        for (int i : out.keySet()) { // 나가는 간선을 가진 노드
            if (out.get(i) >= 2) { // 노드에서 나가는 간선의 개수가 2개 이상이라면 8자 그래프의 중간 노드이거나 추가된 노드
                if (!in.containsKey(i)) { // 추가된 노드라면 (들어오는 간선이 없음)
                    ret[0] = i;
                } else { // 8자 그래프의 중간 노드라면 (들어오는 간선이 존재)
                    ret[3]++;
                }
            }
        }
        
        for (int i : in.keySet()) { // 들어오는 간선을 가진 노드
            if (!out.containsKey(i)) { // 나가는 간선이 없다면 막대 그래프의 마지막 노드
                ret[2]++;
            }
        }
    
        // 도넛 그래프의 개수 = 추가된 정점의 나가는 간선(전체 그래프 수) - 막대 그래프 수 - 8자 그래프 수
        ret[1] = out.get(ret[0]) - ret[2] - ret[3];
        return ret;
    }
}
