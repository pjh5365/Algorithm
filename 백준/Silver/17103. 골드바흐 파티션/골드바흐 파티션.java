import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		boolean[] prime = new boolean[1000001];
		prime[0] = prime[1] = true;
		for (int i = 2; i <= Math.sqrt(1000000); i++) {
			if (prime[i]) {
				continue;
			}
			for (int j = i * i; j <= 1000000; j += i) {
				prime[j] = true;
			}
		}

		int T = Integer.parseInt(br.readLine());
		while (T > 0) {
			int N = Integer.parseInt(br.readLine());
			int count = 0;
			for (int i = 2; i <= N / 2; i++) { // 절반까지만 확인하면 순서만 다른 경우는 제외된다.
				if (!prime[i] && !prime[N - i]) { // 소수의 합일때만
					count++;
				}
			}
			sb.append(count).append("\n");
			T--;
		}

		bw.write(String.valueOf(sb));
		bw.flush();
	}
}
