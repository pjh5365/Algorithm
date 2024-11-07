import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		String[] s = new String[3];

		int num = 0;
		for (int i = 0; i < 3; i++) {
			s[i] = br.readLine();

			if (s[i].charAt(0) >= '0' && s[i].charAt(0) <= '9') {
				num = Integer.parseInt(s[i]) + 3 - i;
			}
		}

		if (num % 3 == 0 && num % 5 == 0) {
			sb.append("FizzBuzz").append("\n");
		} else if (num % 3 == 0 && num % 5 != 0) {
			sb.append("Fizz").append("\n");
		} else if (num % 3 != 0 && num % 5 == 0) {
			sb.append("Buzz").append("\n");
		} else {
			sb.append(num).append("\n");
		}

		bw.write(String.valueOf(sb));
		bw.flush();
	}
}
