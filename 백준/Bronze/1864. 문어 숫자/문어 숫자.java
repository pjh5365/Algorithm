import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		while (true) {
			String input = br.readLine();
			if (input.equals("#")) {
				break;
			}
			int ret = 0;

			int now = 0;
			for (int i = 0; i < input.length(); i++) {
				if (input.charAt(i) == '-') {
					now = 0;
				} else if (input.charAt(i) == '\\') {
					now = 1;
				} else if (input.charAt(i) == '(') {
					now = 2;
				} else if (input.charAt(i) == '@') {
					now = 3;
				} else if (input.charAt(i) == '?') {
					now = 4;
				} else if (input.charAt(i) == '>') {
					now = 5;
				} else if (input.charAt(i) == '&') {
					now = 6;
				} else if (input.charAt(i) == '%') {
					now = 7;
				} else if (input.charAt(i) == '/') {
					now = -1;
				}

				ret += now * (int)Math.pow(8, input.length() - 1 - i);
			}
			sb.append(ret).append("\n");
		}

		bw.write(String.valueOf(sb));
		bw.newLine();
		bw.flush();
	}
}
