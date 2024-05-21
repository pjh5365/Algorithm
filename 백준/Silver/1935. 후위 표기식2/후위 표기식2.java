import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];

		String input = br.readLine();
		Stack<Double> s = new Stack<>();

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		for (int i = 0; i < input.length(); i++) {
			char now = input.charAt(i);
			if (now >= 'A' && now <= 'Z') {
				int num = arr[now - 'A'];
				s.push((double)num);
			} else {
				double num1 = s.pop();
				double num2 = s.pop();
				double result = 0;
				if (now == '*') {
					result = num2 * num1;
				} else if (now == '/') {
					result = num2 / num1;
				} else if (now == '+') {
					result = num2 + num1;
				} else if (now == '-') {
					result = num2 - num1;
				}
				s.push(result);
			}
		}

		System.out.printf("%.2f", s.pop());
	}
}
