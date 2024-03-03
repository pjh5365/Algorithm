import java.io.*;
import java.util.*;

public class Main {

	static int N;
	static int M;
	static int[][] arr;
	static int[][] count; // 어떤 치킨집이 얼만큼 선택되었는지 담을 배열
	static int[][] result; // 계산한 값을 가지고 있을 배열
	static int[] index;
	static boolean[] use;
	static int MIN = Integer.MAX_VALUE;
	static ArrayList<Pair> house = new ArrayList<>(); // 집의 위치를 담을 리스트
	static ArrayList<Pair> chicken = new ArrayList<>(); // 집의 위치를 담을 리스트

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][N];
		count = new int[N][N];
		result = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if (arr[i][j] == 1) // 집이라면 저장
					house.add(new Pair(i, j));
				else if (arr[i][j] == 2) // 치킨집 저장
					chicken.add(new Pair(i, j));
			}
		}
		index = new int[M];
		use = new boolean[chicken.size()];
		backtracking(0);

		bw.write(String.valueOf(MIN));
		bw.flush();
	}
	// 치킨집의 조합을 뽑아서 계산하는 백트래킹을 사용하면?

	static void backtracking(int k) {
		if (k == M) {
			int sum = 0;
			result = new int[N][N];
			for (int i = 0; i < k; i++) {
				Pair get = chicken.get(index[i]);
				find(get); // 확인한 후
			}

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (arr[i][j] == 1)
						sum += result[i][j];
				}
			}
			MIN = Math.min(MIN, sum);
			return;
		}

		int start = 0;
		if (k > 0)
			start = index[k - 1];

		for (int i = start; i < chicken.size(); i++) {
			if (!use[i]) {
				use[i] = true;
				index[k] = i;
				backtracking(k + 1);
				use[i] = false;
			}
		}
	}

	static void find(Pair chicken) {
		int houseCount = house.size(); // 집의 개수
		while (houseCount != 0) {
			Pair get = house.remove(0);
			int dist = Math.abs(get.x - chicken.x) + Math.abs(get.y - chicken.y);
			if (result[get.x][get.y] != 0) // 첫 탐색이 아닐 경우
				result[get.x][get.y] = Math.min(dist, result[get.x][get.y]); // 집의 최소값 갱신
			else // 첫 탐색이라면
				result[get.x][get.y] = dist;

			result[chicken.x][chicken.y] += dist; // 치킨집 거리 총합에 추가
			house.add(get);
			houseCount--;
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
