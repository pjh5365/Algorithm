import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		Stack<Integer> stack = new Stack<>();
		int N = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; i++) {
			stack.add(Integer.valueOf(br.readLine()));
		}
		int ret = 1;
        int max = stack.pop();
		while (!stack.isEmpty()) {
			if (stack.peek() > max) {
				ret++;
			}
			max = Math.max(max, stack.peek());
			stack.pop();
		}

		bw.write(String.valueOf(ret));
		bw.flush();
	}
}
