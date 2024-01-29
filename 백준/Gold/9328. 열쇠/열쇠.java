import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		while (T != 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int h = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());

			char[][] arr = new char[h][w];
			ArrayList<Character> key = new ArrayList<>();
			Queue<Pair> enter = new LinkedList<>();

			for (int i = 0; i < h; i++) {
				String input = br.readLine();
				for (int j = 0; j < w; j++) {
					arr[i][j] = input.charAt(j);
					// 입구가 될 수 있는 공간 큐에 삽입
					if ((i == 0 || i == h - 1) && arr[i][j] != '*') {
						if (arr[i][j] <= 'z' && arr[i][j] >= 'a' && !key.contains((char)(arr[i][j] - 32))) // 열쇠로 시작할 때
							key.add((char)(arr[i][j] - 32));
						enter.add(new Pair(i, j));
					}
					if ((j == 0 || j == w - 1) && arr[i][j] != '*') {
						if (arr[i][j] <= 'z' && arr[i][j] >= 'a' && !key.contains((char)(arr[i][j] - 32))) // 열쇠로 시작할 때
							key.add((char)(arr[i][j] - 32));
						enter.add(new Pair(i, j));
					}
				}
			}

			String getKey = br.readLine();
			if (!getKey.equals("0")) {
				for (int i = 0; i < getKey.length(); i++) {
					key.add((char)(getKey.charAt(i) - 32)); // 소문자 키를 찾으면 대문자로 넣기
				}
			}

			int totalCount = 0;
			while (!enter.isEmpty()) {
				int qSize = enter.size();
				int beforeKeySize = key.size();
				for (int i = 0; i < qSize; i++) {
					char[][] copy = new char[h][w];
					for (int j = 0; j < h; j++)
						copy[j] = arr[j].clone();

					Pair poll = enter.poll();
					if (arr[poll.x][poll.y] != '.' && (arr[poll.x][poll.y] <= 'Z' && arr[poll.x][poll.y] >= 'A') && !key.contains(arr[poll.x][poll.y])) { // 문으로 시작하지만 키가 없다면 맨 뒤로 넣기
						enter.add(poll);
						continue;
					}
					if (arr[poll.x][poll.y] == '$') { // 문서로 시작하는 경우
						arr[poll.x][poll.y] = '.';
						totalCount++;
					}
					Result result = bfs(poll, arr, copy, h, w, key);

					if (!result.checkAll) { // 탐색결과 전부 탐색하지 못하면
						enter.add(poll); // 재탐색을 위해 큐에 다시 삽입
					}
					totalCount += result.count;
				}
				int afterKeySize = key.size();
				if (beforeKeySize == afterKeySize)	// 탐색결과 키의 변화가 없다면 더 이상 탐색할 수 없으므로 종료
					break;
			}
			sb.append(totalCount).append("\n");
			T--;
		}

		bw.write(String.valueOf(sb));
		bw.flush();
	}

	static Result bfs(Pair start, char[][] arr, char[][] copy, int h, int w, ArrayList<Character> key) {
		int[] dx = {1, -1, 0, 0};
		int[] dy = {0, 0, 1, -1};
		Queue<Pair> q = new LinkedList<>();
		q.add(start);

		boolean checkAll = true;
		int count = 0;
		while (!q.isEmpty()) {
			Pair poll = q.poll();
			copy[poll.x][poll.y] = '*'; // 방문표시

			for (int i = 0; i < 4; i++) {
				int x = poll.x + dx[i];
				int y = poll.y + dy[i];

				if (x < 0 || x >= h || y < 0 || y >= w) // 범위를 넘어선다면 넘어가기
					continue;
				if (copy[x][y] != '*') { // 벽이 아니라면
					if (copy[x][y] == '$') { // 문서를 발견했다면
						copy[x][y] = '*';
						arr[x][y] = '.'; // 원본에는 길로 변경
						q.add(new Pair(x, y));
						count++;
					} else if (copy[x][y] == '.') {
						copy[x][y] = '*';
						q.add(new Pair(x, y));
					} else if (key.contains(copy[x][y])) { // 키가 있다면
						copy[x][y] = '*'; // 방문표시
						q.add(new Pair(x, y));
					} else if (copy[x][y] <= 'z' && copy[x][y] >= 'a') { // 열쇠를 찾은 경우
						if (!key.contains((char)(copy[x][y] - 32))) // 새로운 열쇠라면 담기
							key.add((char)(copy[x][y] - 32));
						copy[x][y] = '*'; // 방문표시
						q.add(new Pair(x, y));
					} else { // 키가 없어서 이동하지 못하면
						checkAll = false;
					}
				}
			}
		}
		return new Result(checkAll, count);
	}

	static class Pair {
		int x;
		int y;

		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static class Result {
		boolean checkAll;
		int count;

		public Result(boolean checkAll, int count) {
			this.checkAll = checkAll;
			this.count = count;
		}
	}
}
