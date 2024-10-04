import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < 5; i++) {
			String input = br.readLine();
			if (input.contains("FBI")) {
				sb.append(i + 1).append(" ");
			}
		}

		if (sb.length() == 0) {
			sb.append("HE GOT AWAY!");
		}

		sb.append("\n");
		bw.write(String.valueOf(sb));
		bw.newLine();
		bw.flush();
	}
}
