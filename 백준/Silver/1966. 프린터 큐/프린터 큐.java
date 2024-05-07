import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		while (T > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			Queue<Pair> q = new LinkedList<>();
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			int[] arr = new int[N];
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
				q.add(new Pair(i, arr[i]));
			}
			Arrays.sort(arr);

			int index = N - 1;
			int count = 1;
			while (!q.isEmpty() || index != 0) {
				if (q.peek().priority == arr[index]) {
					Pair get = q.poll();
					if (get.x == M) {
						break;
					}
					count++;
					index--;
				} else {
					q.add(q.poll());
				}
			}
			sb.append(count).append("\n");
			T--;
		}

		bw.write(String.valueOf(sb));
		bw.flush();
	}

	static class Pair {
		int x;
		int priority;

		public Pair(int x, int priority) {
			this.x = x;
			this.priority = priority;
		}
	}
}
