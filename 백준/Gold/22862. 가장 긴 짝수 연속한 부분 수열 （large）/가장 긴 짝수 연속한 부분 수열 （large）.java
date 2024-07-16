import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int[] S = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			S[i] = Integer.parseInt(st.nextToken());
		}

		int count = 0;
		int result = 0;
		int eIndex = 0;
		if (S[0] % 2 == 1) { // 시작점이 홀수라면
			count++;
		}

		for (int i = 0; i < N; i++) {
			while (eIndex < N - 1 && count + S[eIndex + 1] % 2 <= K) {
				eIndex++;
				count += S[eIndex] % 2; // 홀수라면 더하고 짝수라면 넘어가기
			}
			result = Math.max(result, eIndex - i + 1 - count);
			count -= S[i] % 2;
		}

		bw.write(String.valueOf(result));
		bw.flush();
	}
}
