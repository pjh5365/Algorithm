import java.io.*;
import java.util.*;

public class Main {

	static int[] dx = {0, 0, 0, -1, 1}; // 인덱스 1부터 동, 서, 북, 남
	static int[] dy = {0, 1, -1, 0, 0};
	static StringBuilder sb = new StringBuilder();
	static int N;
	static int M;
	static int x;
	static int y;
	static int K;
	static int[][] map;
	static int[] arr;
	// 문제에 나온 주사위의 번호를 적용
	static int[] dice = {0, 0, 0, 0, 0, 0, 0};


	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		arr = new int[K];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < K; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		for (int i : arr)
			move(i);

		bw.write(String.valueOf(sb));
		bw.flush();
	}

	static void move(int index) {
		x += dx[index];
		y += dy[index];

		if (x < 0 || x > N - 1 || y < 0 || y > M - 1) { // 범위를 벗어난다면 복구
			x -= dx[index];
			y -= dy[index];
			return;
		}

		if (index == 1) { // 동쪽으로 굴리기
			int temp = dice[1];
			dice[1] = dice[4];
			dice[4] = dice[6];
			dice[6] = dice[3];
			dice[3] = temp;
		} else if (index == 2) { // 서쪽
			int temp = dice[1];
			dice[1] = dice[3];
			dice[3] = dice[6];
			dice[6] = dice[4];
			dice[4] = temp;
		} else if (index == 3) { // 북쪽
			int temp = dice[1];
			dice[1] = dice[5];
			dice[5] = dice[6];
			dice[6] = dice[2];
			dice[2] = temp;
		} else if (index == 4) { // 남쪽
			int temp = dice[1];
			dice[1] = dice[2];
			dice[2] = dice[6];
			dice[6] = dice[5];
			dice[5] = temp;
		}

        if (map[x][y] == 0) {
            map[x][y] = dice[6];
        } else {
            dice[6] = map[x][y];
            map[x][y] = 0;
        }

        sb.append(dice[1]);
        sb.append("\n");
	}
}
