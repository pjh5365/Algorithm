import java.io.*;
import java.util.*;

public class Main {

	static Set<Integer> prime = new TreeSet<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		findPrime();

		while (T > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int before = Integer.parseInt(st.nextToken());
			int after = Integer.parseInt(st.nextToken());
			int result = -1;
			boolean[] visited = new boolean[10000];

			Queue<Pair> q = new ArrayDeque<>();
			q.add(new Pair(before, 0));

			while (!q.isEmpty()) {
				Pair now = q.poll();
				visited[now.num] = true;

				if (now.num == after) {
					if (result != -1) {
						result = Math.min(result, now.count);
					} else {
						result = now.count;
					}
				}
				String nowS = String.valueOf(now.num);
				for (int num : prime) {
					String tmp = String.valueOf(num);
					int countDiff = 0;
					for (int j = 0; j < 4; j++) {
						if (tmp.charAt(j) != nowS.charAt(j)) {
							countDiff++;
						}
					}
					if (countDiff == 1 && !visited[num]) {
						q.add(new Pair(num, now.count + 1));
					}
				}
			}

			if (result == -1) {
				sb.append("Impossible").append("\n");
			} else {
				sb.append(result).append("\n");
			}
			T--;
		}
		bw.write(String.valueOf(sb));
		bw.flush();
	}
	
	static void findPrime() {
		boolean[] arr = new boolean[10000];

		for (int i = 2; i < 10000; i++) {
			if (!arr[i]) {
				if (i > 1000) {
					prime.add(i);
				}
				for (int j = i * i; j < 10000; j += i) {
					arr[j] = true;
				}
			}
		}
	}

	static class Pair {
		int num;
		int count;

		public Pair(int num, int count) {
			this.num = num;
			this.count = count;
		}
	}
}
