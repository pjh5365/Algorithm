import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int r1 = Integer.parseInt(st.nextToken());
		int c1 = Integer.parseInt(st.nextToken());
		int r2 = Integer.parseInt(st.nextToken());
		int c2 = Integer.parseInt(st.nextToken());
		int[][] arr = new int[r2 - r1 + 1][c2 - c1 + 1];
		int[] dx = {0, -1, 0, 1};
		int[] dy = {1, 0, -1, 0};
		int x = 0;
		int y = 0;
		int tmp = 0;
		int num = 1;
		int dist = 1; // 한 방향으로 이동해야하는 거리
		int cnt = 0; // 한 방향으로 이동한 거리

		while (!(arr[0][0] != 0 && arr[r2 - r1][0] != 0 && arr[0][c2 - c1] != 0 && arr[r2 - r1][c2 - c1] != 0)) {
			if (x >= r1 && x <= r2 && y >= c1 && y <= c2) {
				arr[x - r1][y - c1] = num;
			}
			num++;
			cnt++;
			x = x + dx[tmp];
			y = y + dy[tmp];

			if (cnt == dist) {
				cnt = 0;
				if (tmp == 1 || tmp == 3) {
					dist++;
				}
				tmp = (tmp + 1) % 4;
			}
		}
		int len = Integer.toString(num - 1).length();
		for (int i = 0; i <= r2 - r1; i++) {
			for (int j = 0; j <= c2 - c1; j++) {
				System.out.printf("%" + len + "d ", arr[i][j]);
			}
			System.out.println();
		}
	}
}
