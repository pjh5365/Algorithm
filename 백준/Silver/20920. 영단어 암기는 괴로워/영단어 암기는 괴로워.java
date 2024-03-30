import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		HashMap<String, Integer> map = new HashMap();
		for (int i = 0; i < N; i++) {
			String input = br.readLine();
			if (map.containsKey(input)) {
				map.put(input, map.get(input) + 1);
			} else {
				map.put(input, 1);
			}
		}

		ArrayList<String> list = new ArrayList<>(map.keySet());
		List<String> result = list.stream()
				.sorted(new Comparator<String>() {
					@Override
					public int compare(String o1, String o2) {
						if (map.get(o1) < map.get(o2)) {
							return 1;
						} else if (map.get(o1) > map.get(o2)) {
							return -1;
						} else {
							if (o1.length() == o2.length()) {
								return o1.compareTo(o2);
							}
							return o2.length() - o1.length();
						}

					}
				}).collect(Collectors.toList());;

		for (String s : result) {
			if (s.length() >= M) {
				sb.append(s).append("\n");
			}
		}
		bw.write(String.valueOf(sb));
		bw.flush();
	}
}
