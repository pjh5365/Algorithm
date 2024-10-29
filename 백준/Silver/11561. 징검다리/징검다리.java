import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		while (T > 0) {
			long N = Long.parseLong(br.readLine());
			long ret = 0;
			long l = 0;
			long r = (long)1e9;
			while (l <= r) {
				long mid = (l + r) / 2;
				long sum = mid * (1 + mid) / 2;
				if (sum <= N) {
					l = mid + 1;
					ret = Math.max(ret, mid);
				} else {
					r = mid - 1;
				}
			}
			sb.append(ret).append("\n");
			T--;
		}

		bw.write(String.valueOf(sb));
		bw.newLine();
		bw.flush();
	}
}
