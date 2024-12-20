import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		HashMap<String, Integer> map =new HashMap<>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int sum = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			String a = st.nextToken();
			int b = Integer.parseInt(st.nextToken());
			map.put(a, b);
		}
		for (int i = 0; i < K; i++) {
			String s = br.readLine();
			sum += map.get(s);
			map.remove(s);
		}
		List<String> list = new ArrayList<>(map.keySet());
		list.sort(Comparator.comparing(map::get));
		int max = sum;
		int min = sum;
		for (int i = 0; i < M - K; i++) {
			max += map.get(list.get(list.size() - 1 - i));
			min += map.get(list.get(i));
		}

		bw.write(min + " " + max);
		bw.flush();
	}
}
