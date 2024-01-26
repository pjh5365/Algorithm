import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());

		int[][] arr = new int[N][M];
		int[] move = new int[P + 1];
		Queue<Pair>[] q = new Queue[P + 1];
		int[] result = new int[P + 1];

		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= P; i++) {
			move[i] = Integer.parseInt(st.nextToken());
			q[i] = new LinkedList<>();
		}

		int zeroCount = 0;
		for (int i = 0; i < N; i++) {
			String input = br.readLine();
			for (int j = 0; j < M; j++) {
				if (input.charAt(j) == '#')
					arr[i][j] = -1;
				else if (input.charAt(j) <= '9' && input.charAt(j) >= '1') {
					arr[i][j] = input.charAt(j) - '0';
					q[arr[i][j]].add(new Pair(i, j, 0, arr[i][j], 0));
					result[arr[i][j]]++;
				} else
					zeroCount++;
			}
		}

		int[] checkX = {0, 0, 1, -1};
		int[] checkY = {1, -1, 0, 0};

		bfs(zeroCount, q, move, checkX, checkY, N, M, P, arr, result);

		for (int i = 1; i <= P; i++) {
			sb.append(result[i]).append(" ");
		}

		bw.write(String.valueOf(sb));
		bw.flush();
	}

	private static void bfs(int zeroCount, Queue<Pair>[] q, int[] move, int[] checkX,
			int[] checkY, int N, int M, int P, int[][] arr, int[] result) {
		int count = 0;
		int beforeZeroCount;
		while (zeroCount != 0) {
			beforeZeroCount = zeroCount;
			for (int i = 1; i <= P; i++) {
				Queue<Pair> getQ = q[i];
				if (getQ.peek() == null)	// 더 이상 확장할 수 없다면
					continue;
				while (getQ.peek() != null && getQ.peek().count == count) {	// 꺼낸 요소의 순서가 맞는 경우에만
					Pair poll = getQ.poll();

					for (int j = 0; j < 4; j++) {
						int x = poll.x + checkX[j];
						int y = poll.y + checkY[j];

						if (x < 0 || x >= N || y < 0 || y >= M)
							continue;

						if (arr[x][y] == 0) {
							arr[x][y] = arr[poll.x][poll.y];
							if (poll.move + 1 < move[i]) // 이동을 다 하지 못한 경우에는 이동횟수를 늘려서 삽입
								getQ.add(new Pair(x, y, poll.count, arr[x][y], poll.move + 1));
							else if (poll.move + 1 == move[i])
								getQ.add(new Pair(x, y, poll.count + 1, arr[x][y], 0));

							result[poll.now]++;
							zeroCount--;
							if (zeroCount == 0)
								return;
						}
					}
				}
			}
			if (zeroCount == beforeZeroCount)
				return;
			count++;
		}
	}

	static class Pair {
		int x;
		int y;
		int count; // 순서
		int now;
		int move;

		public Pair(int x, int y, int count, int now, int move) {
			this.x = x;
			this.y = y;
			this.count = count;
			this.now = now;
			this.move = move;
		}
	}
}
