import java.io.*;
import java.util.*;

public class Main {

	static char[][] input = new char[5][5];
	static int[] arr = new int[7];
	static Pair[] comPair = new Pair[25];
	static boolean[] use = new boolean[25];
	static boolean[][] bfsArr;
	static boolean[][] visited;
	static int[] dx = {0, 0, 1, -1};
	static int[] dy = {1, -1, 0, 0};
	static int result = 0;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int count = 0;
		for (int i = 0; i < 5; i++) {
			String s = br.readLine();
			for (int j = 0; j < 5; j++) {
				input[i][j] = s.charAt(j);
				comPair[count++] = new Pair(i, j);
			}
		}

		combination(0);

		bw.write(String.valueOf(result));
		bw.flush();
	}

	static void combination(int k) { // 7개의 좌표를 뽑기
		if (k == 7) {
			visited = new boolean[5][5];
			bfsArr = new boolean[5][5];

			for (int i = 0; i < k; i++) { // 해당 좌표가 조합에 뽑혔다는 표시하기
				Pair now = comPair[arr[i]];
				bfsArr[now.x][now.y] = true;
			}
			bfs(comPair[arr[0]]);
			return;
		}

		int start = 0;
		if (k > 0)
			start = arr[k - 1];

		for (int i = start; i < 25; i++) {
			if (!use[i]) {
				use[i] = true;
				arr[k] = i;
				combination(k + 1);
				use[i] = false;
			}
		}
	}

	static void bfs(Pair get) {
		Queue<Pair> q = new LinkedList<>();
		q.add(get);

		int count = 0;
		int sCount = 0;

		while (!q.isEmpty()) {
			Pair now = q.poll();

			for (int i = 0; i < 4; i++) {
				int x = now.x + dx[i];
				int y = now.y + dy[i];

				if (x < 0 || x > 4 || y < 0 || y > 4 || visited[x][y] || !bfsArr[x][y]) // 방문했거나, 뽑히지 않은 경우
					continue;

				q.add(new Pair(x, y)); // 큐에 새로운 위치 삽입
				visited[x][y] = true; // 방문표시
				count++;
				if (input[x][y] == 'S')
					sCount++;
			}
		}
		if (count == 7 && sCount >= 4)
			result++;
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
