import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int[] arr = new int[100001];
		int[] check = {-1, 1};
		arr[N] = 1;
		Queue<Integer> q = new LinkedList<>();
		q.add(N);
		while (!q.isEmpty()) {
			int now = q.poll();

			if (now == K) {
				break;
			}

			for (int i = 0; i < 2; i++) {
				int next = now + check[i];
				if (next < 0)
					continue;
				if (next > 100000)
					continue;
				if (arr[next] == 0 || arr[next] > arr[now] + 1) {
					q.add(next);
					arr[next] = arr[now] + 1;
				}
			}
			if (now * 2 <= 100000) {
				q.add(now * 2);
				arr[now * 2] = arr[now];
			}
		}
		bw.write(String.valueOf(arr[K] - 1));
		bw.flush();
	}
}
