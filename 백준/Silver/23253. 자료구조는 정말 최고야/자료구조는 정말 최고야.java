import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		boolean check = true;

		ArrayList<Stack<Integer>> arr = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			arr.add(new Stack<>());
		}
		for (int i = 0; i < M; i++) {
			int k = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			Stack<Integer> s = arr.get(i);
			for (int j = 0; j < k; j++) {
				Integer now = Integer.valueOf(st.nextToken());
				if (!s.isEmpty() && s.peek() < now) {
					check = false;
				}
				s.add(now);
			}
		}

		if (check) {
			bw.write("Yes");
		} else {
			bw.write("No");
		}
		bw.flush();
	}
}
