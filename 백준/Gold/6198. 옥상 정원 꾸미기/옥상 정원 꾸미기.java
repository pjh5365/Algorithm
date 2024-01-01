import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());

		Stack<Integer> s1 = new Stack<>();
		Stack<Building> s2 = new Stack<>();

		for (int i = 0; i < N; i++) {
			s1.push(Integer.parseInt(br.readLine()));
		}

		long result = 0;

		s2.push(new Building(s1.pop(), 0));    // 맨 오른쪽 빌딩 입력

		while (!s1.isEmpty()) {
			int now = s1.pop();
			if (s2.isEmpty()) {
				break;
			}
			Building right = s2.peek();
			if (now > right.h) {    // 현재 빌딩에서 오른쪽 빌딩이 보이는 경우
				right = s2.pop();
				result += right.count;
				long count = right.count + 1;
				if (!s2.isEmpty()) {
					right = s2.peek();
					while (right.h < now) { 	// 지나간 빌딩 중 보이는 게 있다면
						right = s2.pop();
						result += right.count;
						count += right.count + 1;
						if (s2.isEmpty()) {
							break;
						}
						right = s2.peek();
					}
				}
				s2.push(new Building(now, count));    // 빌딩 갱신
			} else {
				s2.push(new Building(now, 0));
			}
		}

		while (!s2.isEmpty()) {
			result += s2.pop().count;
		}

		bw.write(String.valueOf(result));
		bw.flush();
	}

	static class Building {
		int h;    // 빌딩의 높이
		long count;    // 현재 빌딩에서 볼 수 있는 정원 개수

		public Building(int h, long count) {
			this.h = h;
			this.count = count;
		}

		public int getH() {
			return h;
		}

		public long getCount() {
			return count;
		}
	}
}
