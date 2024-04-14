import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		Map<Integer, Integer> map = new LinkedHashMap<>(); // 키값 순서보장을 위한 LinkedHashMap
		for (int i = 0; i < N; i++) {
			int now = Integer.parseInt(st.nextToken());
			if (map.containsKey(now)) {
				map.put(now, map.get(now) + 1);
			} else {
				map.put(now, 1);
			}
		}

		List<Integer> list = new ArrayList<>(map.keySet());
		list.sort(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return map.get(o2).compareTo(map.get(o1));
			}
		});
		list.forEach(key -> {
			for (int i = 0; i < map.get(key); i++) {
				sb.append(key).append(" ");
			}
		});

		bw.write(String.valueOf(sb));
		bw.flush();
	}
}
