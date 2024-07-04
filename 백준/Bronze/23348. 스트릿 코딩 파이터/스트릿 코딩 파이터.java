import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());

		int N = Integer.parseInt(br.readLine());
		int result = 0;
		while (N > 0) {
			int sum = 0;
			for (int i = 0; i < 3; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());

				sum += (A * a) + (B * b) + (C * c);
			}
			result = Math.max(result, sum);
			N--;
		}

		bw.write(String.valueOf(result));
		bw.flush();
	}
}
