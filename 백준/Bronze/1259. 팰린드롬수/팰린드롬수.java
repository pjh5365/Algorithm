import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		String input = br.readLine();

		while (!input.equals("0")) {
			int length = input.length() - 1;
			boolean no = false;
			for (int i = 0; i < input.length() / 2; i++) {
				if (input.charAt(i) != input.charAt(length--)) {
					no = true;
				}
			}
			if (no)
				sb.append("no").append("\n");
			else
				sb.append("yes").append("\n");
			input = br.readLine();
		}
		bw.write(String.valueOf(sb));
		bw.flush();
	}
}
