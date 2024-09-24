import java.io.*;
import java.util.*;

public class Main {
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};
	static int[][] map;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		int K = Integer.parseInt(br.readLine());

		map = new int[N + 1][N + 1];
		for (int i = 0; i < K; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			map[a][b] = -1;
		}

		int L = Integer.parseInt(br.readLine());
		int cnt = 0;
		int idx = 0;
		boolean isEnd = false;
		Deque<Pair> q = new LinkedList<>();
		q.add(new Pair(1, 1));
		map[1][1] = 1;
		for (int i = 0; i < L; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			char b = st.nextToken().charAt(0);
			while (!isEnd && cnt < a) {
				Pair now = q.getFirst();

				if (now.x + dx[idx] < 1 || now.x + dx[idx] > N || now.y + dy[idx] < 1
						|| now.y + dy[idx] > N) {
					isEnd = true;
					break;
				}
				q.addFirst(new Pair(now.x + dx[idx], now.y + dy[idx]));
				if (map[now.x + dx[idx]][now.y + dy[idx]] == 0) { // 사과가 없음
					Pair pair = q.pollLast();
					map[pair.x][pair.y] = 0;
				} else if (map[now.x + dx[idx]][now.y + dy[idx]] == 1) {
					isEnd = true;
					break;
				}
				map[now.x + dx[idx]][now.y +dy[idx]] = 1;
				cnt++;
			}
			if (b == 'D') {
				idx++;
				if (idx == 4) {
					idx = 0;
				}
			} else {
				idx--;
				if (idx == -1) {
					idx = 3;
				}
			}
		}

		while (!isEnd && !q.isEmpty()) {
			Pair now = q.getFirst();
			if (now.x + dx[idx] < 1 || now.x + dx[idx] > N || now.y + dy[idx] < 1
					|| now.y + dy[idx] > N) {
				isEnd = true;
				break;
			}
			q.addFirst(new Pair(now.x + dx[idx], now.y + dy[idx]));
			if (map[now.x + dx[idx]][now.y + dy[idx]] == 0) { // 사과가 없음
				Pair pair = q.pollLast();
				map[pair.x][pair.y] = 0;
			} else if (map[now.x + dx[idx]][now.y + dy[idx]] == 1) {
				isEnd = true;
				break;
			}
			map[now.x + dx[idx]][now.y +dy[idx]] = 1;
			cnt++;
		}

		cnt++;
		bw.write(String.valueOf(cnt));
		bw.newLine();
		bw.flush();
	}

	static class Pair {
		int x;
		int y;

		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
