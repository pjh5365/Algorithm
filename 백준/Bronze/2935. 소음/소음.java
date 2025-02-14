import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String A = br.readLine();
		String o = br.readLine();
		String B = br.readLine();

		StringBuilder sb = new StringBuilder();
		if (o.equals("*")) {
			sb.append(A);
			sb.append("0".repeat(B.length() - 1));
		} else {
			if (A.length() == B.length()) {
				sb.append("2");
				sb.append("0".repeat(A.length() - 1));
			} else {
				sb.append("1");
				int max = Math.max(A.length(), B.length());
				int min = Math.min(A.length(), B.length());

				sb.append("0".repeat(Math.max(0, max - min - 1)));
				sb.append("1");
				sb.append("0".repeat(min - 1));
			}
		}

		bw.write(String.valueOf(sb));
		bw.flush();
	}
}
