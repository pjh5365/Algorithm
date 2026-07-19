import java.util.*;

class Solution {
    
    static int max = 0;
    static ArrayList<ArrayList<Integer>> list = new ArrayList<>();
    
    public int solution(int[] info, int[][] edges) {
        for (int i = 0; i < info.length; i++) {
            list.add(new ArrayList<>());
        }
        
        for (int[] arr : edges) {
            list.get(arr[0]).add(arr[1]);
        }
        
        ArrayList<Integer> nextList = new ArrayList<>(list.get(0));
        
        dfs(1, 0, info, nextList);
        
        return max;
    }
    
    static void dfs(int sheep, int wolf, int[] info, ArrayList<Integer> nextList) {
        max = Math.max(sheep, max);
        
        for (int i = 0; i < nextList.size(); i++) {
            int next = nextList.get(i);
            int nextSheep = sheep;
            int nextWolf = wolf;
            
            if (info[next] == 0) {
                nextSheep++;
            } else {
                nextWolf++;
            }
            if (nextSheep <= nextWolf) {
                continue;
            }
            
            ArrayList<Integer> nextL = new ArrayList<>(nextList);
            nextL.remove(i);
            nextL.addAll(list.get(next));
            dfs(nextSheep, nextWolf, info, nextL);
        }
    }
}