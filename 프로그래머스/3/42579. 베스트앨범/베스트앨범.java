import java.util.*;

class Solution {
    public int[] solution(String[] g, int[] p) {
        HashMap<String, Integer> pm = new HashMap<>();
        HashMap<String, ArrayList<int[]>> gm = new HashMap<>();

        for (int i = 0; i < g.length; i++) {
            String genre = g[i];
            int play = p[i];

            if (!gm.containsKey(genre)) {
                gm.put(genre, new ArrayList<>());
                pm.put(genre, 0);
            }
            gm.get(genre).add(new int[] {i, play});
            pm.put(genre, pm.get(genre) + play);
        }

        ArrayList<Integer> ret = new ArrayList<>();

        pm.entrySet()
                .stream()
                .sorted((o1, o2) -> Integer.compare(o2.getValue(), o1.getValue()))
                .forEach(e -> gm.get(e.getKey())
                        .stream()
                        .sorted((o1, o2) -> Integer.compare(o2[1], o1[1]))
                        .limit(2)
                        .forEach(s -> ret.add(s[0])));
        return ret.stream().mapToInt(Integer::intValue).toArray();
    }
}