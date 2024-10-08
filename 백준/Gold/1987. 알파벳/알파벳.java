import java.io.*;
import java.util.*;

public class Main {

	static int R, C, ret;
	static char[][] arr;
	static int[][] visited;
	static int[] dx = {0, 0, 1, -1};
	static int[] dy = {1, -1, 0, 0};
	static Set<Character> set = new HashSet<>();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		arr = new char[R][C];
		visited = new int[R][C];
		for (int i = 0; i < R; i++) {
			String input = br.readLine();
			for (int j = 0; j < C; j++) {
				arr[i][j] = input.charAt(j);
			}
		}

		ret = 1;
		set.add(arr[0][0]);
		visited[0][0] = 1;
		dfs(0, 0);

		bw.write(String.valueOf(ret));
		bw.newLine();
		bw.flush();
	}

	static void dfs(int x, int y) {
		for (int i = 0; i < 4; i++) {
			int X = x + dx[i];
			int Y = y + dy[i];

			if (X < 0 || X > R - 1 || Y < 0 || Y > C - 1) {
				continue;
			}
			if (visited[X][Y] < visited[x][y] && !set.contains(arr[X][Y])) {
				int tmp = visited[X][Y];
				visited[X][Y] = visited[x][y] + 1;
				ret = Math.max(ret, visited[X][Y]);
				set.add(arr[X][Y]);
				dfs(X, Y);
				set.remove(arr[X][Y]);
				visited[X][Y] = tmp;
			}
		}
	}
}
