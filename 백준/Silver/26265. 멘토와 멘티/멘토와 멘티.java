import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());

		Map<String, ArrayList<String>> map = new TreeMap<>();
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String a = st.nextToken();
			String b = st.nextToken();

			ArrayList<String> list = map.getOrDefault(a, new ArrayList<>());
			list.add(b);
			map.put(a, list);
		}
		Set<String> keySet = map.keySet();
		for (String s : keySet) {
			ArrayList<String> list = map.get(s);
			list.sort(Comparator.reverseOrder());
			for (String s1 : list) {
				sb.append(s).append(" ").append(s1).append("\n");
			}
		}

		bw.write(String.valueOf(sb));
		bw.flush();
	}
}
