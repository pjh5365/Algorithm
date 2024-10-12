import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; i++) {
			String input = br.readLine();

			int tmp = input.charAt(input.length() - 1) - '0';
			if (tmp % 2 == 0) {
				sb.append("even");
			} else {
				sb.append("odd");
			}
			sb.append("\n");
		}

		bw.write(String.valueOf(sb));
		bw.newLine();
		bw.flush();
	}
}
