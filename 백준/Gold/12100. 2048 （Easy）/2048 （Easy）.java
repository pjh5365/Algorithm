import java.io.*;
import java.util.*;

public class Main {

	static int N;
	static int result = 0;
	static boolean[][] isAdded;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());
		int[][] arr = new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++)
				arr[i][j] = Integer.parseInt(st.nextToken());
		}

		find(0, arr);

		bw.write(String.valueOf(result));
		bw.flush();
	}

	static void find(int k, int[][] arr) {
		int[][] tmp;
		if (k == 5) {
			result = Math.max(check(arr), result);
			return;
		}
		for (int i = 0; i < 4; i++) {
			tmp = copy(arr);
			isAdded = new boolean[N][N];
			up(tmp);
			find(k + 1, tmp);
			arr = turn(arr); // 방향 90도로 회전시켜서 같은 함수로 돌려서 실수 최대한 줄이기
		}
	}

	static void up(int[][] arr) {
		for (int i = 0; i < N; i++) {
			int index = 0; // 가능한 맨 위로 올린 블럭의 인덱스를 저장
			int value = 0; // 블럭의 값을 임시저장하는 변수
			for (int j = 0; j < N; j++) {
				if (arr[j][i] != 0) { // 아래쪽으로 먼저 탐색하는데 현재칸에 블럭이 존재하는 경우
					if (arr[j][i] == value) { // 저장한 블럭값과 현재 블록의 값이 같다면
						arr[index - 1][i] = value * 2; // 블럭 합치기
						value = 0; // 초기화
						arr[j][i] = 0;
					} else { // 현재 블록의 값과 저장한 값이 다르다면
						value = arr[j][i]; // 현재 블럭의 값을 저장
						arr[j][i] = 0; // 저장했으니 블럭 제거
						arr[index++][i] = value; // index 는 0부터 시작되므로 블럭을 가능한 맨 위로 올려 저장함
					}
				}
			}
		}
	}

	static int[][] turn(int[][] arr) {
		int[][] tmp = new int[N][N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				tmp[j][N - 1 - i] = arr[i][j];
			}
		}

		return tmp;
	}

	static int[][] copy(int[][] arr) {
		int[][] tmp = new int[N][N];

		for (int i = 0; i < N; i++)
			tmp[i] = arr[i].clone();

		return tmp;
	}

	static int check(int[][] arr) {
		int max = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				max = Math.max(arr[i][j], max);
			}
		}
		return max;
	}
}
