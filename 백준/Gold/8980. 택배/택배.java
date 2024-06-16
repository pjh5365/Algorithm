import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(br.readLine());

		Queue<Pair> q = new PriorityQueue<>();
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int count = Integer.parseInt(st.nextToken());
			q.add(new Pair(start, end, count));
		}

		int result = 0;
		int[] box = new int[N + 1];

		while (!q.isEmpty()) {
			Pair now = q.poll();
			int truckSize = 0;

			for (int i = now.start; i < now.end; i++) {
				truckSize = Math.max(truckSize, box[i]); // 이미 실린 최대값 찾기
			}
			int add = Math.min(C - truckSize, now.count); // 빈공간과 실을 수 있는 값 중 최소값을 지금 위치에서 실을 수 있다.
			result += add;

			for (int i = now.start; i < now.end; i++) { // 지나가는 구역에 해당 박스 값 더하기
				box[i] += add;
			}
		}


		bw.write(String.valueOf(result + box[N]));
		bw.flush();
	}

	static class Pair implements Comparable<Pair> {
		int start;
		int end;
		int count;

		public Pair(int start, int end, int count) {
			this.start = start;
			this.end = end;
			this.count = count;
		}


		@Override
		public int compareTo(Pair o) {
			if (this.end < o.end) {
				return -1;
			} else if (this.end > o.end) {
				return 1;
			} else {
				if (this.start < o.start) {
					return -1;
				} else if (this.start > o.start) {
					return 1;
				} else {
					return Integer.compare(o.count, this.count);
				}
			}
		}
	}
}
