import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		while (T-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			a += Integer.parseInt(st.nextToken());
			b += Integer.parseInt(st.nextToken());
			c += Integer.parseInt(st.nextToken());
			d += Integer.parseInt(st.nextToken());

			if (a < 1) {
				a = 1;
			}
			if (b < 1) {
				b = 1;
			}
			if (c < 0) {
				c = 0;
			}

			int ret = a + 5 * b + 2 * c + 2 * d;
			sb.append(ret).append("\n");
		}

		bw.write(String.valueOf(sb));
		bw.flush();
	}
}
