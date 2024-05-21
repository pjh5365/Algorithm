import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		Stack<Integer> input = new Stack<>();
		Stack<Integer> tmp = new Stack<>();
		Stack<Integer> result = new Stack<>();
		int[] arr = new int[1000001];

		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int now = Integer.parseInt(st.nextToken());
			arr[now]++;
			input.push(now);
		}
		tmp.push(input.peek());
		while (!input.empty()) {
			int now = input.pop();
			while (true) {
				if (!tmp.empty()) { // 임시 스택에 값이 있다면
					int getTmp = tmp.peek();
					if (arr[getTmp] > arr[now]) { // 오등큰수를 발견했다면
						result.push(getTmp);
						tmp.push(now); // 현재값도 오등큰수 후보로 입력
						break;
					} else {
						tmp.pop(); // 오등큰수가 될 수 없으므로 뺴기
					}
				}
				if (tmp.empty()) { // 임시 스택이 비어있다면 오등큰수는 없으므로 -1
					tmp.push(now);
					result.push(-1);
					break;
				}
			}
		}
		while (!result.empty()) {
			sb.append(result.pop()).append(" ");
		}

		bw.write(String.valueOf(sb));
		bw.flush();
	}
}
