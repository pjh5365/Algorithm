import java.io.*;
import java.util.*;

public class Main {

	static int N;
	static int M;
	static int[][] arr;
	static ArrayList<Pair> list;
	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, 1, -1};
	static int result = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		arr = new int[N][M];
		int[][] copy = new int[N][M];
		list = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if (arr[i][j] >= 1 && arr[i][j] <= 5)
					list.add(new Pair(i, j));
			}
		}

		find(0, arr);

		bw.write(String.valueOf(result));
		bw.flush();
	}

	static int[][] copyArr(int[][] map) {
		int[][] copy = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				copy[i][j] = map[i][j];
			}
		}
		return copy;
	}

	static void find(int k, int[][] map) {
		if (k == list.size()) { // CCTV 전체를 탐색했다면
			int count = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (map[i][j] == 0)
						count++;
				}
			}
			result = Math.min(count, result);
			return;
		}

		int[][] tmp;
		Pair start = list.get(k);
		if (arr[start.x][start.y] == 1) {
			for (int j = 0; j < 4; j++) {
				tmp = copyArr(map);
				fill(start, j, tmp);
				find(k + 1, tmp);
			}
		} else if (arr[start.x][start.y] == 2) {
			for (int j = 0; j < 3; j += 2) {
				tmp = copyArr(map);
				fill(start, j, tmp);
				fill(start, j + 1, tmp);
				find(k + 1, tmp);
			}
		} else if (arr[start.x][start.y] == 3) {
			for (int j = 0; j < 2; j++) {
				for (int l = 2; l < 4; l++) {
					tmp = copyArr(map);
					fill(start, j, tmp);
					fill(start, l, tmp);
					find(k + 1, tmp);
				}
			}
		} else if (arr[start.x][start.y] == 4) {
			tmp = copyArr(map);
			fill(start, 0, tmp);
			fill(start, 1, tmp);
			fill(start, 2, tmp);
			find(k + 1, tmp);

			tmp = copyArr(map);
			fill(start, 1, tmp);
			fill(start, 2, tmp);
			fill(start, 3, tmp);
			find(k + 1, tmp);

			tmp = copyArr(map);
			fill(start, 2, tmp);
			fill(start, 3, tmp);
			fill(start, 0, tmp);
			find(k + 1, tmp);

			tmp = copyArr(map);
			fill(start, 3, tmp);
			fill(start, 0, tmp);
			fill(start, 1, tmp);
			find(k + 1, tmp);
		} else {
			tmp = copyArr(map);
			for (int j = 0; j < 4; j++)
				fill(start, j, tmp);
			find(k + 1, tmp);
		}

	}

	static void fill(Pair start, int i, int[][] map) {
		int tmp = 1;
		map[start.x][start.y] = -1;
		while (true) { // 방향이 결정나면 그 방향은 사각지대가 아님을 표시하기
			int x = start.x + (tmp * dx[i]);
			int y = start.y + (tmp * dy[i]);

			if (x < 0 || x > N - 1 || y < 0 || y > M - 1 || arr[x][y] == 6) // 범위를 벗어나거나 벽을 만나면 종료
				break;
			map[x][y] = -1; // 사각지대가 아님을 표시
			tmp++;
		}
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
