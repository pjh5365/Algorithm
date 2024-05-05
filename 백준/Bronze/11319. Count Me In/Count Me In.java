import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int S = Integer.parseInt(br.readLine());

		while (S > 0) {
			String input = br.readLine();
			int c = 0;
			int v = 0;
			for (int i = 0; i < input.length(); i++) {
				char now = input.charAt(i);
				if (now == 'a' || now == 'A' || now == 'e' || now == 'E' || now == 'i' || now == 'I' || now == 'o' || now == 'O' || now == 'u' || now == 'U') {
					v++;
				} else if (now != ' ') {
					c++;
				}
 			}
			sb.append(c).append(" ").append(v).append("\n");
			S--;
		}

		bw.write(String.valueOf(sb));
		bw.flush();
	}
}
