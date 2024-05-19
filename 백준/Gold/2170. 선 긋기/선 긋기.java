import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());

		Pair[] arr = new Pair[N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());

			arr[i] = new Pair(start, end);
		}
		Arrays.sort(arr);

		int result = 0;
		int start = arr[0].start;
		int end = arr[0].end;
		for (int i = 1; i < N; i++) {
			if (end < arr[i].start) {
				result += end - start;
				start = arr[i].start;
			}
			if (end < arr[i].end) {
				end = arr[i].end;
			}
		}
		result += end - start;

		bw.write(String.valueOf(result));
		bw.flush();
	}

	static class Pair implements Comparable<Pair> {
		int start;
		int end;

		public Pair(int start, int end) {
			this.start = start;
			this.end = end;
		}

		@Override
		public int compareTo(Pair o) {
			if (this.start > o.start) {
				return 1;
			} else if (this.start == o.start) {
				return Integer.compare(this.end, o.end);
			} else {
				return -1;
			}
		}
	}
}
