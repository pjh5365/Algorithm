import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());

		boolean[] isPrime = new boolean[N + 1];

		for (int i = 0; i < N + 1; i++) {
			isPrime[i] = true;
		}
		isPrime[0] = isPrime[1] = false;
		for (int i = 2; i <= N; i++) {
			if (isPrime[i]) {
				for (int j = 2 * i; j <= N; j += i) {
					isPrime[j] = false;
				}
			}
		}

		int result = 0;
		int sIndex = 2;
		int firstPrime = 0;
		for (int i = 2; i <= N; i++) {
			int sum = 0;
			int count = 0;
			for (int j = sIndex; j <= N; j++) {
				if (isPrime[j]) {
					count++;
					if (count == 1) {
						firstPrime = j;
					}
					sum += j;
					if (sum == N) {
						result++;
						sIndex = firstPrime + 1;
						break;
					} else if (sum > N) {
						sIndex++;
						break;
					}
				}
			}
		}

		bw.write(String.valueOf(result));
		bw.flush();
	}
}
