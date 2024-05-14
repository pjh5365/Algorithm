import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		Flower[] arr = new Flower[N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int startM = Integer.parseInt(st.nextToken());
			int startD = Integer.parseInt(st.nextToken());
			int endM = Integer.parseInt(st.nextToken());
			int endD = Integer.parseInt(st.nextToken());

			arr[i] = new Flower(startM * 100 + startD, endM * 100 + endD);
		}

		Arrays.sort(arr);
		int start = 301; // 시작일
		int end = 1201; // 종료일
		int max = 0; // 꽃이 연속으로 필 수 있는 날중 가장 마지막날
		int index = 0; // 꽃 인덱스
		int result = 0;
		while (start < end) {
			boolean find = false;
			for (int i = index; i < N; i++) {
				if (arr[i].start > start) { // 앞에 핀 꽃이 진 후라면 불가능
					break;
				}

				if (max < arr[i].end) { // 꽃을 변경할 수 있음
					find = true;
					max = arr[i].end;
					index++;
				}
			}
			if (find) { // 꽃을 찾음
				start = max;
				result++;
			} else { // 적합한 꽃을 찾지 못함
				break;
			}
		}
		if (max < end) {
			bw.write(String.valueOf("0"));
		} else {
			bw.write(String.valueOf(result));
		}
		bw.flush();
	}

	static class Flower implements Comparable<Flower> {
		int start;
		int end;

		public Flower(int start, int end) {
			this.start = start;
			this.end = end;
		}

		@Override
		public int compareTo(Flower o) {
			if (this.start > o.start) {
				return 1;
			} else if (this.start == o.start) {
				return Integer.compare(o.end, this.end);
			} else {
				return -1;
			}
		}
	}
}
