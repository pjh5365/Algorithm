import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		while (T > 0) {
			int n = Integer.parseInt(br.readLine());
			boolean[] close = new boolean[n + 1];

			for (int i = 2; i <= n; i++) {
				for (int j = i; j <= n; j += i) {
					close[j] = !close[j];
				}
			}

			int result = 0;
			for (int i = 1; i <= n; i++) {
				if (!close[i]) {
					result++;
				}
			}
			sb.append(result).append("\n");
			T--;
		}

		bw.write(String.valueOf(sb));
		bw.flush();
	}
}
