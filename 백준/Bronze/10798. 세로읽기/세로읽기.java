import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		String[] s = new String[5];

		int max = 0;
		for (int i = 0; i < 5; i++) {
			s[i] = br.readLine();
			max = Math.max(max, s[i].length());
		}

		for (int i = 0; i < max; i++) {
			for (int j = 0; j < 5; j++) {
				if (s[j].length() > i) {
					sb.append(s[j].charAt(i));
				}
			}
		}

		bw.write(String.valueOf(sb));
		bw.newLine();
		bw.flush();
	}
}
