import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		Stack<Homework> stack = new Stack<>();
		int N = Integer.parseInt(br.readLine());
		int ret = 0;
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			if (a == 1) {
				int b = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				Homework newHomework = new Homework(b, c);
				stack.push(newHomework);
			}
			if (!stack.isEmpty()) {
				Homework top = stack.peek();
				top.time--;
				if (top.time == 0) {
					ret += top.score;
					stack.pop();
				}
			}
		}

		bw.write(String.valueOf(ret));
		bw.flush();
	}

	static class Homework {
		int score;
		int time;

		public Homework(int score, int time) {
			this.score = score;
			this.time = time;
		}
	}
}
