import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());

		long A = Long.parseLong(st.nextToken());
		long B = Long.parseLong(st.nextToken());

		boolean[] isNotPrime = new boolean[10000001]; // 2제곱부터 찾으면 되므로 10^7까지만 소수 구하기

		int result = 0;
		for (int i = 2; i * i <= 10000000; i++) {
			if (!isNotPrime[i]) {
				for (int j = i * i; j <= 10000000; j += i) {
					if (!isNotPrime[j]) {
						isNotPrime[j] = true;
					}
				}
			}
		}

		for (int i = 2; i <= 10000000; i++) {
			if (!isNotPrime[i]) {
				long tmp = i; // A와 B에 i를 나누므로 i부터 시작해야 2제곱임
				while (tmp <= (double) B / i) {
					if (tmp >= (double) A / i) {
						result++;
					}
					tmp *= i;
				}
			}
		}

		bw.write(String.valueOf(result));
		bw.flush();
	}
}
