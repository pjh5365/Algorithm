import java.io.*;
import java.util.*;

public class Main {

	static char[][] arr;
	static boolean[][] visited;
	static int[] dx = {0, 0, 1, -1};
	static int[] dy = {1, -1, 0, 0};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		arr = new char[12][6];
		for (int i = 0; i < 12; i++) {
			String input = br.readLine();
			for (int j = 0; j < 6; j++)
				arr[i][j] = input.charAt(j);
		}

		int result = 0;
		boolean isChanged = true;
		boolean check;
		while (isChanged) {
			boolean countUp = false;
			for (int i = 11; i >= 0; i--) {
				for (int j = 0; j < 6; j++) {
					if (arr[i][j] != '.' ) { // 블럭이 존재하는 곳만 탐색
						char[][] copy = copyArr(arr);
						check = bfs(i, j);
						if (!check) { // 블럭이 터지지 않는다면 복구
							arr = copyArr(copy);
						} else {
							countUp = true;
						}
					}
				}
			}
			if (countUp)
				result++;
			isChanged = blockDown();
		}

		bw.write(String.valueOf(result));
		bw.flush();
	}

	static boolean bfs(int x, int y) {
		char block = arr[x][y];
		Queue<Pair> bfsQ = new LinkedList<>();
		visited = new boolean[12][6];
		bfsQ.add(new Pair(x, y));
		int count = 0;
		while (!bfsQ.isEmpty()) {
			Pair now = bfsQ.poll();
			for (int i = 0; i < 4; i++) {
				int X = now.x + dx[i];
				int Y = now.y + dy[i];

				if (X < 0 || X > 11 || Y < 0 || Y > 5)
					continue;

				if (arr[X][Y] == block && !visited[X][Y]) {
					visited[X][Y] = true;
					bfsQ.add(new Pair(X, Y));
					arr[X][Y] = '.';
					count++;
				}
			}
		}
		if (count >= 4) // 블럭이 터지는게 맞다면
			return true;
		return false;
	}

	private static boolean blockDown() {
		boolean isChanged = false;
		for (int i = 0; i < 6; i++) {
			int index = 11;
			while (arr[index][i] != '.') { // 현재 위치에 블럭이있다면 블럭이 없는 칸 까지 이동
				index--;
				if (index < 0)
					break;
			}
			for (int j = index; j >= 0; j--) {
				if (index <= 0)
					break;
				if (arr[j][i] == '.')
					continue;
				if (arr[index][i] == '.' && arr[j][i] != '.') { // 탐색하는 칸이 블럭이라면 블럭 내리기
					arr[index][i] = arr[j][i];
					index--;
					arr[j][i] = '.';
					isChanged = true;
				}
			}
		}

		return isChanged;
	}

	static char[][] copyArr(char[][] arr) {
		char[][] tmp = new char[12][6];

		for (int i = 0; i < 12; i++)
			tmp[i] = arr[i].clone();

		return tmp;
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
