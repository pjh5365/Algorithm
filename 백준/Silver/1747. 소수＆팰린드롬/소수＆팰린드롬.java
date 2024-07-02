import java.io.*;
import java.util.*;

public class Main {

	static boolean[] isNotPrime;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		isNotPrime = new boolean[2000001];
		isNotPrime[0] = isNotPrime[1] = true;
		findPrime();

		int N = Integer.parseInt(br.readLine());
		int result = 0;

		for (int i = N; i < 2000000; i++) {
			if (!isNotPrime[i]) {
				String tmp = String.valueOf(i);
				boolean isFail = false;
				for (int j = 0; j <= tmp.length() / 2; j++) {
					if (tmp.charAt(j) != tmp.charAt(tmp.length() - 1 - j)) {
						isFail = true;
						break;
					}
				}
				if (!isFail) {
					result = i;
					break ;
				}
			}
		}
		bw.write(String.valueOf(result));
		bw.flush();
	}

	static void findPrime() {
		for (int i = 2; i < 2000000; i++) {
			if (!isNotPrime[i]) {
				for (int j = 2 * i; j < 2000000; j += i) {
					isNotPrime[j] = true;
				}
			}
		}
	}
}
