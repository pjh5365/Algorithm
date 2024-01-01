import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		int[] x = new int[M];
		for (int i = 0; i < M; i++) {
			x[i] = Integer.parseInt(st.nextToken());
		}

		LinkedList<Integer> deque = new LinkedList<>();
		for (int i = 1; i <= N; i++) {
			deque.addLast(i);
		}

		int result = 0;
		for (int i = 0; i < M; i++) {
			int index = deque.indexOf(x[i]);
			int mid = deque.size() / 2;

			if (index <= mid) {
				while (deque.getFirst() != x[i]) {
					deque.addLast(deque.removeFirst());
					result++;
				}
			} else {
				while (deque.getFirst() != x[i]) {
					deque.addFirst(deque.removeLast());
					result++;
				}
			}
			deque.removeFirst();
		}

		bw.write(String.valueOf(result));
		bw.flush();
	}
}
