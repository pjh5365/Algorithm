import java.io.*;
import java.util.*;

public class Main {

	static long N;
	static long A;
	static long B;
	static long C;
	static long D;
	static long result = Long.MAX_VALUE;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Long.parseLong(st.nextToken());
		A = Long.parseLong(st.nextToken());
		B = Long.parseLong(st.nextToken());
		C = Long.parseLong(st.nextToken());
		D = Long.parseLong(st.nextToken());

		if (C * B > A * D) {
			long tmp = A;
			A = C;
			C = tmp;
			tmp = B;
			B = D;
			D = tmp;
		}

		for (int i = 0; i < A; i++) {
			long a = (long)Math.ceil((double)(N - i * C) / A);

			boolean isOver = false;
			if (a < 0) {
				a = 0;
				isOver = true;
			}

			result = Math.min(result, a * B + i * D);
			if (isOver) {
				break;
			}
		}

		bw.write(String.valueOf(result));
		bw.flush();
	}
}
