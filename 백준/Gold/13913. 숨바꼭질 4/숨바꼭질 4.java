import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int[] arr = new int[100001];
		int[] before = new int[100001];
		arr[N] = 1;
		Queue<Integer> q = new LinkedList<>();
		q.add(N);

		while (!q.isEmpty()) {
			int now = q.poll();

			if (now == K)
				break;

			if (now + 1 <= 100000 && arr[now + 1] == 0) {
				q.add(now + 1);
				arr[now + 1] = arr[now] + 1;
				before[now + 1] = now;
			}
			if (now - 1 >= 0 && arr[now - 1] == 0) {
				q.add(now - 1);
				arr[now - 1] = arr[now] + 1;
				before[now - 1] = now;
			}
			if (now * 2 <= 100000 && arr[now * 2] == 0) {
				q.add(now * 2);
				arr[now * 2] = arr[now] + 1;
				before[now * 2] = now;
			}
		}

		int now = K;
		sb.append(arr[K] - 1).append("\n");
		Stack<Integer> s = new Stack<>();
		s.push(now);
		while (now != N) {
			s.push(before[now]);
			now = before[now];
		}
		while (!s.isEmpty()) {
			sb.append(s.pop()).append(" ");
		}

		bw.write(String.valueOf(sb));
		bw.flush();
	}
}
