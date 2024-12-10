import java.io.*;
import java.util.*;

public class Main {

	static int ret = 0;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		while (true) {
			String s = br.readLine();
			if (s.equals("#")) {
				break;
			}
			s = s.toLowerCase();

			int cnt = 0;
			for (int i = 2; i < s.length(); i++) {
				if (s.charAt(i) == s.charAt(0)) {
					cnt++;
				}
			}

			sb.append(s.charAt(0)).append(" ").append(cnt).append("\n");
		}


		bw.write(String.valueOf(sb));
		bw.flush();
	}
}
