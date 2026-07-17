import java.util.*;

class Solution {
    public static HashMap<Integer, HashMap<String, Integer>> courseMap = new HashMap<>();

    public String[] solution(String[] orders, int[] course) {
        for (int i : course) {
            courseMap.put(i, new HashMap<>());
        }

        for (String order : orders) {
            char[] arr = order.toCharArray();
            Arrays.sort(arr);
            func(0, arr, "");
        }
        ArrayList<String> ret = new ArrayList<>();

        for (var cnt : courseMap.values()) {
            cnt.values()
                    .stream()
                    .max(Comparator.comparingInt(o -> o))
                    .ifPresent(c -> cnt.entrySet()
                            .stream()
                            .filter(e -> c.equals(e.getValue()) && c > 1)
                            .forEach(e -> ret.add(e.getKey())));
        }
        Collections.sort(ret);
        return ret.toArray(new String[0]);
    }

    public static void func(int idx, char[] arr, String ret) {
        if (courseMap.containsKey(ret.length())) {
            HashMap<String, Integer> m = courseMap.get(ret.length());
            m.put(ret, m.getOrDefault(ret, 0) + 1);
        }

        for (int i = idx; i < arr.length; i++) {
            func(i + 1, arr, ret + arr[i]);
        }
    }
}