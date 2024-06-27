import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());

		int result = 0;
		long num = 1;
		long max = 9876543210L;
		boolean isOk = false;
		while (num <= max && N != 0) {
			StringBuilder now = new StringBuilder(String.valueOf(num));
			boolean check = true;
			for (int i = 1; i < now.length(); i++) {
				if (now.charAt(i - 1) <= now.charAt(i)) {
					check = false;
					if (now.charAt(i - 1) != '9') {
						for (int j = i; j < now.length(); j++) {
							now.replace(j, j + 1, "0");
						}
						now.replace(i - 1, i, String.valueOf((now.charAt(i - 1) + 1) - '0'));
						num = Long.parseLong(String.valueOf(now));
					} else {
						num++;
					}
					break;
				}
			}
			if (check) {
				result++;
				if (result == N) {
					isOk = true;
					break;
				}
				num++;
			}
		}

		if (N == 0) {
			bw.write(String.valueOf(0));
		} else if (isOk) {
			bw.write(String.valueOf(num));
		} else {
			bw.write(String.valueOf(-1));
		}
		bw.flush();
	}
}
