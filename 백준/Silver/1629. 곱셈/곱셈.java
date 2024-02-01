import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());

		long A = Long.parseLong(st.nextToken());
		long B = Long.parseLong(st.nextToken());
		long C = Long.parseLong(st.nextToken());



		bw.write(String.valueOf(recursion(A, B, C)));
		bw.flush();
	}

	static long recursion(long A, long B, long C) {
		if (B == 1)
			return A % C;
		long result = recursion(A, B / 2, C);
		result = result * result % C;
		
		if (B % 2 == 0) // 짝수라면 바로 리턴
			return result;
		// 홀수라면 한번 더 계산한 후 리턴
		return result * A % C;
	}
}
