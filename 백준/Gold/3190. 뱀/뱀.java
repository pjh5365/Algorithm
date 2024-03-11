import java.io.*;
import java.util.*;

public class Main {

	static int N;
	static int K;
	static int[][] arr;
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};
	static int L;
	static int index = 0;
	static int[][] snake;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());
		K = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		for (int i = 0; i < K; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			arr[x - 1][y - 1] = 1;
		}
		L = Integer.parseInt(br.readLine());
		snake = new int[L][2];
		for (int i = 0; i < L; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int sec = Integer.parseInt(st.nextToken());
			char way = st.nextToken().charAt(0);
			snake[i][0] = sec;
			snake[i][1] = way;
		}

		int result = bfs();

		bw.write(String.valueOf(result));
		bw.flush();
	}

	static int bfs() {
		Queue<Pair> q = new LinkedList<>(); // 탐색용 큐
		Queue<Pair> length = new LinkedList<>(); // 뱀이 지나간 위치를 담을 큐
		q.add(new Pair(0, 0, 0));
		length.add(new Pair(0, 0, 0));
		arr[0][0] = 2;
		int sec = 0;
		while (!q.isEmpty()) {
			Pair get = q.poll();
			int d = get.d;
			int x = get.x + dx[d];
			int y = get.y + dy[d];

			if (x < 0 || x > N - 1 || y < 0 || y > N - 1) // 벽과 부딛힌다면 종료
				break;

			sec++;
			length.add(new Pair(x, y, 0)); // 머리 위치 저장
			if (arr[x][y] == 1) // 사과라면
				arr[x][y] = 2;
			else if (arr[x][y] == 2) { // 자신의 몸이라면
				sec--;
				break;
			}
			else if (arr[x][y] == 0) { // 사과가 없다면
				arr[x][y] = 2;
				Pair start = length.poll();
				arr[start.x][start.y] = 0; // 길이 유지를 위해 몸 길이 줄이기
			}

			if (index < L && sec == snake[index][0]) { // 방향전환을 해야할 때
				if (snake[index][1] == 'D') { // 오른쪽
					d++;
					if (d > 3)
						d -= 4;
				} else if (snake[index][1] == 'L') {
					d--;
					if (d < 0)
						d += 4;
				}
				index++;
			}
			q.add(new Pair(x, y, d));
		}

		return sec + 1;
	}

	static class Pair {
		int x;
		int y;
		int d;

		public Pair(int x, int y, int d) {
			this.x = x;
			this.y = y;
			this.d = d;
		}
	}
}
