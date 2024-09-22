import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		Stack<Integer> s1 = new Stack<>();
		Stack<Integer> s2 = new Stack<>();

		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		for (int i = N - 1; i >= 0; i--) {
			s1.add(arr[i]);
		}

		int count = 1;
		while (!s1.isEmpty()) {
			if (s1.peek() == count) { // 현재줄에서 바로 받는경우
				s1.pop();
				count++;
			} else { // 현재 줄에서 받지 못하는경우
				if (!s2.isEmpty() && s2.peek() == count) { // 다른줄에 있다면 다른줄에서 받기
					s2.pop();
					count++;
				} else { // 다른줄도 없다면 현재줄에서 다른줄로 이동
					s2.add(s1.pop());
				}
			}
		}
		while (!s2.isEmpty()) {
			if (s2.peek() == count) { // 다른줄에서 계속 받을 수 있다면
				s2.pop();
				count++;
			} else { // 다른줄에서 받을 수 없다면 종료
				break;
			}
		}

		if (s2.isEmpty()) { // 승환이가 받을 수 있다
			bw.write("Nice");
		} else { // 없다
			bw.write("Sad");
		}
		bw.newLine();
		bw.flush();
	}
}
