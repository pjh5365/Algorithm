import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		while (n > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			int gcd = gcd(Math.max(a, b), Math.min(a, b));

			long result = (long)a * b / gcd;
			sb.append(result).append("\n");
			n--;
		}

		bw.write(String.valueOf(sb));
		bw.flush();
	}

	static int gcd(int a, int b) {
		if (b == 0) {
			return a;
		}
		return gcd(b, a % b);
	}
}
