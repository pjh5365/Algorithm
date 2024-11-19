import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int M;
	static int ret = Integer.MAX_VALUE;
	static int[][] arr;
	static int[] find;
	static boolean[] visited;
	static ArrayList<Pair> home = new ArrayList<>();
	static ArrayList<Pair> chicken = new ArrayList<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		arr = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if (arr[i][j] == 2) {
					chicken.add(new Pair(i, j));
				} else if (arr[i][j] == 1) {
					home.add(new Pair(i, j));
				}
			}
		}
		find = new int[M];
		visited = new boolean[chicken.size()];
		backtracking(0);

		bw.write(String.valueOf(ret));
		bw.flush();
	}

	static void backtracking(int k) {
		if (k == M) {
			int[][] map = new int[N][N];
			int max = 0;
			// 모든 집에서 모든 치킨집을 확인해서 가장 가까운 치킨집으로 갱신하고 모든 계산이 완료된 후 최대값이 현재 뽑은 치킨집의 최소거리임
			for (int i : find) {
				Pair get = chicken.get(i);
				for (Pair home : home) {
					int tmp = Math.abs(get.x - home.x) + Math.abs(get.y - home.y);
					if (map[home.x][home.y] == 0) {
						map[home.x][home.y] = tmp;
					} else {
						map[home.x][home.y] = Math.min(tmp, map[home.x][home.y]);
					}
				}
			}
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					max += map[i][j];
				}
			}
			ret = Math.min(ret, max);
			return;
		}

		int start = 0;
		if (k > 0) {
			start = find[k - 1];
		}
		for (int i = start; i < chicken.size(); i++) {
			if (!visited[i]) {
				visited[i] = true;
				find[k] = i;
				backtracking(k + 1);
				visited[i] = false;
			}
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
