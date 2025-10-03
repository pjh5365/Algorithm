import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        
        HashMap<String, Integer> map = new HashMap<>();
        HashMap<String, List<Pair>> listMap = new HashMap<>();

        List<Integer> ret = new ArrayList<>();

        for (int i = 0; i < genres.length; i++) {
            String s = genres[i];
            int now = plays[i];

            Integer get = map.get(s);
            List<Pair> list = listMap.get(s);
            if (get == null) {
                map.put(s, now);
            } else {
                map.put(s, now + get);
            }

            if (list == null) {
                list = new ArrayList<>();
                listMap.put(s, list);
            }
            list.add(new Pair(i, now, s));
        }

        List<String> keySet = new ArrayList<>(map.keySet());
        keySet.sort((o1, o2) -> map.get(o2).compareTo(map.get(o1)));
        for (String s : keySet) {
            List<Pair> list = listMap.get(s);
            Collections.sort(list);

            for (int i = 0; i < Math.min(2, list.size()); i++) {
                ret.add(list.get(i).idx);
            }
        }
        int[] answer = new int[ret.size()];
        for (int i = 0; i < ret.size(); i++) {
            answer[i] = ret.get(i);
        }
        return answer;
    }
}

class Pair implements Comparable<Pair> {
    int idx;
    int cnt;
    String g;

    public Pair(int idx, int cnt, String g) {
        this.idx = idx;
        this.cnt = cnt;
        this.g = g;
    }

    @Override
    public int compareTo(Pair o) {

        if (this.cnt != o.cnt) {
            if (this.cnt > o.cnt) {
                return -1;
            } else {
                return 1;
            }
        } else {
            if (this.idx > o.idx) {
                return 1;
            } else {
                return -1;
            }
        }
    }
}