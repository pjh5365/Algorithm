import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());

		while (N != 0) {
			String s = br.readLine();
			int g = 0;
			int b = 0;
			for (int i = 0; i < s.length(); i++) {
				if (s.charAt(i) == 'g' || s.charAt(i) == 'G') {
					g++;
				} else if (s.charAt(i) == 'b' || s.charAt(i) == 'B') {
					b++;
				}
			}
			sb.append(s).append(" is ");
			if (g > b) {
				sb.append("GOOD").append("\n");
			} else if (g < b) {
				sb.append("A BADDY").append("\n");
			} else {
				sb.append("NEUTRAL").append("\n");
			}
			N--;
		}

		bw.write(String.valueOf(sb));
		bw.newLine();
		bw.flush();
	}
}
