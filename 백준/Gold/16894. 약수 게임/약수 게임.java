import java.io.*;
import java.util.*;

public class Main {
	/**
	 * 10^13 이므로 N은 long
	 * 최적의 방법으로 게임을 한다 -> 다음 사람이 적을 약수는 있지만 내가 적을 약수는 없어야함.
	 * -> 약수 중 소수가 아닌 최솟값을 선택하면 최적의 방법
	 * -> N이 1 혹은 소수라면 구사과의 승리
	 * N이 소수가 아니라면 큐브러버가 승리할 수 있는 조건은 N이 소수 2개의 곱으로 이루어졌을때.
	 */
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		long N = Long.parseLong(br.readLine());
		long cnt = 0;

		for (long i = 2; i <= Math.sqrt(N) && cnt < 2; i++) {
			while (N % i == 0) {
				N /= i;
				cnt++;
			}
		}

		// 현재 줄어든 N이 소수라면
		if (N > 1) {
			cnt++;
		}

		if (cnt != 2) {
			bw.write("koosaga");
		} else {
			bw.write("cubelover");
		}
		bw.flush();
	}
}
