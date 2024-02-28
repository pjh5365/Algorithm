import java.io.*;
import java.util.*;

public class Main {

	static int N;
	static int[][] arr;
	static int[] dx = {-1, 1, 1, -1};
	static int[] dy = {-1, 1, -1, 1};
	static int bCount = 0;
	static int wCount = 0;
	static boolean[][] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++)
				arr[i][j] = Integer.parseInt(st.nextToken());
		}

		visited = new boolean[N][N];
		findB(0, 0, 0);
		visited = new boolean[N][N];
		findW(0, 1, 0);

		bw.write(String.valueOf(bCount + wCount));
		bw.flush();
	}

	// 검은칸과 하얀칸을 나눠 각각 최대의 경우를 탐색한 결과를 더해서 문제를 해결
	static void findB(int x, int y, int count) {
		bCount = Math.max(bCount, count);

		if (y > N - 1) { // y 가 판을 넘어서는 경우
			x++;
			if (x % 2 == 0) // 짝수라인은 0부터
				y = 0;
			else // 홀수라인은 1부터 시작
				y = 1;
		}
		if (x > N - 1) // 모든 탐색이 종료된다면
			return;

		if (check(x, y)) { // 비숍을 놓을 수 있는 곳이라면
			visited[x][y] = true; // 방문표시
			findB(x, y + 2, count + 1); // 방문 후 탐색하는 경우
			visited[x][y] = false;
		}
		findB(x, y + 2, count); // 방문을 안하고 탐색하는 경우
	}

	static void findW(int x, int y, int count) {
		wCount = Math.max(wCount, count);

		if (y > N - 1) { // y 가 판을 넘어서는 경우
			x++;
			if (x % 2 == 0) // 짝수라인은 1부터
				y = 1;
			else // 홀수라인은 0부터 시작
				y = 0;
		}
		if (x > N - 1) // 모든 탐색이 종료된다면
			return;

		if (check(x, y)) { // 비숍을 놓을 수 있는 곳이라면
			visited[x][y] = true; // 방문표시
			findW(x, y + 2, count + 1); // 방문 후 탐색하는 경우
			visited[x][y] = false;
		}
		findW(x, y + 2, count); // 방문을 안하고 탐색하는 경우
	}

	static boolean check(int x, int y) {
		if (arr[x][y] == 0) // 비숍을 놓을 수 없는 칸이라면
			return false;
		for (int i = 0; i < 4; i++) {
			int sum = 1;
			while (true) {
				int X = x + (sum * dx[i]);
				int Y = y + (sum * dy[i]);

				if (X < 0 || X > N - 1 || Y < 0 || Y > N - 1)
					break;

				if (visited[X][Y]) // 다른 비숍과 겹친다면
					return false;
				sum++;
			}
		}
		return true; // 모든 탐색을 했을 때 비숍을 만나지 않았다면
	}
}
