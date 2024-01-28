import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int[][] arr = new int[500001][2];

		Queue<Pair> q = new LinkedList<>();

		arr[N][0] = 1;
		q.add(new Pair(N, K, 0, 1));

		int result = -1;

		while (!q.isEmpty()) {
			Pair poll = q.poll();
			if (poll.K > 500000) {
				break;
			}
			if (arr[poll.K][1 - poll.next] != 0) { // 수빈이가 방문했던 칸에 동생이 도착한다면
				result = poll.time;
				break;
			}
			// 다음칸이 수빈이가 방문하지 않은곳이라면
			if (poll.now * 2 <= 500000 && arr[poll.now * 2][poll.next] == 0) {
				arr[poll.now * 2][poll.next] = 1;
				q.add(new Pair(poll.now * 2, poll.K + poll.time + 1, poll.time + 1, 1 - poll.next));
			}
			if (poll.now - 1 >= 0 && arr[poll.now - 1][poll.next] == 0) {
				arr[poll.now - 1][poll.next] = 1;
				q.add(new Pair(poll.now - 1, poll.K + poll.time + 1, poll.time + 1, 1 - poll.next));
			}
			if (poll.now + 1 <= 500000 && arr[poll.now + 1][poll.next] == 0) {
				arr[poll.now + 1][poll.next] = 1;
				q.add(new Pair(poll.now + 1, poll.K + poll.time + 1, poll.time + 1, 1 - poll.next));
			}
		}

		bw.write(String.valueOf(result));
		bw.flush();
	}

	static class Pair {
		int now;
		int K;
		int time;
		int next;

		public Pair(int now, int k, int time, int next) {
			this.now = now;
			K = k;
			this.time = time;
			this.next = next;
		}
	}
}
