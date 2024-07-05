import java.io.*;
import java.util.*;

// 참고: https://mygumi.tistory.com/180
public class Main {

	static int[] result = new int[10];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());
		int start = 1;
		int count = 1; // 자리수

		while (start <= N) {
			// 마지막 숫자의 끝자리가 1이라면 1 -> 0 -> 9를 거쳐 9로 만든다.
			while (N % 10 != 9 && start <= N) { // 마지막숫자의 끝자리를 9로 만들기
				find(N, count);
				N--;
			}

			if (N < start) {
				break;
			}

			// 시작 숫자의 끝자리가 8이라면 8 -> 9 -> 0을 거쳐 0으로 만든다.
			while (start % 10 != 0 && start <= N) { // 시작숫자의 끝자리를 0으로 만들기
				find(start, count);
				start++;
			}

			// 현재 자리수를 찾았으므로 다음 자리수를 찾기 위해 10을 나눠준다. (일의자리 찾고 십의자리를 찾는 형식)
			start /= 10;
			N /= 10;

			for (int i = 0; i < 10; i++) { // 반복되는 등장횟수에 자리수를 곱해서 더한다.
				result[i] += (N - start + 1) * count;
			}
			// 자리수가 한칸 올라가므로 *10
			count *= 10;
		}


		for (int i = 0; i < 10; i++) {
			sb.append(result[i]).append(" ");
		}

		bw.write(String.valueOf(sb));
		bw.flush();
	}

	// 135 -> 136으로 바꾸는 과정은 1350 -> 1360이라 볼 수 있으므로 각 자리별로 10개씩 나온다...
	static void find(int now, int count) {
		while (now > 0) {
			result[now % 10] += count;
			now /= 10;
		}
	}
}
