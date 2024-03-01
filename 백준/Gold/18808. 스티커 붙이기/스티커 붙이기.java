import java.io.*;
import java.util.*;

public class Main {

	static int N;
	static int M;
	static int K;

	static ArrayList<int[][]> sticker = new ArrayList<>();
	static int[][] notebook;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		notebook = new int[N][M];

		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int[][] now = new int[n][m];

			for (int j = 0; j < n; j++) {
				st = new StringTokenizer(br.readLine());
				for (int l = 0; l < m; l++) {
					now[j][l] = Integer.parseInt(st.nextToken());
				}
			}
			sticker.add(now);
		}
		int turnCount = 0;
		while (!sticker.isEmpty()) {
			boolean removeSticker = false;
			Loop:
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (put(i, j, 0)) { // 스티커 붙이는데 성공했다면 다음스티커로 넘어가기
						removeSticker = true;
						break Loop;
					}
				}
			}
			turn(0);
			turnCount++;
			if (removeSticker || turnCount == 4) {
				turnCount = 0;
				sticker.remove(0); // 스티커 제거
			}
		}

		int result = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (notebook[i][j] == 1)
					result++;
			}
		}

		bw.write(String.valueOf(result));
		bw.flush();
	}

	static boolean put(int X, int Y, int index) {
		int[][] copy = copyArr(notebook); // 이번 스티커를 붙이지 못하는 경우를 대비해서 완료된 노트북 복사해놓기
		int[][] now = sticker.get(index);
		boolean isOk = true;
		int x = X;
		int y = Y;
		Loop:
		for (int i = 0; i < now.length; i++, x++) {
			for (int j = 0; j < now[0].length; j++, y++) {
				if (x > N - 1 || y > M - 1 || (notebook[x][y] == 1 && now[i][j] == 1)) {
					isOk = false;
					break Loop;
				}
				if (notebook[x][y] == 0 && now[i][j] == 1) // 스티커를 붙일 수 있다면
					notebook[x][y] = now[i][j];
			}
			y = Y;
		}
		if (!isOk) { // 붙이지 못했을 때
			notebook = copyArr(copy); // 원본 상태로 복구
			return false;
		} else { // 스티커를 붙였을 때
			return true;
		}
	}

	static void turn(int index) {
		int[][] now = sticker.remove(index);
		int[][] tmp = new int[now[0].length][now.length];

		for (int i = 0; i < now.length; i++) { // 90도 회전
			for (int j = 0; j < now[0].length; j++) {
				tmp[j][tmp[0].length - 1 - i] = now[i][j];
			}
		}
		sticker.add(index, tmp); // 스티커 교체
	}

	static int[][] copyArr(int[][] original) {
		int[][] copy = new int[N][M];

		for (int i = 0; i < N; i++)
			copy[i] = original[i].clone();

		return copy;
	}
}
