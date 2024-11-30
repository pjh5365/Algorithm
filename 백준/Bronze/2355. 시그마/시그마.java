import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());

		long min = Math.min(A, B);
		long max = Math.max(A, B);
		long sum = ((max + 1) * max / 2) - ((min - 1) * min / 2);

		bw.write(String.valueOf(sum));
		bw.flush();
	}
}
